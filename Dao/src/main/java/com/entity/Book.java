package com.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "book")
public class Book extends BaseEntity {
    @Column
    private String name;

    @Column
    private long volume;

    @Column
    private long genre;

    @Column
    private long library;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_book",
            joinColumns = @JoinColumn(name = "fk_book_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_user_id"))
    private User user;
}
