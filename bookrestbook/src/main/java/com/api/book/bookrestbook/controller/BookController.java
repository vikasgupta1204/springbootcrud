package com.api.book.bookrestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookrestbook.entities.Book;

@RestController
public class BookController {
/*Jackson converts objects into json ans vice versa
@RequestMapping(value="/books",method=RequestMethod.GET)*/
  @GetMapping("/books")  
public Book getBooks(){
    Book book=new Book();
    book.setId(1);
    book.setAuthor("Ravikant Mishra");
    book.setTitle("Bharatvarsh");

    return  book;
}    
}