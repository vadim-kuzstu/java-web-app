package ru.kuzstu.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class Config {

    @Bean()
    @Scope("prototype")
    public Date getDate() {
        return new Date(ThreadLocalRandom.current().nextLong());
    }
}
