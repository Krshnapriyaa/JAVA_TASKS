import java.util.ArrayList;
import java.util.Scanner;

class Book {
    public int id;
    public String title;
    public String author;
    public boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + 
               (isIssued ? " [Issued]" : " [Available]");
    }
}

class User {
    public int id;
    public String name;
    public ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + name + ", Borrowed Books: " + borrowedBooks.size();
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added: " + b.title);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) System.out.println(b);
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println("User added: " + u.name);
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        for (User u : users) System.out.println(u);
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (!book.isIssued) {
                book.isIssued = true;
                user.borrowedBooks.add(book);
                System.out.println("Book issued to " + user.name);
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Book or User not found!");
        }
    }

    public void returnBook(int bookId, int userId) {
        User user = findUser(userId);
        if (user != null) {
            for (Book b : user.borrowedBooks) {
                if (b.id == bookId) {
                    b.isIssued = false;
                    user.borrowedBooks.remove(b);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
            System.out.println("User did not borrow this book.");
        } else {
            System.out.println("User not found!");
        }
    }

    private Book findBook(int id) {
        for (Book b : books) if (b.id == id) return b;
        return null;
    }

    private User findUser(int id) {
        for (User u : users) if (u.id == id) return u;
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add User");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, title, author));
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String uname = sc.nextLine();
                    library.addUser(new User(uid, uname));
                    break;

                case 4:
                    library.viewUsers();
                    break;

                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int ibid = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int iuid = sc.nextInt();
                    library.issueBook(ibid, iuid);
                    break;

                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int rbid = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int ruid = sc.nextInt();
                    library.returnBook(rbid, ruid);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}
