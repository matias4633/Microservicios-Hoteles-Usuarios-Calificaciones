package com.msvc.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Rutas {
    @RequestMapping(value = "/Inicio")
    public String imprimirInicio(){
        return "Inicio";
    }
}
