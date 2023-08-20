package com.workintech.library.model;

import com.workintech.library.enums.TransactionStatus;

public class Transaction {

    private int id;
    private Reader reader;
    private Book book;
    private TransactionStatus status;
    private double amount;

    public Transaction(int id, Reader reader, Book book, TransactionStatus status, double amount) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.status = status;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", reader=" + reader +
                ", book=" + book +
                ", status=" + status +
                ", amount=" + amount +
                '}';
    }
}