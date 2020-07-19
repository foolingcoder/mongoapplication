package com.mns.mongoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mns.mongoapplication.domain.Hotel;
import com.mns.mongoapplication.service.HotelService;

/**
 *
 * @author ganesh
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotel() {
        List<Hotel> hotelList = hotelService.getAllHotels();
        return hotelList;
    }

    @GetMapping("/{id}")
    public Hotel getHotel(@PathVariable("id") String id) {
        return hotelService.findById(id);
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getHotelByCity(@PathVariable("city") String city) {
        return hotelService.findAllHotelByCity(city);
    }

    @PostMapping("/save")
    public void saveHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotels(hotel);
    }

    @PutMapping("/update/{id}")
    public void updateHotel(@PathVariable("id") String id, @RequestBody Hotel hotel) {
        hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHotel(@PathVariable("id") String id) {
        hotelService.deleteHotel(id);
    }


}
