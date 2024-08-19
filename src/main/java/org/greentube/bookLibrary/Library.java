package org.greentube.bookLibrary;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Book, Integer> library;

    public Library() {
        library = new HashMap<>();
    }

    public void registerBook(Book book) {
        library.put(book, library.getOrDefault(book, 0) + book.getTotalCopies());
    }

    public boolean borrowBook(Book book) {
        return borrowBook(book.getTitle());
    }

    public boolean borrowBook(String title) {
        for (Map.Entry<Book, Integer> entry : library.entrySet()) {
            if (entry.getKey().getTitle().equalsIgnoreCase(title)) {
                if (entry.getValue() > 0) {
                    library.put(entry.getKey(), entry.getValue() - 1);
                    System.out.println("Book borrowed: " + entry.getKey().getTitle());
                    return true;
                } else {
                    System.out.println("Book not available");
                    return false;
                }
            }
        }
        System.out.println("Book with title: '" + title + "' not found!");
        return false;
    }

    public void returnBook(Book book) {
        Integer count = library.get(book);
        if (count == null) {
            System.out.println("This book is not does not exists!");
        } else if (count >= book.getTotalCopies()) {
            System.out.println("This book is not from this library!");
        } else {
            library.put(book, count + 1);
        }
    }

    public void returnBook(String title) {
        for (Map.Entry<Book, Integer> entry : library.entrySet()) {
            if (entry.getKey().getTitle().equalsIgnoreCase(title)) {
                if (entry.getValue() >= entry.getKey().getTotalCopies()) {
                    System.out.println("All copies have been already returned.");
                } else {
                    library.put(entry.getKey(), entry.getValue() + 1);
                }
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in this library!");
    }

    public void availableBooks() {
        for (Map.Entry<Book, Integer> entry : library.entrySet()) {
            System.out.println(entry.getKey().toString() + " - Available Copies: " + entry.getValue());
        }
    }

}
