package com.example.RestaurantManagement.RestaurantApp.controller;

import com.example.RestaurantManagement.RestaurantApp.model.FoodItem;
import com.example.RestaurantManagement.RestaurantApp.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-items")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }


    @PostMapping
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem) {

        return foodItemService.createFoodItem(foodItem);
    }


    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public FoodItem getFoodItem(@PathVariable Long id) {
        return foodItemService.getFoodItemById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable Long id) {

        foodItemService.deleteFoodItem(id);
        return ResponseEntity.ok("FoodItem deleted");
    }


}
