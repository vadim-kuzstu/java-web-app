package ru.kuzstu.webapp.controller;

import ru.kuzstu.webapp.advice.Loggable;
import ru.kuzstu.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Loggable
    @GetMapping("/users")
    public String getUsers(Model model) {

        model.addAttribute("users", userRepository.readAll());
        return "Users";
    }

}
