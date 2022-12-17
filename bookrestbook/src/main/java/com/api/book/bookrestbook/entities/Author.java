package com.api.book.bookrestbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int author_id;
    private String first_name;
    private String last_name;

    @OneToOne(mappedBy = "author")  
    /*to avoid infinite loop as book has author author_id. here we want to avoid creating ano
    ther column in Author table*/
    @JsonBackReference
    /* to avoid infinite recursion we use above annotation as child field will not be converted into json */
    private Book book;

    @Override
    public String toString() {
        return "Author [author_id=" + author_id + ", first_name=" + first_name + ", last_name=" + last_name + ", book="
                + book + ", language=" + language + "]";
    }

    public Author(String first_name, String last_name, Book book, String language) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.book = book;
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAuthor_id() {
        return author_id;
    }

    

    public Author() {
    }

   

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String language;
}
