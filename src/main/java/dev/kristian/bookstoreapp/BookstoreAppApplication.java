package dev.kristian.bookstoreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.kristian.bookstoreapp.config.BookstoreProperties;

@EnableConfigurationProperties(BookstoreProperties.class)
@SpringBootApplication
public class BookstoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreAppApplication.class, args);
	}

}
