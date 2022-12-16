package com.api.book.bookrestbook.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.book.bookrestbook.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
