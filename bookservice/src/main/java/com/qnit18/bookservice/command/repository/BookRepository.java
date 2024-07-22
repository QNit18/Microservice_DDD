package com.qnit18.bookservice.command.repository;

import com.qnit18.bookservice.command.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
