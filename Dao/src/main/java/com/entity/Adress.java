package com.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class Adress {
    @Column
    private String street;
    @Column
    private String houseNomber;
}
