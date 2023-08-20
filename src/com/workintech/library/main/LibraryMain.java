package com.workintech.library.main;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.model.*;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();
        Reader reader = new Reader(123456, "ALİ VELİ", 3);
        System.out.print("Username: "); // Kullanıcı Adı
        String username = scanner.nextLine();
        System.out.print("ID: "); // İD
        int id = scanner.nextInt();
        scanner.nextLine(); // Boş satırı temizle

        if (reader.authenticate(username, id)) {
            System.out.println("Successful Login! Welcome, " + username);

            while (true) {
                System.out.println("Select the operation you want to perform:");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Update Book Information");
                System.out.println("0. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Boş satırı temizle

                switch (choice) {
                    case 1:
                        System.out.println("Book Name: ");
                        String bookName = scanner.nextLine();
                        System.out.println("Author: ");
                        String author = scanner.nextLine();
                        System.out.println("Type (1: FICTION, , 2: FEAR, 3: COMEDY, 4: SCİENCE,5:HISTORY): ");
                        int typeChoice = scanner.nextInt();
                        scanner.nextLine(); // Boş satırı temizle
                        System.out.println("Book Category: ");
                        String category = scanner.nextLine();

                        Book book;
                        if (typeChoice == 1) {
                            book = new Book("ŞU ÇILGIN TÜRKLER","turgut özakman",true,780,BookCategory.HISTORY,true,123);
                        } else if (typeChoice == 2) {
                            book = new Book("aaa","dddd",true,780,BookCategory.FEAR,true,12);
                        } else if (typeChoice == 3) {
                            book = new Book("bbb","eee",false,500,BookCategory.COMEDY,true,3);
                        } else if (typeChoice == 4) {
                            book =  new Book("ccc","fff",true,340,BookCategory.FICTION,true,13);
                        } else {
                            System.out.println("Invalid type choice.");
                            continue;
                        }
                        library.addBook(book);
                        System.out.println("Book added successfully!");
                        break;

                    case 2:
                        System.out.print("Book Name to Remove: ");
                        String removeBookName = scanner.nextLine();
                        library.deleteBook(12);
                        System.out.println("Book removed successfully!");
                        break;

                    case 3:
                        System.out.print("Book Name to Update: ");
                        String updateBookName = scanner.nextLine();
                        // (Kitap bilgilerini güncelleme işlemleri)
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } else {
            System.out.println("Login Failed! Incorrect username or ID.");
        }
    }
}
