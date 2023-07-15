package com.example.RestaurantManagement.RestaurantApp.repository;

import com.example.RestaurantManagement.RestaurantApp.model.Order;
import com.example.RestaurantManagement.RestaurantApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    // Other custom queries or methods
}


