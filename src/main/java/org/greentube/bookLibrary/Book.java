package org.greentube.bookLibrary;

import java.math.BigDecimal;

/**
 * The abstract Book class represents a book in the library.
 * It holds basic information about the book and provides methods to access this information.
 * This class should be extended by more specific types of books.
 */
public abstract class Book {
    protected enum Category {
        USED,
        STANDARD,
        RARE
    }

    private final String title;
    private final String author;
    private final int totalCopies;
    private final int yearPublished;
    private final int numberOfPages;
    private final Category category;

    public Book(String title, String author, int totalCopies, int yearPublished, int numberOfPages, Category category) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.yearPublished = yearPublished;
        this.numberOfPages = numberOfPages;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public String getTitle() {
        return title;
    }

    public abstract BigDecimal getPrice();

    public abstract String getState();

    @Override
    public String toString() {
        return "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Total Copies=" + totalCopies +
                ", Year Published=" + yearPublished +
                ", Number Of Pages=" + numberOfPages;
    }
}
