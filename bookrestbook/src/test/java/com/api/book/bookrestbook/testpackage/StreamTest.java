package com.api.book.bookrestbook.testpackage;

import java.util.List;

import com.api.book.bookrestbook.entities.Book;

public class StreamTest {
   public static void main(String[] args) {
    Book b1=new Book(1,"abcd","xyz");
    Book b2=new Book(2,"trew","hgfd");
    Book b3=new Book(3,"uyt","ssdf");
    List<Book> list=List.of(b1,b2,b3);
    boolean b =list.stream().anyMatch(e->e.getId()==4);
    System.out.println(b);
   } 
}