package org.greentube.bookLibrary;

import java.util.Calendar;
import java.util.InputMismatchException;
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


            int selection = -1;
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
            }

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
        System.out.println("Category? (USED, STANDARD, RARE)");
        String categoryInput= scanner.nextLine().trim().toUpperCase();
        Book.Category category;
        switch (categoryInput){
            case "USED":
                    category = Book.Category.USED;
                    break;
            case "STANDARD":
                category = Book.Category.STANDARD;
                break;
            case "RARE":
                category = Book.Category.RARE;
                break;
            default:
                System.out.println("Invalid category. Please enter one of the following: USED, STANDARD, RARE.");
                return;
        }

        System.out.println("What title do you like to borrow?");
        String title= scanner.nextLine();
        if(!library.borrowBook(category, title)){
            System.out.println("This book is not available");
        }
    }

    public void returnBook(){
        System.out.println("What category book would you like to return? (USED, STANDARD, RARE)");
        String categoryInput = scanner.nextLine().trim().toUpperCase();
        Book.Category category;
        try {
            category = Book.Category.valueOf(categoryInput);
        }catch (IllegalArgumentException e){
            System.out.println("Invalid category. Please enter one of the following: USED, STANDARD, RARE.");
            return;
        }
        System.out.println("What title do you like to return?");
        String title = scanner.nextLine();
        library.returnBook(category, title);
    }
}
