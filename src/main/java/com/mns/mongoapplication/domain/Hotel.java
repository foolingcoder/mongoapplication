package com.mns.mongoapplication.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mns.mongoapplication.common.AuditMongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ganesh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hotel")
@EnableMongoRepositories(basePackages = "*")
public class Hotel extends AuditMongo {
    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)//the pricepernight will store in ascending in mongodb Collection
    private int pricePerNight;
    private Address address;
    private List<Review> reviews;
}
