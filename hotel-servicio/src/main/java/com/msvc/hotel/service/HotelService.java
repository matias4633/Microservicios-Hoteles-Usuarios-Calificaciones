package com.msvc.hotel.service;

import com.msvc.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {
   List<Hotel> getAll();

   Hotel create(Hotel hotel);

   Hotel create(Hotel hotel , Integer estrellas);

   Hotel get(String id);
}
