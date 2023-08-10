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

import dev.kristian.bookstoreapp.model.Book;

import dev.kristian.bookstoreapp.repository.BookRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/book")
@CrossOrigin //disables security (browser feature) over using same port

public class BookController {
	
	private final BookRepository repository;

	private final AuthorController authorController;

	public BookController(BookRepository repository, AuthorController authorController) {
		this.repository = repository;
		this.authorController = authorController;
	}

	//when trying to find all the books
	@GetMapping("")
	public List<Book> findAll() {
		return repository.findAll();
	}

	//finding by specific id
	@GetMapping("/{id}")
	public Book findById(@PathVariable Integer id){
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
	}


	/* CRUD OPERATIONS HERE */
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void create(@Valid @RequestBody Book book) {
		if(authorController.findById(book.author()) == null){ //preserving database fk integrity
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found, create author first.");
		}
		repository.save(book);
	}


	//example of a read operation (filter by title)
	@GetMapping("/filter/{keyword}")
	public List<Book> findByTitle(@PathVariable String keyword) {
		return repository.findAllByTitleContains(keyword);
	}


	@ResponseStatus(HttpStatus.NO_CONTENT) //returning as a confirmation that no new book was created
	@PutMapping("/{id}")
	public void update(@RequestBody Book book, @PathVariable Integer id) {
		if(!repository.existsById(id) || authorController.findById(book.author()) == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book/Author not found");
		}
		repository.save(book);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}

	


}
