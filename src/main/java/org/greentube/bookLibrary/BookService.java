package org.greentube.bookLibrary;

public class BookService {

    public static void main(String[] args) {

        Library library = new Library();

        Book firstBook = new Book("Vplyv", "Robert Ciadiny", 3);
        Book secondBook = new Book("Výnimočný", "Malcolm Gladwell", 2);
        Book thirdBook = new Book("The Frog", "Brian Tracy", 1);

        library.registerBook(firstBook);
        library.registerBook(secondBook);
        library.registerBook(thirdBook);

        Assistant assistant = new Assistant(library);
        assistant.setUp();
    }
}
