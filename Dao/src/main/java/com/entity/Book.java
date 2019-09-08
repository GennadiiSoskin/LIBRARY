package com.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "book")
public class Book extends BaseEntity {

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column
    private long volume;

    @NotEmpty
    @Column
    private long genre;

    @NotEmpty
    @Column
    private long library;
}
