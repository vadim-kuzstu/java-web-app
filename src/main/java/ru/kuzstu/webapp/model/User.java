package ru.kuzstu.webapp.model;

import java.util.Date;

public record User(Long userId, String userName, Date birthday, boolean isAdmin) {
}
