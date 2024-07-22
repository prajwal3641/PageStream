package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

}
