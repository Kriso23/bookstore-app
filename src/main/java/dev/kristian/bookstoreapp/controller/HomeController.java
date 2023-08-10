package dev.kristian.bookstoreapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kristian.bookstoreapp.config.BookstoreProperties;

@RestController
public class HomeController {
    
    private final BookstoreProperties properties;

    public HomeController(BookstoreProperties properties) {
        this.properties = properties;
    }

	@GetMapping("/")
    public BookstoreProperties home() {
        return properties;
    }
}
