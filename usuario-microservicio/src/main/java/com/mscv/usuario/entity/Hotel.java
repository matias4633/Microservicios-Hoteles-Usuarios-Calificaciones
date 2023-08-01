package com.mscv.usuario.entity;

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

public class Hotel {

    private String id;

    private String nombre;

    private String informacion;

    private String ubicacion;

    private Integer estrellas;

}