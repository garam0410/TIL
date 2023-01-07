package com.kgr.responsebodyadviceexample.core.domain;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import java.io.Serializable;

@MappedSuperclass
@ToString
@Getter
public class BaseEntity implements Serializable {
    @Id
    @GenericGenerator(name = "global_seq_id", strategy = "com.kgr.responsebodyadviceexample.core.component.SnowFlakeGenerator")
    @GeneratedValue(generator = "global_seq_id")
    private Long id;
}
