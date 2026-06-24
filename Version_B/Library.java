package Version_B;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean addBook(Book book) {

        for (Book b : books) {
            if (b.getBookId() == book.getBookId()) {
                System.out.println("A book with this ID already exists.");
                return false;
            }
        }

        books.add(book);
        System.out.println("Book added successfully.");
        return true;
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n===== BOOK LIST =====");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String keyword) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public void issueBook(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {

                if (book.isIssued()) {
                    System.out.println("Book is already issued.");
                    return;
                }

                book.issueBook();
                System.out.println("Book issued successfully.");
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    public void returnBook(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {

                if (!book.isIssued()) {
                    System.out.println("Book is already available.");
                    return;
                }

                book.returnBook();
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("Book ID not found.");
    }
}
