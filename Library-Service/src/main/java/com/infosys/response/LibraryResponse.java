package com.infosys.response;

import java.awt.print.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LibraryResponse {
	private Integer library_id;
	private String library_name;
	private String library_city;
	private String book_status;
	private Integer book_id;
	
	private BookResponse bookResponse;
}
