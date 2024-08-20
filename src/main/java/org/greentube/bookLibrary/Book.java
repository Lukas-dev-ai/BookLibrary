package org.greentube.bookLibrary;

import java.math.BigDecimal;

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

    public Book(String title, String author, int totalCopies, int yearPublished, int numberOfPages, Category category){
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

    public int getYearPublished() {
        return yearPublished;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract BigDecimal getPrice();
    public abstract String getState();

    public boolean compareObj(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return title.equalsIgnoreCase(book.title) && author.equals(book.author);
    }

    @Override
    public String toString() {
        return "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Total Copies=" + totalCopies +
                ", Year Published=" + yearPublished +
                ", Number Of Pages=" + numberOfPages;
    }
}
