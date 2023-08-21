package com.book.details.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.book.details.dao.BookRepository;
import com.book.details.entities.Book;


@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)bookRepository.findAll();
		return list;
	}
	
	public Book saveBookData(Book book) {
		Book b = bookRepository.save(book);
		return b;
	}
	
	public Optional<Book> find(int id) {
		return bookRepository.findById(id);
	}
	
	
	public Book update(Book book, int id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book b = optional.get();
		b.setName(book.getName());
		b.setAuthor(book.getAuthor());
		return bookRepository.save(b);
	}
	
	public String delete(int id) {
		bookRepository.deleteById(id);
		return "Deleted Successfully";
	}
}
