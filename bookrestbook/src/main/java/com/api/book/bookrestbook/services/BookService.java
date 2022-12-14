package com.api.book.bookrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bookrestbook.dao.BookRepository;
import com.api.book.bookrestbook.entities.Book;

@Component
public class BookService {
  //To access the values from database. we use bookRepository reference which provides us the generic method to query db
  @Autowired
  private  BookRepository bookRepository;

  // private static List<Book>    books=  new ArrayList<>();
  

  // static {
  //   books.add(new Book(2,"Cathy Seira","Catherine"));
  //   books.add(new Book(3,"Microservices with java","Orielly publications"));
  //   books.add(new Book(4,"HC Verma Physics","HC Verma"));
  // }

  public List<Book> getAllBooks(){
    List<Book> books=(List<Book>)this.bookRepository.findAll();
    return books;
  }

  public Book getBookById(int id){
    
    // Book book=null;
    // //to get the book from Books list in single line
    //  book=books.stream().filter(e->e.getId()==id).findFirst().get();

    Book book=null;
    try{
    book=this.bookRepository.findById(id);
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return book;
    
    //return new Book();
  }

  public Book addBook(Book b)
  {
    // books.add(b);
    // return b;

   Book result= this.bookRepository.save(b);
   return result;
  }

  public void deleteBook(int id)
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

     // List<Book> b1=null;
     // b1 =books.stream().filter(b->b.getId()!=id).collect(Collectors.toList());
      
      /*books ={book1,book2,book3} 
       * 
      */

     this.bookRepository.deleteById(id);
      // if(b1.size()==books.size()){
      //  throw new NullPointerException();
      // }
   // return b1;

  }

public void updateBook(Book book, int bookId) {
//   boolean flag=false;
//   flag=books.stream().anyMatch(e->e.getId()==bookId);
//   if(flag==false){
//     throw new NullPointerException();
//   }
//  books=  books.stream().map(e->
//   {
//     if(e.getId()==bookId)
//     {
//       e.setTitle(book.getTitle());
//       e.setAuthor(book.getAuthor());
    
//     }
//     return e;
//   }
//     ).collect(Collectors.toList());

book.setId(bookId);
this.bookRepository.save(book);

}



}