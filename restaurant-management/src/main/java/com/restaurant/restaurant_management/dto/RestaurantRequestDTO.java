package com.restaurant.restaurant_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for restaurant request.
 * This class is used to encapsulate the data required to create a new restaurant.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDTO {

    // Fields representing the restaurant's details
    private String name;
    private String address;
    private String phone;
}
