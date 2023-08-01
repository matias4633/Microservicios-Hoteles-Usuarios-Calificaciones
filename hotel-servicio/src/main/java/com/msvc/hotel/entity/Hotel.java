package com.msvc.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel {
    @Id
    private String id;

    private String nombre;

    private String informacion;

    private String ubicacion;

    private Integer estrellas;

}
