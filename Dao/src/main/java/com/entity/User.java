package com.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")

public class User extends BaseEntity {


    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column
    private String password;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

}