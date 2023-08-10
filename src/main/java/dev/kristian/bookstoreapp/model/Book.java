package dev.kristian.bookstoreapp.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;


public record Book(
    @Id
    Integer id,

    String title,
    String descr,

    @NotNull
    Integer author,
    
    Integer price
) {

}
