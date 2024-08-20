package org.greentube.bookLibrary;

import java.math.BigDecimal;

public class CheapBook extends Book {
    private final BigDecimal price;
    private final String state;

    public CheapBook(String title, String author, int totalCopies, int yearPublished, int numberOfPages, double price, String state, Category category) {
        super(title, author, totalCopies, yearPublished, numberOfPages, category);
        this.price = BigDecimal.valueOf(price);
        this.state = state;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getState() {
        return this.state;
    }
}
