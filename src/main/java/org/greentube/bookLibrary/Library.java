package org.greentube.bookLibrary;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Book.Category, Map<Book, Integer>> library;

    public Library() {

        library = new HashMap<>();
        library.put(Book.Category.USED, new HashMap<>());
        library.put(Book.Category.STANDARD, new HashMap<>());
        library.put(Book.Category.RARE, new HashMap<>());
    }

    public void registerBook(Book book) {
        Map<Book, Integer> booksByCategory = library.get(book.getCategory());
        booksByCategory.put(book, booksByCategory.getOrDefault(book, 0) + book.getTotalCopies());
    }

    public boolean borrowBook(Book book) {
        return borrowBook(book.getCategory(), book.getTitle());
    }

    public boolean borrowBook(Book.Category category, String title) {
        Map<Book, Integer> booksByCategory = library.get(category);
        for (Map.Entry<Book, Integer> entry : booksByCategory.entrySet()) {
            if (entry.getKey().getTitle().equalsIgnoreCase(title)) {
                if (entry.getValue() > 0) {
                    booksByCategory.put(entry.getKey(), entry.getValue() - 1);
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
        Map<Book, Integer> booksByCategory = getBooksByCategory(book.getCategory());
        Integer count = booksByCategory.get(book);
        if (count == null) {
            System.out.println("This book is not does not exists!");
        } else if (count >= book.getTotalCopies()) {
            System.out.println("This book is not from this library!");
        } else {
            booksByCategory.put(book, count + 1);
        }
    }

    public void returnBook(Book.Category category, String title) {
        Map<Book, Integer> booksByCategory = getBooksByCategory(category);
        for (Map.Entry<Book, Integer> entry : booksByCategory.entrySet()) {
            if (entry.getKey().getTitle().equalsIgnoreCase(title)) {
                if (entry.getValue() >= entry.getKey().getTotalCopies()) {
                    System.out.println("All copies have been already returned.");
                } else {
                    booksByCategory.put(entry.getKey(), entry.getValue() + 1);
                }
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in this library!");
    }

    public void availableBooks() {
        for (Map.Entry<Book.Category, Map<Book, Integer>> categoryEntry : library.entrySet()) {
            Book.Category category = categoryEntry.getKey();
            Map<Book, Integer> booksByCategory = getBooksByCategory(category);
            for(Map.Entry<Book, Integer> entry: booksByCategory.entrySet()){
                System.out.println(entry.getKey().toString() + " - Available Copies: " + entry.getValue());
            }
        }
    }

    private Map<Book, Integer> getBooksByCategory(Book.Category category) {
        return library.getOrDefault(category, new HashMap<>());
    }

}
