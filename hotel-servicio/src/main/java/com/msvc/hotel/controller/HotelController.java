package com.msvc.hotel.controller;

import com.msvc.hotel.entity.Hotel;
import com.msvc.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelController {
    @Autowired
    private HotelService servicio;
    @PostMapping
    public ResponseEntity<Hotel> guardarHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.create(hotel));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> listarHoteles(){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.getAll());
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> buscarPorId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.get(hotelId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Hotel> buscarPorIdConParametro(@RequestParam String id){
        return ResponseEntity.status(HttpStatus.OK).body(servicio.get(id));
    }
    @PostMapping("/guardar")
    public ResponseEntity<Hotel> guardarHotelConParametro(@RequestBody Hotel hotel ,@RequestParam Integer estrellas){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.create(hotel , estrellas));
    }
}
