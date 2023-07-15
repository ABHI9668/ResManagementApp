package com.example.RestaurantManagement.RestaurantApp.repository;

import com.example.RestaurantManagement.RestaurantApp.model.FoodItem;
import com.example.RestaurantManagement.RestaurantApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long> {
    // Custom queries or methods, if needed
}


