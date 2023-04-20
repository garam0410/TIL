package com.example.customtablegeneratorproject.core.domain;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@ToString
@Getter
public class BaseEntity implements Serializable {
    @Id
//    @GenericGenerator(name = "global_seq_id", strategy = "com.example.customtablegeneratorproject.component.CustomGenerator")
//    @GeneratedValue(generator = "global_seq_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl-gen")
    @TableGenerator(
            name = "tbl-gen",
            table = "table_ids",
            pkColumnName = "entity_name",
            valueColumnName = "entity_next_value",
            initialValue = 0,
            allocationSize = 10
    )
    private Long id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (id == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!id.equals(other.getId())) {
            return false;
        }
        return true;
    }
}
