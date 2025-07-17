package com.sys.vendas.services;

import com.sys.vendas.models.User;
import com.sys.vendas.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void shouldCreateUser() {
        User user = new User();
        user.setName("Alice");

        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);
        assertEquals("Alice", createdUser.getName());
    }

    @Test
    void shouldReturnAllUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "Alice"),
                new User(2L, "Bob")
        );

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("Bob", result.get(1).getName());
    }
}