package ru.kuzstu.webapp.repository;

import ru.kuzstu.webapp.model.User;

import java.util.List;

public interface UserRepository {

    User read(Long id);

    List<User> readAll();

    void create(User user);

}
