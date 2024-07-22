package com.infosys.controller;

import java.util.List;

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

import com.infosys.entity.Book;
import com.infosys.exception.BookAlreadyExistsException;
import com.infosys.exception.BookNotFoundException;
import com.infosys.response.BookResponse;
import com.infosys.service.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
	
	@PostMapping(value="/insert" , consumes="application/json") 
	public ResponseEntity<Book> addBook(@Valid @RequestBody Book book)throws BookAlreadyExistsException{
		Book b = service.addNewBook(book);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List> getAll(){
		return new ResponseEntity<List>(service.getAllBooks(),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id)throws BookNotFoundException{
		return new ResponseEntity<Book>(service.getBookById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteBook(@PathVariable("id")int bid)  throws BookNotFoundException {
		return service.deleteBookById(bid);
	}
	
	@PutMapping(value="/update/{id}",consumes="application/json")
	public String updateBook(@PathVariable("id")int bid,@Valid @RequestBody Book book)  throws BookNotFoundException {
		return service.updateBookById(bid, book.getAuthor_name(), book.getPublication_year());
	}
	
	
	@GetMapping(value="/getBook/{id}",produces="application/json")
	public ResponseEntity<BookResponse> getBookByLibraryId(@PathVariable("id")int id){
		return new ResponseEntity<BookResponse>(service.getBookByLibraryId(id),HttpStatus.OK);
	}
	
	
	
}
