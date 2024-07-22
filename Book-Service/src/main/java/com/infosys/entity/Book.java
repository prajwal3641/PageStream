package com.infosys.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="Book id is null")
	private Integer book_id;
	@NotNull(message="Book name is null")
	private String book_name;
	@NotNull(message="author name is null")
	private String author_name;
	@NotNull(message="publication year is null")
	private String publication_year;
}
