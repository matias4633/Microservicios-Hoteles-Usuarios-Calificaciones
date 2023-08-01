package com.msvc.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    @GetMapping
    public List<String> listarEmpleados(){
        return Arrays.asList("EMpleado1", "empleado2");
    }
}
