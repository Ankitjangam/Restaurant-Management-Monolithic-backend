package com.restaurant.restaurant_management.service;

import com.restaurant.restaurant_management.dto.RestaurantRequestDTO;
import com.restaurant.restaurant_management.dto.RestaurantResponseDTO;

import java.util.List;

/**
 * Service interface for managing restaurant operations.
 * Provides methods to create a new restaurant and retrieve all restaurants.
 */


public interface RestaurantService {

    /**
     * Creates a new restaurant based on the provided request data.
     *
     * @param dto the data transfer object containing restaurant details
     * @return the created restaurant as a response DTO
     */
    RestaurantResponseDTO createRestaurant(RestaurantRequestDTO dto);

    /**
     * Retrieves a list of all restaurants.
     *
     * @return a list of restaurant response DTOs
     */
    List<RestaurantResponseDTO> getAllRestaurants();
}
