package com.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book extends BaseEntity{

    @Column
    private String name;

    @Column
    private int volume;

    @ManyToOne
    @JoinColumn(name = "id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "id")
    private Library library;
}
