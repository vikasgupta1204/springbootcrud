package com.api.book.bookrestbook.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookrestbook.entities.Book;
import com.api.book.bookrestbook.services.BookService;

@RestController
public class BookController {

@Autowired
private BookService  bookService;

/*Jackson converts objects into json ans vice versa
@RequestMapping(value="/books",method=RequestMethod.GET)*/
  @GetMapping("/books")  
public List<Book> getBooks(){
    return this.bookService.getAllBooks();
    
}  

@GetMapping("/books/{id}")
public Book getBook(@PathVariable("id") int id){
return bookService.getBookById(id);
}
}