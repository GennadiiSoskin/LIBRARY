package com.entity;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "user")

public class User
//        extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column
    private String password;

//    @NotEmpty
    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;


}