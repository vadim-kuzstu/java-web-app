package ru.kuzstu.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/test")
public class TestController {

    private final Date date;
    private Date date2;

    @Autowired
    public TestController(Date date) {
        this.date = date;
    }

    @Autowired
    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    @GetMapping
    public Date getDate() {
        return date;
    }

    @GetMapping("/2")
    public Date getDate2() {
        return date2;
    }

}
