package com.book.details.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.details.entities.Book;
import com.book.details.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> list = bookService.getAllBooks();
		if(list.size()==0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBookData(book);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> find(@PathVariable int id) {
		Optional<Book> op = bookService.find(id);
		if(op.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(op.get()));
	}
	
	@PutMapping("/book/{id}")
	public Book update(@RequestBody Book book, @PathVariable int id) {
		return bookService.update(book, id);
	}
	
	@DeleteMapping("/book/{id}")
	public String delete(@PathVariable int id) {
		return bookService.delete(id);
	}
	
	
}
