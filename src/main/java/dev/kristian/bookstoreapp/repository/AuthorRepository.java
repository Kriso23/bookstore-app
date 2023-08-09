package dev.kristian.bookstoreapp.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import dev.kristian.bookstoreapp.model.Author;

//using spring data, less control over exact sql statements but easier implementation
//for more control, use jdbc template
public interface AuthorRepository extends ListCrudRepository<Author, Integer>{


    @Query("""
            SELECT * FROM Author
            WHERE first_name = :name
            """)
    List<Author> findAllByFirstNameContains(@Param("name") String name);

}
