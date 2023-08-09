package dev.kristian.bookstoreapp.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import dev.kristian.bookstoreapp.model.Book;

//using spring data, less control over exact sql statements but easier implementation
//for more control, use jdbc template
public interface BookRepository extends ListCrudRepository<Book, Integer>{
    
    List<Book> findAllByTitleContains(String keyword); //derived sql statement


}
