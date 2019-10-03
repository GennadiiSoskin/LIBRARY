package com.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;


@Embeddable
@Data
public class Address {
    @Column
//    @NotEmpty
    private String street;
    @Column
//    @NotEmpty
    private String houseNumber;
}
