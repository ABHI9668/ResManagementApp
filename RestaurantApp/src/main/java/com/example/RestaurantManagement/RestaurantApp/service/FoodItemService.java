package com.example.RestaurantManagement.RestaurantApp.service;

import com.example.RestaurantManagement.RestaurantApp.model.FoodItem;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("FoodItem not found"));
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}

