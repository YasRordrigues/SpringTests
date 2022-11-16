package com.example.testes.service;

import com.example.testes.models.User;
import com.example.testes.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;


    @Test
    void createUser() {
        User user = new  User();
        user.setId(2L);
        user.setName("oi");
        user.setEmail("oi@teste.com");
        user.setPassword("asenha");
        userService.createUser(user);
        System.out.println(userRepository.findById(1L));
//        boolean verifyUser = user.getId().equals(2L);
//        Mockito.when(userService.createUser(user)).thenReturn(user);
//        assertTrue(verifyUser);
    }

    @Test
    void listUsers() {
    }
}