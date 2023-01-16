package com.example.customtablegeneratorproject.component;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.boot.MappingException;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.*;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.config.spi.StandardConverters;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.hibernate.engine.spi.SessionEventListenerManager;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.ExportableColumn;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.id.enhanced.AccessCallback;
import org.hibernate.id.enhanced.Optimizer;
import org.hibernate.id.enhanced.OptimizerFactory;
import org.hibernate.internal.CoreMessageLogger;
import org.hibernate.internal.util.StringHelper;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.jdbc.AbstractReturningWork;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PrimaryKey;
import org.hibernate.mapping.Table;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

@Component
public class CustomGenerator implements PersistentIdentifierGenerator {

    private static final CoreMessageLogger logger = (CoreMessageLogger) Logger.getMessageLogger(CoreMessageLogger.class, org.hibernate.id.enhanced.TableGenerator.class.getName());
    private boolean storeLastUsedValue;
    private Type identifierType;
    private QualifiedName qualifiedTableName;
    private QualifiedName physicalTableName;
    private String segmentColumnName = "entity_tbl_name";   // key
    private String segmentValue;
    private int segmentValueLength;
    private String valueColumnName = "sequence_next_hi_value"; // value
    private int initialValue;
    private int incrementSize = 1;
    private String selectQuery;
    private String insertQuery;
    private String updateQuery;

