package com.example.RestaurantManagement.RestaurantApp.repository;

import com.example.RestaurantManagement.RestaurantApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

