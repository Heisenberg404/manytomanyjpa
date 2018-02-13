package com.heisenberg404.manytomanyjpa.repository;

import com.heisenberg404.manytomanyjpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
