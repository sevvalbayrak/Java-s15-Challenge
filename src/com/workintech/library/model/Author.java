package com.workintech.library.model;

import java.util.List;

public class Author extends Person {
    List<Book> books;

    public Author(int id, String name, List<Book> books) {
        super(id, name);
        this.books = books;
    }
public Author(int id, String name) {
    super(id, name);
}

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
