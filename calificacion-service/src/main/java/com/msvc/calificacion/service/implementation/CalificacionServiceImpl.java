package com.msvc.calificacion.service.implementation;

import com.msvc.calificacion.entity.Calificacion;
import com.msvc.calificacion.repository.CalificacionRepository;
import com.msvc.calificacion.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalificacionServiceImpl implements CalificacionService {
    @Autowired
    private CalificacionRepository repository;

    @Override
    public Calificacion create(Calificacion calificacion) {
        return repository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificaciones() {
        return repository.findAll();
    }

    @Override
    public List<Calificacion> getCalificacionesByUsuarioId(String usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
