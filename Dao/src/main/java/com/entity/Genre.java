package com.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "genre")
public class Genre extends BaseEntity{

    @Column
   private String name;

    @OneToMany(mappedBy = "genre")
    private List<Book> bookList;
}
