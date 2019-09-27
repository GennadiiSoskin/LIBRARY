package com.entity;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


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

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//       private Set<Book> bookList;



}