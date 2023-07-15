package com.example.RestaurantManagement.RestaurantApp.controller;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // User registration (signup)
    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        // Validate and save the user
        // ...
        return userService.createUser(user);
    }

    // User login (signin)
    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody User user) {
        // Authenticate the user and generate JWT token
        // ...
        return ResponseEntity.ok("Login successful");
    }

    // Get current user's profile
    @GetMapping("/profile")
    public User getProfile(Authentication authentication) {
        String username = authentication.getName();
        return userService.getUserByUsername(username);
    }

    // Other user-related endpoints
}

