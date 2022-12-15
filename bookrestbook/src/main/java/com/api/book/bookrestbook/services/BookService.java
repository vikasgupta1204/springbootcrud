package com.api.book.bookrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bookrestbook.entities.Book;

@Component
public class BookService {
  private static List<Book>    books=  new ArrayList<>();
  

  static {
    books.add(new Book(2,"Cathy Seira","Catherine"));
    books.add(new Book(3,"Microservices with java","Orielly publications"));
    books.add(new Book(4,"HC Verma Physics","HC Verma"));
  }

  public List<Book> getAllBooks(){
    return books;
  }

  public Book getBookById(int id){
    
    Book book=null;
    //to get the book from Books list in single line
     book=books.stream().filter(e->e.getId()==id).findFirst().get();
    return book;
    
    //return new Book();
  }

  public Book addBook(Book b)
  {
    books.add(b);
    return b;
  }

  public List<Book> deleteBook(int id)
  {
    //method 1
    // if(books.stream().anyMatch(e->e.getId()==id)){
    //     Book b=null;
    //     b=books.stream().filter(e->e.getId()==id).findFirst().get();
    //     books.remove(b);
    // }
    //method 2
    // books=books.stream().filter(b->{
    //     if(b.getId()!=id){
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }).collect(Collectors.toList()) ;
    
    //method3

    books =books.stream().filter(b->b.getId()!=id).collect(Collectors.toList());


    return books;

  }
}