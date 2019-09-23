package com.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "library")
public class Library extends BaseEntity {

    @NotEmpty
    @Column
    private String name;

    @OneToMany(mappedBy = "library")
    private List<Book> bookList;

    @Embedded
    private Address address;

}
