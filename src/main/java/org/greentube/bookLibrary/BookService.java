package org.greentube.bookLibrary;

public class BookService {

    public static void main(String[] args) {

        Library library = new Library();

        Book firstCheapBook = new CheapBook("Vplyv1", "Robert Ciadiny", 3, 2010, 199, 3.99, "Used", Book.Category.USED);
        Book secondCheapBook = new CheapBook("Vplyv2", "Robert Ciadiny", 3, 2010, 199, 2.99, "Missing pages", Book.Category.USED);
        Book thirdCheapBook = new CheapBook("Vplyv3", "Robert Ciadiny", 3, 2010, 199, 4.99, "Cool", Book.Category.STANDARD);

        Book firstStandardBook = new StandardBook("Vplyv1", "Robert Ciadiny", 3, 2010, 199, 3.99, "Used", false, Book.Category.STANDARD);
        Book secondStandardBook = new StandardBook("Vplyv2", "Robert Ciadiny", 3, 2010, 199, 2.99, "Missing pages", true, Book.Category.STANDARD);
        Book thirdStandardBook = new StandardBook("Vplyv3", "Robert Ciadiny", 3, 2010, 199, 4.99, "Cool", false, Book.Category.STANDARD);

        Book firstRareBook = new RareBook("Vplyv1", "Robert Ciadiny", 3, 2010, 199, 3.99, "Used", false, Book.Category.RARE);
        Book secondRareBook = new RareBook("Vplyv2", "Robert Ciadiny", 3, 2010, 199, 2.99, "Missing pages", true, Book.Category.RARE);
        Book thirdRareBook = new RareBook("Vplyv3", "Robert Ciadiny", 3, 2010, 199, 4.99, "Cool", false, Book.Category.RARE);


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
