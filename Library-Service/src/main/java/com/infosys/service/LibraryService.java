package com.infosys.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Library;
import com.infosys.exception.LibraryAlreadyExistsException;
import com.infosys.feignclient.bookClient;
import com.infosys.repository.LibraryRepository;
import com.infosys.response.BookResponse;
import com.infosys.response.LibraryResponse;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository lrepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private bookClient bclient;
	
	//1. Add new Library
	public Library insertLibrary(Library lib) throws LibraryAlreadyExistsException {
		if(lrepo.existsById(lib.getLibrary_id())) {
			throw new LibraryAlreadyExistsException("Library with id "+lib.getLibrary_id()+" already exists");
		}else {
			
			return lrepo.save(lib);
		}
	}
	
	// 2. Show all library Details
	public List<Library> getAll(){
		return lrepo.findAll();
	}
	
	// 3. show all books in each library on the basis of the library id
	public LibraryResponse getLibraryId(int id) {
		Library l = lrepo.findById(id).get();
		BookResponse br = (bclient.getBookByLibraryId(l.getBook_id())).getBody();
		LibraryResponse lr = mapper.map(l, LibraryResponse.class);
		lr.setBookResponse(br);;
		
		return lr;
	}
}
