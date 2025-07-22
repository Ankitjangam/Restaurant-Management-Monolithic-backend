package com.restaurant.restaurant_management.service;

import com.restaurant.restaurant_management.dto.CategoryRequestDTO;
import com.restaurant.restaurant_management.dto.CategoryResponseDTO;

import java.util.List;

/**
 * Service interface for managing restaurant categories.
 * Provides methods to create, retrieve, update, and delete categories.
 */

public interface CategoryService {


    /**
     * Creates a new category based on the provided DTO.
     *
     * @param dto the data transfer object containing category details
     * @return the created category as a response DTO
     */
    CategoryResponseDTO createCategory(CategoryRequestDTO dto);

    /**
     * Retrieves all categories.
     *
     * @return a list of all categories as response DTOs
     */
    List<CategoryResponseDTO> getAllCategories();

    /**
     * Retrieves a category by its ID.
     *
     * @param id the ID of the category to retrieve
     * @return the category as a response DTO
     */
    CategoryResponseDTO getCategoryById(Long id);

    /**
     * Updates an existing category with the provided DTO.
     *
     * @param id  the ID of the category to update
     * @param dto the data transfer object containing updated category details
     * @return the updated category as a response DTO
     */
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);

    /**
     * Deletes a category by its ID.
     *
     * @param id the ID of the category to delete
     */
    void deleteCategory(Long id);
}
