package com.entity;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "role")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "my-cache")
public class Role extends BaseEntity {

    @Column
    private String name;
}
