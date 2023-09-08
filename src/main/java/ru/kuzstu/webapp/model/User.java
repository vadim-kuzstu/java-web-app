package ru.kuzstu.webapp.model;

import java.util.Date;

public record User(Long id, String name, Date birthday, boolean admin) {
}
