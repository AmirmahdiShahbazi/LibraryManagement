import java.util.ArrayList;
import java.util.Scanner;

public class Lending {
    static Scanner input = new Scanner(System.in);

    private String nationalCode;
    private String isbn;
    private boolean loaned;
    private boolean returned;

    public Lending(String nationalCode, String isbn) {
        this.nationalCode = nationalCode;
        this.isbn = isbn;
        this.loaned = true;
        this.returned = false;
    }

    // static methods
    public static int searchLoan(ArrayList<Lending> lendings, String n, String I) {

        for (int i = 0; i < lendings.size(); i++) {
            String nationalCode = lendings.get(i).nationalCode;
            String ISBN = lendings.get(i).isbn;

            if (nationalCode.equals(n) && ISBN.equals(I)) {
                return i;
            }
        }

        return -1;
    }

    public static void loan(ArrayList<Book> books, ArrayList<Member> members, ArrayList<Lending> lendings)
            throws Exception {
        System.out.print("\n\n");
        input.nextLine();
        System.out.print("Enter member national code: ");
        String nationalCode = input.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = input.nextLine();

        int indexBook = Book.searchBook(books, isbn);

        if (Member.searchMember(members, nationalCode) != -1 && indexBook != -1) {

            int currentInventory = books.get(indexBook).getInventory();

            if (currentInventory != 0) {
                books.get(indexBook).setInventory(currentInventory - 1);

                Lending l1 = new Lending(nationalCode, isbn);
                lendings.add(l1);

                System.out.print("\n");
                System.out.print("The book was loaned");
                Thread.sleep(3000);
            } else {
                if (books.get(indexBook) instanceof EBook) {
                    System.out.print("\n");
                    System.out.print("Warning, it isn't possible to request an EBook");
                    Thread.sleep(3000);
                } else {
                    System.out.print("\n");
                    System.out.print("Insufficient inventory");
                    Thread.sleep(3000);
                }
            }

        } else {
            System.out.print("\n");
            System.out.print("There is no national code or ISBN!");
            Thread.sleep(3000);
        }
    }

    public static void returned(ArrayList<Book> books, ArrayList<Lending> lendings) throws Exception {
        System.out.print("\n\n");
        input.nextLine();
        System.out.print("Enter member national code: ");
        String nationalCode = input.nextLine();

        System.out.print("Enter book ISBN: ");
        String isbn = input.nextLine();

        int indexLoan = searchLoan(lendings, nationalCode, isbn);

        if (indexLoan != -1) {

            lendings.get(indexLoan).loaned = false;
            lendings.get(indexLoan).returned = true;

            int currentInventory = books.get(Book.searchBook(books, isbn)).getInventory();
            books.get(Book.searchBook(books, isbn)).setInventory(currentInventory + 1);

            System.out.print("\n");
            System.out.print("The book was returned");
            Thread.sleep(3000);

        } else {
            System.out.print("\n");
            System.out.print("Not found");
            Thread.sleep(3000);
        }
    }

    public static void showBook(ArrayList<Book> books, ArrayList<Lending> lendings) throws Exception {
        boolean flag = false;
        for (int i = 0; i < lendings.size(); i++) {
            String search = lendings.get(i).isbn;

            if (lendings.get(i).loaned && Book.searchBook(books, search) != -1) {
                System.out.println("\n\n" + books.get(Book.searchBook(books, search)).toString());
                flag = true;
            }
        }
        if (flag) {
            System.out.print("\nIf you want to go back to the previous menu, enter a character: ");
            input.next();
        } else {
            System.out.print("\n");
            System.out.print("No books have been loaned");
            Thread.sleep(3000);
        }
    }

    public static void showMember(ArrayList<Member> members, ArrayList<Lending> lendings) throws Exception {
        boolean flag = false;
        for (int i = 0; i < lendings.size(); i++) {
            String search = lendings.get(i).nationalCode;

            if (lendings.get(i).loaned && Member.searchMember(members, search) != -1) {
                System.out.println("\n\n" + members.get(Member.searchMember(members, search)).toString());
                flag = true;
            }
        }
        if (flag) {
            System.out.print("\nIf you want to go back to the previous menu, enter a character: ");
            input.next();
        } else {
            System.out.print("\n");
            System.out.print("No member has loaned a book");
            Thread.sleep(3000);
        }
    }

    // menu
    public static void menu(ArrayList<Book> books, ArrayList<Member> members,
            ArrayList<Lending> lendings) throws Exception {
        menuLoop: while (true) {
            System.out.print("\n\n\n");
            System.out.print(
                    "3,1) Book loan \n3,2) Return of the loaned book \n3,3) Show the books that are currently on loan"
                            + "\n3,4) Show the users who have borrowed books at the moment \n3,0) Back \n\nEnter your choice: ");
            int choose = input.nextInt();

            switch (choose) {
                case 1:
                    loan(books, members, lendings);
                    break;
                case 2:
                    returned(books, lendings);
                    break;
                case 3:
                    showBook(books, lendings);
                    break;
                case 4:
                    showMember(members, lendings);
                    break;
                case 0:
                    break menuLoop;
            }
        }
    }
}
