package ru.tweekyone.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tweekyone.security.controller.dto.UserDTO;
import ru.tweekyone.security.model.User;
import ru.tweekyone.security.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Greetings from Spring Security project";
    }

    @PostMapping("/create")
    public ResponseEntity<User> createNewUser(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);
    }
}
