package assignment2;

import java.util.Scanner;

class Book {
    private int bookId;
    private String bookName;

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookId = " + bookId + " BookName = " + bookName;
    }
}

public class BookDemo {

    static {
        System.out.println("--------------------------------------");
        System.out.println("----------BOOK STORE DEMO-------------");
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id, count = 0;
        String name;
        Book[] books = new Book[10];

        while (true) {
            System.out.println("\n1.Add New Book.");
            System.out.println("2.Update Book.");
            System.out.println("3.Delete Book.");
            System.out.println("4.Search Book.");
            System.out.println("5.Display all Books.");
            System.out.println("6.Exit.");
            System.out.print("=>\t");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> {
                    System.out.println("ADD NEW BOOK");
                    System.out.print("Enter No. of Books to Add:");
                    int num = sc.nextInt();
                    for (int i = 0; i < num; i++) {
                        System.out.print("Enter BookId: ");
                        id = sc.nextInt();
                        System.out.print("Enter BookName: ");
                        name = sc.next();
                        books[i] = new Book(id, name);
                        count++;
                    }
                    System.out.println("Books Added Successfully.");
                }
                case 2 -> {
                    System.out.println("UPDATE BOOK");
                    System.out.print("\nEnter BookID: ");
                    id = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (books[i] != null && books[i].getBookId() == id) {
                            System.out.println(books[i]);
                            System.out.println("Enter new Id:");
                            id = sc.nextInt();
                            books[i].setBookId(id);
                            System.out.println("Enter new Name:");
                            name = sc.next();
                            books[i].setBookName(name);
                        }
                    }
                    System.out.println("Successfully Updated");
                }
                case 3 -> {
                    System.out.println("DELETE BOOK");
                    System.out.print("\nEnter Book Id: ");
                    id = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (books[i] != null && books[i].getBookId() == id) books[i] = null;
                    }
                    System.out.println("Book Deleted Successfully.");
                }
                case 4 -> {
                    System.out.println("SEARCH BOOK");
                    System.out.print("Enter Book Id: ");
                    id = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        if (books[i] != null && books[i].getBookId() == id) System.out.println(books[i]);
                    }
                }
                case 5 -> {
                    System.out.println("DISPLAY ALL BOOKS");
                    for (Book book : books)
                        if (book != null) System.out.println(book);
                }
                case 6 -> System.exit(0);
            }
        }

    }
}
