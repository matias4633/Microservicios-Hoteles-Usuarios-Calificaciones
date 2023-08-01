package com.mscv.usuario.externo.servicio;

import com.mscv.usuario.entity.Calificacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CALIFICACION-SERVICIO")
public interface CalificacionServicio {
    @GetMapping("/calificaciones/usuarios/{usuarioId}")
    List<Calificacion> getCalificaciones(@PathVariable String usuarioId);
}
