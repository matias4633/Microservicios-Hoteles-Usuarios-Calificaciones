package com.msvc.hotel.service.implementaciones;

import com.msvc.hotel.entity.Hotel;
import com.msvc.hotel.exceptions.HotelNoEncontrado;
import com.msvc.hotel.repository.HotelRepository;
import com.msvc.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository repository;

    @Override
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @Override
    public Hotel create(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        repository.save(hotel);
        return hotel;
    }
    @Override
    public Hotel create(Hotel hotel , Integer estrellas) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        hotel.setEstrellas(estrellas);
        repository.save(hotel);
        return hotel;
    }

    @Override
    public Hotel get(String id) {
        return repository.findById(id).orElseThrow( ()->new HotelNoEncontrado("Hotel no encotrado con id "+id));
    }
}
