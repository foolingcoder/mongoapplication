package com.mns.mongoapplication.service;

import java.util.List;

import com.mns.mongoapplication.domain.Hotel;

/**
 *
 * @author ganesh
 */
public interface HotelService {
    List<Hotel> getAllHotels();

    void saveHotels(Hotel hotel);

    void updateHotel(String id, Hotel hotel);

    void updateHotel(Hotel hotel);

    void deleteHotel(String id);

    List<Hotel> findAllHotelByCity(String city);

    Hotel findById(String id);
}
