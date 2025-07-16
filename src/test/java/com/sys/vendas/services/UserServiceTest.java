package com.sys.vendas.services;

import com.sys.vendas.models.User;
import com.sys.vendas.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    void shouldCreateUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        User user = new User();
        user.setName("Alice");

        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);
        assertEquals("Alice", createdUser.getName());
    }
}