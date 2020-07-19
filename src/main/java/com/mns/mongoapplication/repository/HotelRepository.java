package com.mns.mongoapplication.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mns.mongoapplication.domain.Hotel;

/**
 *
 * @author ganesh
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    List<Hotel> findByAddress_City(String city);
}
