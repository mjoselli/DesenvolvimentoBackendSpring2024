package com.example.testes;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTests {
    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
    }
    @Test
    void greetingShouldReturnDefaultMessage() {
        assertThat(userController.greeting()).isEqualTo("hello");
    }
    @MockBean
    private UserRepository userRepository;

    @Test
    void addUserShouldReturnUser() {
        User user = new User();
        user.setId(3L);
        user.setName("John Doe");
        user.setEmail("john@pucpr.br");
        user.setPassword("1234567890");
        when(userRepository.save(any())).thenReturn(user);
        ResponseEntity<User> response = userController.addUser(user);
        User returnedUser = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(returnedUser).isEqualTo(user);
    }

}
