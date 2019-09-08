package com.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "genre")
public class Genre extends BaseEntity {

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @OneToMany(mappedBy = "genre")
    private List<Book> bookList;
}
