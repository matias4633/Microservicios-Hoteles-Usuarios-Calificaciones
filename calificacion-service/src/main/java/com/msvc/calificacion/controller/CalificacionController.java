package com.msvc.calificacion.controller;

import com.msvc.calificacion.entity.Calificacion;
import com.msvc.calificacion.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService servicio;
    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(@RequestBody Calificacion cal){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.create(cal));
    }
    @GetMapping
    public ResponseEntity<List<Calificacion>> listarCalificaciones(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.getCalificaciones());
    }
    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarPorUsuarioId(@PathVariable String usuarioId){
        return ResponseEntity.ok(servicio.getCalificacionesByUsuarioId(usuarioId));
    }
    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarPorHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(servicio.getCalificacionesByHotelId(hotelId));
    }

}
