package com.api.book.bookrestbook.entities;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private int id;

    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference  
    /*To avoid infinite recursion we use JsonManagedReference above parent field
     * as here Auuthor field will be converted to json but book field in Author class wont be converted
     * to json hence this will help in avoiding infinite recursion
     */
    private Author author;
   
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public Book() {
    }
  
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Book(String title, Author author) {
     
        this.title = title;
        this.author = author;
    }
    public Author getAuthor() {
        return author;
    }

}