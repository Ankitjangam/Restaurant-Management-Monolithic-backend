package com.restaurant.restaurant_management.service;

import com.restaurant.restaurant_management.dto.UserRegistrationDto;

public interface UserService {

    /**
     * Registers a new user with the provided registration details.
     *
     * @param registrationDto the user registration data transfer object containing user details
     */
    void registerUser(UserRegistrationDto registrationDto);


}
