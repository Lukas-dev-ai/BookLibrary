package org.greentube.bookLibrary;

import java.util.Scanner;

public class Assistant {
    private Library library;
    private Scanner scanner;

    public Assistant(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void setUp() {
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. List available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");


            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection){
                case 1:
                    library.availableBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }
    public void borrowBook(){
        System.out.println("What title do you like to borrow?");
        String title= scanner.nextLine();
        if(!library.borrowBook(title)){
            System.out.println("This book is not available");
        }
    }

    public void returnBook(){
        System.out.println("What title do you like to return?");
        String title = scanner.nextLine();
        library.returnBook(title);
    }
}
