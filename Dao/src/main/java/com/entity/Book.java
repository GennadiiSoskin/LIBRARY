package com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

//    @NotEmpty
    @Column
    private String name;

//    @NotEmpty
    @Column
    private long volume;

//    @NotEmpty
    @Column
    private long genre;

//    @NotEmpty
    @Column
    private long library;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "fk_book_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_user_id"))
    private User user;
}
