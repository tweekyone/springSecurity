package ru.tweekyone.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.tweekyone.security.*")
@SpringBootApplication
public class SpringSecurityApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApp.class, args);
    }
}
