package com.example.testes.service;

import com.example.testes.models.User;
import com.example.testes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Service")
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);
        return user;
    }

    public List<User> ListUsers(){
        return userRepository.findAll();
    }
}
