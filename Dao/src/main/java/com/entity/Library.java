package com.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "library")
public class Library extends BaseEntity {

    @Column
    private String name;

//    @OneToMany(mappedBy = "library")
//    private List<Book> bookList;
}
