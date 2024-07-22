package com.infosys.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infosys.response.BookResponse;

@FeignClient(name="Book-Service",url="http://localhost:8081",path="/book-service")
public interface bookClient {
	@GetMapping(value="/getBook/{id}",produces="application/json")
	public ResponseEntity<BookResponse> getBookByLibraryId(@PathVariable("id")int id);
}
