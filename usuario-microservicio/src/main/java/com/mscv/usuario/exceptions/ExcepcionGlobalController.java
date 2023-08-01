package com.mscv.usuario.exceptions;

import com.mscv.usuario.exceptions.ObjetoNoEncontrado;
import com.mscv.usuario.response.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Indica que esta clase define el comportamiento de las excepciones Rest
public class ExcepcionGlobalController {
    @ExceptionHandler(ObjetoNoEncontrado.class)
    public ResponseEntity<ApiResponse> handlerObjetoNoEncontrado(@NotNull ObjetoNoEncontrado objetoNoEncontrado){
        String mensaje = objetoNoEncontrado.getMessage();
        ApiResponse respuesta = new ApiResponse().builder()
                .mensaje(mensaje)
                .status(HttpStatus.NOT_FOUND)
                .exito(true)
                .build();

        return new ResponseEntity<>(respuesta,HttpStatus.NOT_FOUND);
    }
}
