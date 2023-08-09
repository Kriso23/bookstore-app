package dev.kristian.bookstoreapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.kristian.bookstoreapp.model.Author;
import dev.kristian.bookstoreapp.repository.AuthorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/author")
@CrossOrigin //disables security (browser feature) over using same port

public class AuthorController {
    
    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    //when trying to find all the books
    @GetMapping("")
    public List<Author> findAll() {
        return repository.findAll();
    }

    //finding by specific id
    @GetMapping("/{id}")
    public Author findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }


    /* CRUD OPERATIONS HERE */
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Author author) {
        repository.save(author);
    }


    //example of a read operation (filter by firstname)
    @GetMapping("/filter/{name}")
    public List<Author> findByFirstName(@PathVariable String name) {
        return repository.findAllByFirstNameContains(name);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT) //returning as a confirmation that no new book was created
    @PutMapping("/{id}")
    public void update(@RequestBody Author author, @PathVariable Integer id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
        repository.save(author);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    


}
