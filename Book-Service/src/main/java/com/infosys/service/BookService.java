package com.infosys.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Book;
import com.infosys.exception.BookAlreadyExistsException;
import com.infosys.exception.BookNotFoundException;
import com.infosys.repository.BookRepository;
import com.infosys.response.BookResponse;

@Service
public class BookService {
	
	@Autowired
	private BookRepository brepo;
	
	@Autowired
	private ModelMapper mapper;
	

	public List<Book> getAllBooks(){
		return brepo.findAll();
	}
	
	
	public Book getBookById(int book_id) throws BookNotFoundException {
		if(brepo.existsById(book_id)) {
			return brepo.findById(book_id).get();
		}else {
			throw new  BookNotFoundException("book with "+book_id +" do not exists ");
		}
	}
	
	public String deleteBookById(int book_id) throws BookNotFoundException{
		String message = "";
		if(brepo.existsById(book_id)) {
			 brepo.deleteById(book_id);
			 message = "Deleted successfully";
		}else {
			throw new  BookNotFoundException("book with "+book_id +" do not exists ");
		}
		return message;
	}
	
	public String updateBookById(int book_id,String author_name ,String pub_year)  throws BookNotFoundException{
		String message="";
		if(brepo.existsById(book_id)) {
			 Book b = brepo.findById(book_id).get();
			 b.setAuthor_name(author_name);
			 b.setPublication_year(pub_year);
			 message = "updated successfully";
		}else {
			throw new  BookNotFoundException("book with "+book_id +" do not exists ");
		}
		return message;
	}
	
	public Book addNewBook(Book book) throws BookAlreadyExistsException {
		if(brepo.existsById(book.getBook_id())) {
			throw new BookAlreadyExistsException("Book with "+book.getBook_id() + " already exists");
		}else {
			return brepo.save(book);
			
		}
	}
	
	public BookResponse getBookByLibraryId(int id) {
		Book b = brepo.findById(id).get();
		BookResponse br = mapper.map(b, BookResponse.class);
		return br;
	}
}
