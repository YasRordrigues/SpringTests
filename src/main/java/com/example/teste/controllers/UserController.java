package com.example.teste.controllers;

import com.example.teste.models.User;
import com.example.teste.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAl(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> geById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateById(id, user), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User user = userService.findById(id);
        userService.deleteById(id);

        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }

}
