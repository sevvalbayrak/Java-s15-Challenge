package com.workintech.library.model;

import com.workintech.library.enums.BookCategory;

import java.util.*;

public class LibrarySystem {

    private Map<Integer, Book> books;
    private Map<Integer, Reader> readers;
    private List<Transaction> transactions;

    public LibrarySystem() {
        this.books = new HashMap<>();
        this.readers = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public Book getBookByName(String name) {
        for (Book book : books.values()) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public Book getBookByAuthor(String author) {
        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public void updateBook(Book book) {
        books.put(book.getId(), book);
    }

    public void deleteBook(int id) {
        books.remove(id);
    }

    public void listBooksByCategory(BookCategory bookCategory) {
        List<Book> booksInCategory = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getBookCategory() == bookCategory) {
                booksInCategory.add(book);
            }
        }

        if (booksInCategory.isEmpty()) {
            System.out.println("Bu kategoride kitap bulunmamaktadır.");
        } else {
            System.out.println("Kategori: " + bookCategory);
            for (Book book : booksInCategory) {
                System.out.println(book);
            }
        }
    }
    public List<Book> getBooksByCategory(BookCategory bookCategory) {
        List<Book> booksByCategory = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getBookCategory().equals(bookCategory)) {
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    public void listBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }

        if (booksByAuthor.isEmpty()) {
            System.out.println("Bu yazarın kitabı bulunmamaktadır.");
        } else {
            System.out.println("Yazar: " + author);
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        }
    }

    public void searchBooks(String keyword) {
        List<Book> foundBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (String.valueOf(book.getId()).equals(keyword) ||
                    book.getName().equalsIgnoreCase(keyword) ||
                    book.getAuthor().equalsIgnoreCase(keyword)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("Eşleşen kitap bulunamadı.");
        } else {
            System.out.println("Eşleşen kitaplar:");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }

    public void returnBook(int readerId, int bookId) {
        Reader reader = readers.get(readerId);
        Book book = books.get(bookId);

        if (reader == null || book == null) {
            System.out.println("Invalid user or book.");
            return;
        }

        if (reader.getBorrowedBooks().contains(book)) {
            reader.returnBook(book);
            book.setBorrowed(false);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("The book is not borrowed by the user.");
        }
    }

    public void borrowBook(int userId, int bookId) {
        Reader reader = readers.get(userId);
        Book book = books.get(bookId);

        if (reader == null || book == null) {
            System.out.println("Invalid user or book.");
            return;
        }

        if (!book.isBorrowed()) {
            if (reader.getBorrowedBooks().size() < reader.getBorrowedBookLimit()) {
                book.setBorrowed(true);
                reader.borrowBook(book);
                System.out.println("Book borrowed successfully.");
                System.out.println(reader.getName() + "'s borrowed books: " + reader.getBorrowedBooks());
            } else if (reader.getBorrowedBooks().size() >= 5) {
                System.out.println("User has reached the book borrowing limit.");
            }

        } else {
            System.out.println("The book is not available for borrowing.");
        }
    }
    public void addBook(String name, String author, int numberOfPages, BookCategory bookCategory) {

        Book book = new Book(name, author, true, numberOfPages, bookCategory, false, 10);
        books.put(book.getId(), book);
        System.out.println("Kitap başarıyla eklendi.");
    }
    @Override
    public String toString() {
        return "LibrarySystem{" +
                "books=" + books +
                ", readers=" + readers +
                ", transactions=" + transactions +
                '}';
    }
}
