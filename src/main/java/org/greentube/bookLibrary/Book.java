package org.greentube.bookLibrary;

public class Book {
    private String title;
    private String author;
    private int totalCopies;

    public Book(String title, String author, int totalCopies){
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean compareObj(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return title.equalsIgnoreCase(book.title) && author.equals(book.author);
    }

    @Override
    public String toString() {
        return "Title: " + title + '\'' +
                ", Author: " + author + '\'' +
                ", TotalCopies: " + totalCopies;
    }
}
