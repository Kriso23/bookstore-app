package dev.kristian.bookstoreapp.model;

import org.springframework.data.annotation.Id;


public record Book(
    @Id
    Integer id,

    String title,
    String descr,
    Integer author,
    Integer price
) {

}
