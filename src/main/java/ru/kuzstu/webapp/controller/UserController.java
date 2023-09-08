package ru.kuzstu.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzstu.webapp.model.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @GetMapping
    public List<User> getUsers() throws ParseException {
        String strDate1 = "11.10.1997";
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = formatter.parse(strDate1);

        String strDate2 = "07.12.1991";
        Date date2 = formatter.parse(strDate2);

        User u1 = new User(1L, "John", date1, true);
        User u2 = new User(2L, "Jordan", date2, false);

        return List.of(u1, u2);
    }
}
