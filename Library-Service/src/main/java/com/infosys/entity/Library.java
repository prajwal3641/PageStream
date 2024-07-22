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
public class Library {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="Library id is null")
	private Integer library_id;
	@NotNull(message="Library name is null")
	private String library_name;
	@NotNull(message="Library city is null")
	private String library_city;
	@NotNull(message="book status is null")
	private String book_status;
	@NotNull(message="Book id should not be null")
	private Integer book_id;
}
