package com.mscv.usuario.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjetoNoEncontrado extends RuntimeException{
    String mensaje;
    public ObjetoNoEncontrado(){
        super("El recurso no existe.");
    }
    public ObjetoNoEncontrado(String mensaje){
        super(mensaje);
    }
}
