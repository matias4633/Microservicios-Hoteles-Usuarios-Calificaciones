package com.mscv.usuario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Calificacion {

    private String calificacionId;

    private String usuarioId;

    private String hotelId;

    private Integer calificacion;

    private String observaciones;

    private Hotel hotel;
}
