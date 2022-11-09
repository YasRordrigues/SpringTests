package com.example.teste.services;

import com.example.teste.exceptions.ResourceNotFoundException;
import com.example.teste.models.User;
import com.example.teste.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAl() {
        return userRepository.findAll();
    }

    public User findById(Long id) {

        return userRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public User updateById(Long id, User user) {
        return userRepository.findById(id)
                .map(user1 -> {
                    user1.setName(user.getName());
                    user1.setPassword(user.getPassword());
                    user1.setDescription(user.getDescription());
                    return userRepository.save(user1);
                }).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    public void deleteById(Long id) {

        User user = userRepository.
                findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.delete(user);
    }
}
