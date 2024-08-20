package org.greentube.bookLibrary;

public class BookService {

    public static void main(String[] args) {

        Library library = new Library();

        Book firstCheapBook = new CheapBook("1984", "George Orwell", 5, 1949, 328, 15.99, "Used", Book.Category.USED);
        Book secondCheapBook = new CheapBook("To Kill a Mockingbird", "Harper Lee", 3, 1960, 281, 12.99, "Used", Book.Category.USED);
        Book thirdCheapBook = new CheapBook("The Great Gatsby", "F. Scott Fitzgerald", 4, 1925, 180, 10.99, "Used", Book.Category.USED);

        Book firstStandardBook = new StandardBook("Moby Dick", "Herman Melville", 6, 1851, 635, 18.99, "Standard", Book.Category.STANDARD);
        Book secondStandardBook = new StandardBook("Pride and Prejudice", "Jane Austen", 4, 1813, 432, 9.99, "Standard", Book.Category.STANDARD);
        Book thirdStandardBook = new StandardBook("The Catcher in the Rye", "J.D. Salinger", 5, 1951, 277, 14.99, "Standard", Book.Category.STANDARD);

        Book firstRareBook = new RareBook("Brave New World", "Aldous Huxley", 3, 1932, 311, 13.99, "Rare", Book.Category.RARE);
        Book secondRareBook = new RareBook("War and Peace", "Leo Tolstoy", 2, 1869, 1225, 20.99, "Rare", Book.Category.RARE);
        Book thirdRareBook = new RareBook("The Hobbit", "J.R.R. Tolkien", 7, 1937, 310, 16.99, "Rare", Book.Category.RARE);


        library.registerBook(firstCheapBook);
        library.registerBook(secondCheapBook);
        library.registerBook(thirdCheapBook);

        library.registerBook(firstStandardBook);
        library.registerBook(secondStandardBook);
        library.registerBook(thirdStandardBook);

        library.registerBook(firstRareBook);
        library.registerBook(secondRareBook);
        library.registerBook(thirdRareBook);

        Assistant assistant = new Assistant(library);
        assistant.setUp();
    }
}
