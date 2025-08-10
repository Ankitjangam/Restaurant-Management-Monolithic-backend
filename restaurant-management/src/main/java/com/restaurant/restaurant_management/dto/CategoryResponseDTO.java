package com.restaurant.restaurant_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for category response data.
 * This class is used to transfer category information in API responses.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {

    /**
     * Unique identifier for the category.
     */
    private Long id;
    /**
     * Name of the category.
     */
    private String name;
    /**
     * Description of the category.
     */
    private String description;
}
