package org.greentube.bookLibrary;

import java.math.BigDecimal;

public class RareBook extends Book {
    private final BigDecimal price;
    private final String state;
    private final boolean forSale;
    public RareBook(String title, String author, int totalCopies, int yearPublished, int numberOfPages, double price, String state, Boolean forSale, Category category) {
        super(title, author, totalCopies, yearPublished, numberOfPages, category);
        this.price = BigDecimal.valueOf(price);
        this.state = state;
        this.forSale = forSale;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    public boolean isForSale() {
        return forSale;
    }

    @Override
    public String getState() {
        return this.state;
    }
}
