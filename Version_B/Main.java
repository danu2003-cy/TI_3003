package Version_B;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library();

        while (true) {

            printMenu();

            int choice = getIntegerInput();

            switch (choice) {

                case 1:
                    addBook(library);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    issueBook(library);
                    break;

                case 4:
                    returnBook(library);
                    break;

                case 5:
                    searchBook(library);
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printMenu() {

        System.out.println("\n================================");
        System.out.println(" LIBRARY MANAGEMENT SYSTEM ");
        System.out.println("================================");
        System.out.println("1. Add Book");
        System.out.println("2. Display Books");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Book");
        System.out.println("6. Exit");
        System.out.print("Select an option: ");
    }

    private static void addBook(Library library) {

        System.out.print("Enter Book ID: ");
        int id = getIntegerInput();

        scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine().trim();

        if (title.isEmpty() || author.isEmpty()) {
            System.out.println("Title and Author cannot be empty.");
            return;
        }

        Book book = new Book(id, title, author);
        library.addBook(book);
    }

    private static void issueBook(Library library) {

        System.out.print("Enter Book ID to issue: ");
        int id = getIntegerInput();

        library.issueBook(id);
    }

    private static void returnBook(Library library) {

        System.out.print("Enter Book ID to return: ");
        int id = getIntegerInput();

        library.returnBook(id);
    }

    private static void searchBook(Library library) {

        scanner.nextLine();

        System.out.print("Enter Title or Author: ");
        String keyword = scanner.nextLine();

        library.searchBook(keyword);
    }

    private static int getIntegerInput() {

        while (!scanner.hasNextInt()) {

            System.out.print("Please enter a valid number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }
}
