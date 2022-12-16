package com.api.book.bookrestbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int author_id;
    private String first_name;
    private String last_name;

    public int getAuthor_id() {
        return author_id;
    }

    @Override
    public String toString() {
        return "Author [author_id=" + author_id + ", first_name=" + first_name + ", last_name=" + last_name
                + ", language=" + language + "]";
    }

    public Author() {
    }

    public Author(int author_id, String first_name, String last_name, String language) {
        this.author_id = author_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.language = language;
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