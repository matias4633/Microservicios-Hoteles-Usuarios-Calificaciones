package com.msvc.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(HotelNoEncontrado.class)
    public ResponseEntity<Map<String,Object>> manejadorHotelNoEncontrado(HotelNoEncontrado hotelNoEncontrado){
        Map map = new HashMap();
        map.put("mensaje", hotelNoEncontrado.getMessage());
        map.put("exito", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
