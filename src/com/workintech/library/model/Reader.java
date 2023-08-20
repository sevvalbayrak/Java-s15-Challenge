package com.workintech.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader extends Person {
    private int borrowedBookLimit;
    private List<Book> borrowedBooks;

    public Reader(int id, String name, int borrowedBookLimit) {
        super(id, name);
        this.borrowedBookLimit = borrowedBookLimit;
        this.borrowedBooks = new ArrayList<>();
    }
    public boolean authenticate(String enteredName, int enteredId) {
        return getName().equals(enteredName) && getId() == enteredId;
    }


    public int getBorrowedBookLimit() {
        return borrowedBookLimit;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < borrowedBookLimit) {
            borrowedBooks.add(book);
        } else {
            System.out.println("You have reached your borrowed book limit.");
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return borrowedBookLimit == reader.borrowedBookLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrowedBookLimit);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "borrowedBookLimit=" + borrowedBookLimit +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}