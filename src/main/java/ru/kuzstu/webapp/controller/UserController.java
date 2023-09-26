package ru.kuzstu.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kuzstu.webapp.model.User;
import ru.kuzstu.webapp.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.readAll();
    }

    @GetMapping("/{user_id}")
    public User getUser(@PathVariable("user_id") Long userId) {
        return userRepository.read(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user) {
        userRepository.create(user);
    }
}
