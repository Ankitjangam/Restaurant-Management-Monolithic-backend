package com.restaurant.restaurant_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for representing restaurant details in responses.
 * This class is used to transfer restaurant data between the service layer and the controller layer.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDTO {
    /**
     * Unique identifier for the restaurant.
     */
    private Long id;

    /**
     * Name of the restaurant.
     */
    private String name;

    /**
     * Address of the restaurant.
     */
    private String address;

    /**
     * Phone number of the restaurant.
     */
    private String phone;
}
