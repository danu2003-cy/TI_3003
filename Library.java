import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book Issued.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getBookId() == id && book.isIssued()) {
                book.returnBook();
                System.out.println("Book Returned.");
                return;
            }
        }
        System.out.println("Invalid Book ID.");
    }
}