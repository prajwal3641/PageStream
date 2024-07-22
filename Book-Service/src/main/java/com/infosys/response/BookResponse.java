package com.infosys.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookResponse {
	
	private Integer book_id;
	private String book_name;
	private String author_name;
	private String publication_year;
}
