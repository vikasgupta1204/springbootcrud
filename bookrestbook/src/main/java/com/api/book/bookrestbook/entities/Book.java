package com.api.book.bookrestbook.entities;

public class Book {
    private int id;
    private String title;
    private String author;
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
    public void setAuthor(String author) {
        this.author = author;
    }
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

}