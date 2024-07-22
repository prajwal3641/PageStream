package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Library;
import com.infosys.response.LibraryResponse;
import com.infosys.service.LibraryService;

import jakarta.validation.Valid;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryService service;
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<Library> insertLib(@Valid @RequestBody Library lib){
		return new ResponseEntity<Library>(service.insertLibrary(lib),HttpStatus.OK);
	}
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List> getAll(){
		return new ResponseEntity<List>(service.getAll(),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<LibraryResponse> getLibrary(@PathVariable("id")int id){
		return new ResponseEntity<LibraryResponse>(service.getLibraryId(id),HttpStatus.OK);
	}
	
}
