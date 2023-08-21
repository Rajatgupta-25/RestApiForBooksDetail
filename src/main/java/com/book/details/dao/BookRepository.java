package com.book.details.dao;

import org.springframework.data.repository.CrudRepository;

import com.book.details.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
