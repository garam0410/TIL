package com.example.customtablegeneratorproject.component;

import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.id.enhanced.AccessCallback;
import org.hibernate.id.enhanced.InitialValueAwareOptimizer;
import org.hibernate.id.enhanced.PooledOptimizer;
import org.hibernate.internal.CoreMessageLogger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class CustomOptimizer {

    private static final CoreMessageLogger log = (CoreMessageLogger)Logger.getMessageLogger(CoreMessageLogger.class, PooledOptimizer.class.getName());
    private long initialValue = 10L;
    private CustomOptimizer.GenerationState noTenantState;
    private Map<String, CustomOptimizer.GenerationState> tenantSpecificState;

    private final int incrementSize = 10;

    private SequenceGenerator sequenceGenerator;

    public synchronized Serializable generate(long sequence, AccessCallback callback) {
        CustomOptimizer.GenerationState generationState = this.locateGenerationState(callback.getTenantIdentifier());
        if (generationState.hiValue == null) {
            generationState.hiValue = callback.getNextValue();
            if (generationState.hiValue.lt(1L)) {
                log.pooledOptimizerReportedInitialValue(generationState.hiValue);
            }

            if ((this.initialValue != -1L || !generationState.hiValue.lt((long)this.incrementSize)) && !generationState.hiValue.eq(this.initialValue)) {
                generationState.value = generationState.hiValue.copy().subtract((long)(this.incrementSize - 1));
            } else {
                generationState.value = generationState.hiValue.copy();
            }
        } else if (generationState.value.gt(generationState.hiValue)) {
            generationState.hiValue = callback.getNextValue();
            generationState.value = generationState.hiValue.copy().subtract((long)(this.incrementSize - 1));
        }

        sequenceGenerator = SpringApplicationContext.getBean(SequenceGenerator.class);
        return sequenceGenerator.nextId(generationState.value);

//        return generationState.value.makeValueThenIncrement();
    }

    private CustomOptimizer.GenerationState locateGenerationState(String tenantIdentifier) {
        if (tenantIdentifier == null) {
            if (this.noTenantState == null) {
                this.noTenantState = new CustomOptimizer.GenerationState();
            }

            return this.noTenantState;
        } else {
            CustomOptimizer.GenerationState state;
            if (this.tenantSpecificState == null) {
                this.tenantSpecificState = new ConcurrentHashMap();
                state = new CustomOptimizer.GenerationState();
                this.tenantSpecificState.put(tenantIdentifier, state);
            } else {
                state = (CustomOptimizer.GenerationState)this.tenantSpecificState.get(tenantIdentifier);
                if (state == null) {
                    state = new CustomOptimizer.GenerationState();
                    this.tenantSpecificState.put(tenantIdentifier, state);
                }
            }

            return state;
        }
    }

    private CustomOptimizer.GenerationState noTenantGenerationState() {
        if (this.noTenantState == null) {
            throw new IllegalStateException("Could not locate previous generation state for no-tenant");
        } else {
            return this.noTenantState;
        }
    }

    public IntegralDataTypeHolder getLastSourceValue() {
        return this.noTenantGenerationState().hiValue;
    }

    public boolean applyIncrementSizeToSourceValues() {
        return true;
    }

    public IntegralDataTypeHolder getLastValue() {
        return this.noTenantGenerationState().value.copy().decrement();
    }

    public void injectInitialValue(long initialValue) {
        this.initialValue = initialValue;
    }

    private static class GenerationState {
        private IntegralDataTypeHolder hiValue;
        private IntegralDataTypeHolder value;

        private GenerationState() {
        }
    }
}
