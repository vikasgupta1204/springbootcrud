package com.api.book.bookrestbook.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    System.out.println("Book added");
    return this.bookService.getAllBooks();
    
}  

@GetMapping("/books/{id}")
public Book getBook(@PathVariable("id") int id){
return bookService.getBookById(id);
}

//Requesbody automatically converts the data coming in json format into your book object
@PostMapping("/books")
public Book addBook(@RequestBody Book b)
{
return this.bookService.addBook(b);
}

@DeleteMapping("/books/{id}")
public List<Book> deleteBook(@PathVariable("id") int id)
{
    return this.bookService.deleteBook(id);
}

//update book handler

@PutMapping("/books/{bookId}")
public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
this.bookService.updateBook(book,bookId);
  return book;
}
}