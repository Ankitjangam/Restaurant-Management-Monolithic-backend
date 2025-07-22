package com.restaurant.restaurant_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating or updating a restaurant category.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDTO {

    /**
     * Name of the category.
     * Must not be blank.
     */
    @NotBlank(message = "Category name must not be blank")
    private String name;
    /**
     * Description of the category.
     * Optional field.
     */

    private String description;
}
