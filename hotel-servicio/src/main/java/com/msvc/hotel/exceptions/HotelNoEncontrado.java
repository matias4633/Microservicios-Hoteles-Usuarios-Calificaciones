package com.msvc.hotel.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelNoEncontrado extends RuntimeException{

    public HotelNoEncontrado(){
        super("Hotel no encontrado");
    }
    public HotelNoEncontrado(String msj){
        super(msj);
    }
}
