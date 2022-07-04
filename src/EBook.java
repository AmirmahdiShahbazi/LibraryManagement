import java.util.ArrayList;
import java.util.Scanner;

public class EBook extends Book {
    static Scanner input = new Scanner(System.in);

    private String format;
    private int size;

    public EBook(String name, String author, int year, String isbn, int pages, int price, String format, int size) {
        super(name, author, year, isbn, pages, price);
        this.format = format;
        this.size = size;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        String output = String.format("Book name: %s \nAuthor name: %s \nYear of publication: %d \nISBN number: %s"
                + "\nBook pages: %d \nBook price: %d \nBook format: %s \nBook size: %d",
                name, author, year, isbn, pages, price, format, size);
        return output;
    }

    @Override
    public void editBook(ArrayList<Book> books, int index) throws Exception {
        System.out.print("\n\n");
        System.out.println(books.get(index).toString());

        input.nextLine();
        System.out.print("\n");
        System.out.print("New book name: ");
        String name = input.nextLine();
        books.get(index).setName(name);

        System.out.print("New author name: ");
        String author = input.nextLine();
        books.get(index).setAuthor(author);

        System.out.print("New year of publication: ");
        int year = input.nextInt();
        books.get(index).setYear(year);

        System.out.print("New ISBN number: ");
        String isbn = input.next();
        books.get(index).setIsbn(isbn);

        System.out.print("New book pages: ");
        int pages = input.nextInt();
        books.get(index).setPages(pages);

        System.out.print("New book price: ");
        int price = input.nextInt();
        books.get(index).setPrice(price);

        System.out.print("New book format: ");
        String format = input.next();

        System.out.print("New book size: ");
        int size = input.nextInt();

        if ((searchBook(books, name) == -1 && searchBook(books, isbn) == -1) || searchBook(books, isbn) == -1) {
            books.get(index).setName(name);
            books.get(index).setAuthor(author);
            books.get(index).setYear(year);
            books.get(index).setIsbn(isbn);
            books.get(index).setPages(pages);
            books.get(index).setPrice(price);
            ((EBook) books.get(index)).setFormat(format);
            ((EBook) books.get(index)).setSize(size);

            System.out.print("\n");
            System.out.print("The book was updated");
            Thread.sleep(3000);
        } else {
            System.out.print("\n");
            System.out.print("This book exists");
            Thread.sleep(3000);
        }
    }

    // static method
    public static void addBook(ArrayList<Book> books) throws Exception {
        System.out.print("\n\n");
        System.out.print("Book name: ");
        String name = input.nextLine();

        System.out.print("Author name: ");
        String author = input.nextLine();

        System.out.print("Year of publication: ");
        int year = input.nextInt();

        System.out.print("ISBN number: ");
        String isbn = input.next();

        System.out.print("Book pages: ");
        int pages = input.nextInt();

        System.out.print("Book price: ");
        int price = input.nextInt();

        System.out.print("Book format: ");
        String format = input.next();

        System.out.print("Book size: ");
        int size = input.nextInt();

        if ((searchBook(books, name) == -1 && searchBook(books, isbn) == -1) || searchBook(books, isbn) == -1) {
            Book b1 = new EBook(name, author, year, isbn, pages, price, format, size);
            books.add(b1);

            System.out.print("\n");
            System.out.print("The book was added");
            Thread.sleep(3000);
        } else {
            System.out.print("\n");
            System.out.print("This book exists");
            Thread.sleep(3000);
        }
    }

}
