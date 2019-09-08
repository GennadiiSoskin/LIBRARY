package com.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column
    private String name;
    @Column
    private String password;
    @Embedded
    private Adress adress;
//    @ManyToMany
//    @JoinTable(name = "user_request",
//            joinColumns = @JoinColumn(name = "fk_user_id"),
//            inverseJoinColumns = @JoinColumn(name = "fk_book_id")
//    )
//    private List<Book> bookList;
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}
