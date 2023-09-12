package ru.kuzstu.webapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.kuzstu.webapp.model.PhoneNumber;

import java.util.List;

@RestController
@RequestMapping("api/users/{user_id}/phone_numbers")
public class PhoneNumberController {

    private final List<PhoneNumber> phoneNumbers;

    public PhoneNumberController() {
        phoneNumbers = List.of(new PhoneNumber(1L, 1L, "+79999999999", true),
                new PhoneNumber(2L, 2L, "+79998888888", true));
    }

    @GetMapping()
    public List<PhoneNumber> getPhoneNumbers(@PathVariable("user_id") Long userId) {
        return phoneNumbers.stream()
                           .filter(phoneNumber -> phoneNumber.userId().equals(userId))
                           .toList();
    }
}
