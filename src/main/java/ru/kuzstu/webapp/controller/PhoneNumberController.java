package ru.kuzstu.webapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kuzstu.webapp.model.PhoneNumber;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("api/users/{user_id}/phone_numbers")
public class PhoneNumberController {

    private final List<PhoneNumber> phoneNumbers;

    public PhoneNumberController() {
        phoneNumbers = new CopyOnWriteArrayList<>();
        phoneNumbers.addAll(List.of(new PhoneNumber(1L, 1L, "+79999999999", true),
                new PhoneNumber(2L, 2L, "+79998888888", true)));
    }

    @GetMapping()
    public List<PhoneNumber> getPhoneNumbers(@PathVariable("user_id") Long userId) {
        return phoneNumbers.stream()
                           .filter(phoneNumber -> phoneNumber.userId().equals(userId))
                           .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPhoneNumber(@PathVariable("user_id") Long userId, @RequestParam String phoneNumber) {
        Long id = ThreadLocalRandom.current().nextLong();
        PhoneNumber phoneNum = new PhoneNumber(id, userId, phoneNumber, false);
        phoneNumbers.add(phoneNum);
    }
}
