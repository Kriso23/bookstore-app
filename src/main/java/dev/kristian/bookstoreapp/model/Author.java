package dev.kristian.bookstoreapp.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public record Author(
    @Id
    Integer id,
    
    String first_name,
    String last_name,
    LocalDateTime birthday

) {
    
}
