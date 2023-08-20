package com.workintech.library.model;


import com.workintech.library.enums.BookCategory;

import java.io.IOException;
import java.nio.CharBuffer;

public class Book extends Artifacts implements Readable {

public int numberOfPages;
    private BookCategory bookCategory;
    private boolean isBorrowed;
    private int id;

    Author author;

    public Book(String name, String author, boolean available, int numberOfPages, BookCategory bookCategory, boolean isBorrowed, int id) {
        super(name, author, available);
        this.numberOfPages = numberOfPages;
        this.bookCategory = bookCategory;
        this.isBorrowed = isBorrowed;
        this.id = id;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }

    public String toString() {
        return "Kitap Adı: " + getName() + ", Yazar: " + getAuthor() + ", Kategori: " + getBookCategory();
    }
}

