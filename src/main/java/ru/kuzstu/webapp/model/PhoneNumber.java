package ru.kuzstu.webapp.model;

public record PhoneNumber(Long id, Long userId, String phoneNumber, boolean active) {
}
