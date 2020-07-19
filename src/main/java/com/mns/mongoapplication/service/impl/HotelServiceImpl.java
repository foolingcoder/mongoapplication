package com.mns.mongoapplication.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mns.mongoapplication.controller.NotFoundException;
import com.mns.mongoapplication.domain.Hotel;
import com.mns.mongoapplication.repository.HotelRepository;
import com.mns.mongoapplication.service.HotelService;

/**
 *
 * @author ganesh
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public void saveHotels(Hotel hotel) {
        List<Hotel> hotels = Arrays.asList(hotel);
        hotelRepository.saveAll(hotels);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelRepository.insert(hotel);
    }

    @Override
    public void updateHotel(String id, Hotel hotel) {
        Hotel persistedHotel = findById(id);
        persistedHotel.setName(hotel.getName());
        persistedHotel.setAddress(hotel.getAddress());
        persistedHotel.setPricePerNight(hotel.getPricePerNight());
        persistedHotel.setReviews(hotel.getReviews());
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<Hotel> findAllHotelByCity(String city) {
        return hotelRepository.findByAddress_City(city);
    }

    @Override
    public Hotel findById(String id) {
        return hotelRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