    private SequenceGenerator sequenceGenerator;

    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        this.storeLastUsedValue = (Boolean) ((ConfigurationService) serviceRegistry.getService(ConfigurationService.class)).getSetting("hibernate.id.generator.stored_last_used", StandardConverters.BOOLEAN, true);
        this.identifierType = type;
        JdbcEnvironment jdbcEnvironment = (JdbcEnvironment) serviceRegistry.getService(JdbcEnvironment.class);
        this.qualifiedTableName = this.determineGeneratorTableName(params, jdbcEnvironment, serviceRegistry);
        this.valueColumnName = this.determineValueColumnName(params, jdbcEnvironment);
        this.segmentValue = this.determineSegmentValue(params);
        this.segmentValueLength = this.determineSegmentColumnSize(params);
        this.initialValue = this.determineInitialValue(params);
    }

    protected QualifiedName determineGeneratorTableName(Properties params, JdbcEnvironment jdbcEnvironment, ServiceRegistry serviceRegistry) {
        String fallbackTableName = "hibernate_sequences";
        Boolean preferGeneratorNameAsDefaultName = (Boolean) ((ConfigurationService) serviceRegistry.getService(ConfigurationService.class)).getSetting("hibernate.model.generator_name_as_sequence_name", StandardConverters.BOOLEAN, true);
        String tableName;
        if (preferGeneratorNameAsDefaultName) {
            tableName = params.getProperty("GENERATOR_NAME");
            if (StringHelper.isNotEmpty(tableName)) {
                fallbackTableName = tableName;
            }
        }

        tableName = ConfigurationHelper.getString("table_name", params, fallbackTableName);
        if (tableName.contains(".")) {
            return QualifiedNameParser.INSTANCE.parse(tableName);
        } else {
            Identifier catalog = jdbcEnvironment.getIdentifierHelper().toIdentifier(ConfigurationHelper.getString("catalog", params));
            Identifier schema = jdbcEnvironment.getIdentifierHelper().toIdentifier(ConfigurationHelper.getString("schema", params));
            return new QualifiedNameParser.NameParts(catalog, schema, jdbcEnvironment.getIdentifierHelper().toIdentifier(tableName));
        }
    }

    protected String determineValueColumnName(Properties params, JdbcEnvironment jdbcEnvironment) {
        String name = ConfigurationHelper.getString("value_column_name", params, "next_val");
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(name).render(jdbcEnvironment.getDialect());
    }

    protected String determineSegmentValue(Properties params) {
        String segmentValue = params.getProperty("segment_value");
        if (StringHelper.isEmpty(segmentValue)) {
            segmentValue = this.determineDefaultSegmentValue(params);
        }

        return segmentValue;
    }

    protected String determineDefaultSegmentValue(Properties params) {
        String defaultToUse = params.getProperty("target_table");
        logger.usingDefaultIdGeneratorSegmentValue(this.qualifiedTableName.render(), this.segmentColumnName, defaultToUse);
        return defaultToUse;
    }

    protected int determineSegmentColumnSize(Properties params) {
        return ConfigurationHelper.getInt("segment_value_length", params, 255);
    }

    protected int determineInitialValue(Properties params) {
        return ConfigurationHelper.getInt("initial_value", params, 1);
    }

    protected String buildSelectQuery(String formattedPhysicalTableName, SqlStringGenerationContext context) {
        String alias = "tbl";
        String query = "select " + StringHelper.qualify("tbl", this.valueColumnName) + " from " + formattedPhysicalTableName + ' ' + "tbl" + " where " + StringHelper.qualify("tbl", this.segmentColumnName) + "=?";
        LockOptions lockOptions = new LockOptions(LockMode.PESSIMISTIC_WRITE);
        lockOptions.setAliasSpecificLockMode("tbl", LockMode.PESSIMISTIC_WRITE);
        Map updateTargetColumnsMap = Collections.singletonMap("tbl", new String[]{this.valueColumnName});
        return context.getDialect().applyLocksToSql(query, lockOptions, updateTargetColumnsMap);
    }

    protected String buildUpdateQuery(String formattedPhysicalTableName) {
        return "update " + formattedPhysicalTableName + " set " + this.valueColumnName + "=?  where " + this.valueColumnName + "=? and " + this.segmentColumnName + "=?";
    }

    protected String buildInsertQuery(String formattedPhysicalTableName) {
        return "insert into " + formattedPhysicalTableName + " (" + this.segmentColumnName + ", " + this.valueColumnName + ")  values (?,?)";
    }

    protected InitCommand generateInsertInitCommand(SqlStringGenerationContext context) {
        String renderedTableName = context.format(this.physicalTableName);
        int value = this.initialValue;
        if (this.storeLastUsedValue) {
            value = this.initialValue - 1;
        }

        return new InitCommand(new String[]{"insert into " + renderedTableName + "(" + this.segmentColumnName + ", " + this.valueColumnName + ") values ('" + this.segmentValue + "'," + value + ")"});
    }

    private IntegralDataTypeHolder makeValue() {
        return IdentifierGeneratorHelper.getIntegralDataTypeHolder(this.identifierType.getReturnedClass());
    }

    public Serializable generate(final SharedSessionContractImplementor session, Object obj) {
        final SqlStatementLogger statementLogger = ((JdbcServices) session.getFactory().getServiceRegistry().getService(JdbcServices.class)).getSqlStatementLogger();
        final SessionEventListenerManager statsCollector = session.getEventListenerManager();

        sequenceGenerator = SpringApplicationContext.getBean(SequenceGenerator.class);
        return sequenceGenerator.nextId(new AccessCallback() {
            public IntegralDataTypeHolder getNextValue() {
                return (IntegralDataTypeHolder) session.getTransactionCoordinator().createIsolationDelegate().delegateWork(new AbstractReturningWork<IntegralDataTypeHolder>() {
                    public IntegralDataTypeHolder execute(Connection connection) throws SQLException {
                        IntegralDataTypeHolder value = makeValue();

                        int rows;
                        do {
                            PreparedStatement updatePS;
                            try {
                                updatePS = prepareStatement(connection, selectQuery, statementLogger, statsCollector);

                                try {
                                    updatePS.setString(1, segmentValue);
                                    ResultSet selectRS = executeQuery(updatePS, statsCollector);
                                    if (!selectRS.next()) {
                                        long initializationValue;
                                        if (storeLastUsedValue) {
                                            initializationValue = (long) (initialValue - 1);
                                        } else {
                                            initializationValue = (long) initialValue;
                                        }

                                        value.initialize(initializationValue);
                                        PreparedStatement insertPS = prepareStatement(connection, insertQuery, statementLogger, statsCollector);

                                        try {
                                            logger.tracef("binding parameter [%s] - [%s]", 1, segmentValue);
                                            insertPS.setString(1, segmentValue);
                                            value.bind(insertPS, 2);
                                            executeUpdate(insertPS, statsCollector);
                                        } catch (Throwable var15) {
                                            if (insertPS != null) {
                                                try {
                                                    insertPS.close();
                                                } catch (Throwable var13) {
                                                    var15.addSuppressed(var13);
                                                }
                                            }

                                            throw var15;
                                        }

                                        if (insertPS != null) {
                                            insertPS.close();
                                        }
                                    } else {
                                        byte defaultValue;
                                        if (storeLastUsedValue) {
                                            defaultValue = 0;
                                        } else {
                                            defaultValue = 1;
                                        }

                                        value.initialize(selectRS, (long) defaultValue);
                                    }

                                    selectRS.close();
                                } catch (Throwable var16) {
                                    if (updatePS != null) {
                                        try {
                                            updatePS.close();
                                        } catch (Throwable var12) {
                                            var16.addSuppressed(var12);
                                        }
                                    }

                                    throw var16;
                                }

                                if (updatePS != null) {
                                    updatePS.close();
                                }
                            } catch (SQLException var17) {
                                logger.unableToReadOrInitHiValue(var17);
                                throw var17;
                            }

                            try {
                                updatePS = prepareStatement(connection, updateQuery, statementLogger, statsCollector);

                                try {
                                    IntegralDataTypeHolder updateValue = value.copy();
                                    updateValue.add((long) incrementSize);

                                    updateValue.bind(updatePS, 1);
                                    value.bind(updatePS, 2);
                                    updatePS.setString(3, segmentValue);
                                    rows = executeUpdate(updatePS, statsCollector);
                                } catch (Throwable var14) {
                                    if (updatePS != null) {
                                        try {
                                            updatePS.close();
                                        } catch (Throwable var11) {
                                            var14.addSuppressed(var11);
                                        }
                                    }

                                    throw var14;
                                }

                                if (updatePS != null) {
                                    updatePS.close();
                                }
                            } catch (SQLException var18) {
                                logger.unableToUpdateQueryHiValue(physicalTableName.render(), var18);
                                throw var18;
                            }
                        } while (rows == 0);

                        return value;
                    }
                }, true);
            }

            public String getTenantIdentifier() {
                return session.getTenantIdentifier();
            }
        });
    }

    private PreparedStatement prepareStatement(Connection connection, String sql, SqlStatementLogger statementLogger, SessionEventListenerManager statsCollector) throws SQLException {
        statementLogger.logStatement(sql, FormatStyle.BASIC.getFormatter());

        PreparedStatement var5;
        try {
            statsCollector.jdbcPrepareStatementStart();
            var5 = connection.prepareStatement(sql);
        } finally {
            statsCollector.jdbcPrepareStatementEnd();
        }

        return var5;
    }

    private int executeUpdate(PreparedStatement ps, SessionEventListenerManager statsCollector) throws SQLException {
        int var3;
        try {
            statsCollector.jdbcExecuteStatementStart();
            var3 = ps.executeUpdate();
        } finally {
            statsCollector.jdbcExecuteStatementEnd();
        }

        return var3;
    }

    private ResultSet executeQuery(PreparedStatement ps, SessionEventListenerManager statsCollector) throws SQLException {
        ResultSet var3;
        try {
            statsCollector.jdbcExecuteStatementStart();
            var3 = ps.executeQuery();
        } finally {
            statsCollector.jdbcExecuteStatementEnd();
        }

        return var3;
    }

    public void registerExportables(Database database) {
        Dialect dialect = database.getJdbcEnvironment().getDialect();
        Namespace namespace = database.locateNamespace(this.qualifiedTableName.getCatalogName(), this.qualifiedTableName.getSchemaName());
        Table table = namespace.locateTable(this.qualifiedTableName.getObjectName());
        if (table == null) {
            table = namespace.createTable(this.qualifiedTableName.getObjectName(), false);
            Column segmentColumn = new ExportableColumn(database, table, this.segmentColumnName, StringType.INSTANCE, dialect.getTypeName(12, (long) this.segmentValueLength, 0, 0));
            segmentColumn.setNullable(false);
            table.addColumn(segmentColumn);
            table.setPrimaryKey(new PrimaryKey(table));
            table.getPrimaryKey().addColumn(segmentColumn);
            Column valueColumn = new ExportableColumn(database, table, this.valueColumnName, LongType.INSTANCE);
            table.addColumn(valueColumn);
        }

        this.physicalTableName = table.getQualifiedTableName();
        table.addInitCommand(this::generateInsertInitCommand);
    }

    public void initialize(SqlStringGenerationContext context) {
        String formattedPhysicalTableName = context.format(this.physicalTableName);
        this.selectQuery = this.buildSelectQuery(formattedPhysicalTableName, context);
        this.updateQuery = this.buildUpdateQuery(formattedPhysicalTableName);
        this.insertQuery = this.buildInsertQuery(formattedPhysicalTableName);
    }
}
