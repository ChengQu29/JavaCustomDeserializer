package com.example.JSONParsing.pojo;

import java.util.List;

public class Author {
    private String authorName;
    private List<Book> books;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
