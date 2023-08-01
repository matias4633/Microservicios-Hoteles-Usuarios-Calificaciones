package com.mscv.usuario.externo.servicio;

import com.mscv.usuario.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICIO") //nombre de la config del microservicio en application.yml
public interface HotelServicio {
    @GetMapping("/hoteles/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
