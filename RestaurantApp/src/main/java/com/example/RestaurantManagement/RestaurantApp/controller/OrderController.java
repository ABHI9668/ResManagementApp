package com.example.RestaurantManagement.RestaurantApp.controller;

import com.example.RestaurantManagement.RestaurantApp.model.Order;
import com.example.RestaurantManagement.RestaurantApp.service.OrderService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public Order createOrder(Authentication authentication, @RequestBody Order order) {
        String username = authentication.name();

        User user = userService.getUserByUsername(username);
        order.setUser(user);
        return orderService.createOrder(order);
    }

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get all orders for the current user
    @GetMapping("/my-orders")
    public List<Order> getMyOrders(Authentication authentication) {
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);
        return orderService.getOrdersByUser(user);
    }

    // Get a specific order by ID
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Delete an order by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted");
    }


}

