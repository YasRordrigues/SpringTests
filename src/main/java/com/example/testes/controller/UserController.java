package com.example.testes.controller;

import com.example.testes.models.User;
import com.example.testes.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    @GetMapping("listAll")
    public List<User> listAll() {
        return userService.ListUsers();
    }

    @PostMapping("createUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
