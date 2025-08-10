package com.restaurant.restaurant_management.controller;

import com.restaurant.restaurant_management.dto.RestaurantTableDto;
import com.restaurant.restaurant_management.dto.TableRequestDTO;
import com.restaurant.restaurant_management.model.RestaurantTable;
import com.restaurant.restaurant_management.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing restaurant tables.
 * Provides endpoints for creating, retrieving, updating, and deleting tables.
 */

@RestController
@RequestMapping("/tables")
@RequiredArgsConstructor
public class RestaurantTableController {


    @Qualifier("restaurantTableServiceImpl")
    private final RestaurantTableService tableService;

    /**
     * Create a new restaurant table.
     *
     * @param dto Table request data
     * @return Created RestaurantTable
     */

    @PostMapping
    public ResponseEntity<RestaurantTable> addTable(@RequestBody TableRequestDTO dto) {
        RestaurantTable savedTable = tableService.createTable(dto);
        return ResponseEntity.ok(savedTable);
    }

    /**
     * Get all restaurant tables.
     *
     * @return List of all RestaurantTableDto
     */

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTableDto> getTable(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTable(id));
    }

    /**
     * Get all restaurant tables.
     *
     * @return List of all RestaurantTableDto
     */

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTableDto> updateTable(@PathVariable Long id, @RequestBody RestaurantTableDto dto) {
        return ResponseEntity.ok(tableService.updateTable(id, dto));
    }


    /**
     * Delete a restaurant table by ID.
     *
     * @param id Table ID to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
