package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @Column
    private String name;

    @Column
    private int volume;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "library")
    private Library library;
}
