import java.util.Scanner;
import java.util.ArrayList;

public class LibraryManagement {
	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Member> members = new ArrayList<Member>();
		ArrayList<Lending> lendings = new ArrayList<Lending>();

		while (true) {
			System.out.print("\n\n\n");
			System.out.print("1) Book management \n2) Member management \n3) Book lending \n4) Lottery \n0) Exit \n\n");
			System.out.print("Enter your choice: ");
			int chooseMenu = input.nextInt();
			menu(chooseMenu, books, members, lendings);
		}
	}

	public static void menu(int number, ArrayList<Book> books, ArrayList<Member> members,
			ArrayList<Lending> lendings) throws Exception {

		switch (number) {
			case 1:
				Book.menu(books);
				break;
			case 2:
				Member.menu(members);
				break;
			case 3:
				Lending.menu(books, members, lendings);
				break;
			case 0:
				System.exit(0);
				break;
		}

	}
}