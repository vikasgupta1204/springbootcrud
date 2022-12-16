package com.api.book.bookrestbook.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
/*ResponseEntity class is used to get the status and object. if there is no book available then 
 * we can return the status
 * passing List<Books> in ResponseEntity because it is returning List of books
 */
  @GetMapping("/books")  
public ResponseEntity<List<Book>> getBooks(){
    //System.out.println("Book added");

  List<Book> books= this.bookService.getAllBooks();

  if(books.isEmpty()){
    /*
     * status is a static method of Response entity and build method is used to create the objects
     */
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
    return ResponseEntity.of(Optional.of(books));
}  
/* passing Book parameter in ResponseEntity because i want to return Book object if 
 * book is found otherwise i want to send the HHttpStatus message
*/
@GetMapping("/books/{id}")
public ResponseEntity<Book> getBook(@PathVariable("id") int id){
  Book book=this.bookService.getBookById(id);
  if(book==null){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
return ResponseEntity.of(Optional.of(book));
}

//Requesbody automatically converts the data coming in json format into your book object
@PostMapping("/books")
public ResponseEntity<Book> addBook(@RequestBody Book b)
{
  Book b1=null;
  try{
b1= this.bookService.addBook(b);
return ResponseEntity.of(Optional.of(b1));
  }
catch(Exception e){
  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
}

@DeleteMapping("/books/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
{
  try{
   List<Book> b= this.bookService.deleteBook(id);
    return ResponseEntity.ok().build();
  }
  catch(Exception e){
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}

//update book handler

@PutMapping("/books/{bookId}")
public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
  try{
  this.bookService.updateBook(book,bookId);
  }
  catch(Exception e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }
  return ResponseEntity.of(Optional.of(book
  ));
}
}