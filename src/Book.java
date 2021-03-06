import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Book {
	static Scanner input = new Scanner(System.in);

	protected String name;
	protected String author;
	protected int year;
	protected String isbn;
	private int inventory;
	protected int pages;
	protected int price;

	public Book(String name, String author, int year, String isbn, int pages, int price) {
		this.name = name;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.pages = pages;
		this.price = price;
	}

	public Book(String name, String author, int year, String isbn, int inventory, int pages, int price) {
		this.name = name;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.inventory = inventory;
		this.pages = pages;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String output = String.format("Book name: %s \nAuthor name: %s \nYear of publication: %d \nISBN number: %s \n"
				+ "Book inventory: %d \nBook pages: %d \nBook price: %d",
				name, author, year, isbn, inventory, pages, price);
		return output;
	}

	public void editBook(ArrayList<Book> books, int index) throws Exception {
		System.out.print("\n\n");
		System.out.println(books.get(index).toString());

		System.out.print("\n");
		System.out.print("New book name: ");
		String name = input.nextLine();

		System.out.print("New author name: ");
		String author = input.nextLine();

		System.out.print("New year of publication: ");
		int year = input.nextInt();

		System.out.print("New ISBN number: ");
		String isbn = input.next();

		System.out.print("New book inventory: ");
		int inventory = input.nextInt();

		System.out.print("New book pages: ");
		int pages = input.nextInt();

		System.out.print("New book price: ");
		int price = input.nextInt();

		if (searchBook(books, isbn) == -1) {
			books.get(index).setName(name);
			books.get(index).setAuthor(author);
			books.get(index).setYear(year);
			books.get(index).setIsbn(isbn);
			books.get(index).setInventory(inventory);
			books.get(index).setPages(pages);
			books.get(index).setPrice(price);

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
	public static int searchBook(ArrayList<Book> books, String search) {

		for (int i = 0; i < books.size(); i++) {
			String name = books.get(i).name;
			String ISBN = books.get(i).isbn;

			if (name.equalsIgnoreCase(search) || ISBN.equals(search)) {
				return i;
			}
		}

		return -1;
	}

	public static void addBook(ArrayList<Book> books) throws Exception {
		System.out.print("\n\n");
		input.nextLine();
		System.out.print("Book name: ");
		String name = input.nextLine();

		System.out.print("Author name: ");
		String author = input.nextLine();

		System.out.print("Year of publication: ");
		int year = input.nextInt();

		System.out.print("ISBN number: ");
		String isbn = input.next();

		System.out.print("Book inventory: ");
		int inventory = input.nextInt();

		System.out.print("Book pages: ");
		int pages = input.nextInt();

		System.out.print("Book price: ");
		int price = input.nextInt();

		if (searchBook(books, isbn) == -1) {
			Book b1 = new Book(name, author, year, isbn, inventory, pages, price);
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

	public static void deleteBook(ArrayList<Book> books) throws Exception {
		System.out.print("\n\n");
		input.nextLine();
		System.out.print("Enter name or ISBN of book: ");
		String search = input.nextLine();
		int index = searchBook(books, search);

		if (index != -1) {
			System.out.print("\n\n");
			System.out.println(books.get(index).toString());
			System.out.print("Seriously! Do you want to delete it? (yes/no) ");
			String delete = input.next();

			if (delete.equalsIgnoreCase("yes")) {
				books.remove(index);
				System.out.print("\n");
				System.out.print("OK, The book was deleted");
				Thread.sleep(3000);
			}
		} else {
			System.out.print("\n");
			System.out.print("Oops the book was not found");
			Thread.sleep(3000);
		}
	}

	public static void searchBook(ArrayList<Book> books) throws Exception {
		System.out.print("\n\n");
		input.nextLine();
		System.out.print("Enter name or ISBN of book: ");
		String search = input.nextLine();
		int index = searchBook(books, search);

		if (index != -1) {
			System.out.print("\n\n");
			System.out.println(books.get(index).toString());
			System.out.print("\nIf you want to go back to the previous menu, enter a character: ");
			input.next();
		} else {
			System.out.print("\n");
			System.out.print("Oops the book was not found");
			Thread.sleep(3000);
		}
	}

	public static void showAllBook(ArrayList<Book> books) throws Exception {
		if (books.size() != 0) {
			String[] allBooks = new String[books.size()];
			for (int i = 0; i < books.size(); i++) {
				allBooks[i] = books.get(i).name;
			}

			Arrays.sort(allBooks);

			for (int i = 0; i < allBooks.length; i++) {
				for (int j = 0; j < books.size(); j++) {
					if (allBooks[i].equals(books.get(j).name)) {
						System.out.print("\n");
						System.out.println(books.get(j).toString());
					}
				}
			}

			System.out.print("\nIf you want to go back to the previous menu, enter a character: ");
			input.next();
		} else {
			System.out.print("\n");
			System.out.print("We don't have any books");
			Thread.sleep(3000);
		}
	}

	// menu book management
	public static void menu(ArrayList<Book> books) throws Exception {
		menuLoop: while (true) {
			System.out.print("\n\n\n");
			System.out.print("1,1) Add new book \n1,2) Edit book \n1,3) Delete book \n1,4) Search book"
					+ "\n1,5) Show books \n1,0) Back \n\nEnter your choice: ");
			int choose = input.nextInt();

			switch (choose) {
				case 1:

					menu: while (true) {
						System.out.print("\n\n");
						System.out.print("1) Book \n2) EBook \n0) Back \n\nEnter your choice: ");
						int type = input.nextInt();
						switch (type) {
							case 1:
								addBook(books);
								break menu;
							case 2:
								EBook.addBook(books);
								break menu;
							case 0:
								break menu;
						}
					}
					break;

				case 2:

					System.out.print("\n\n");
					input.nextLine();
					System.out.print("Enter name or ISBN of book: ");
					String search = input.nextLine();
					int index = searchBook(books, search);

					if (index != -1) {
						books.get(index).editBook(books, index);
					} else {
						System.out.print("\n");
						System.out.print("Oops the book was not found");
						Thread.sleep(3000);
					}
					break;

				case 3:
					deleteBook(books);
					break;
				case 4:
					searchBook(books);
					break;
				case 5:
					showAllBook(books);
					break;
				case 0:
					break menuLoop;
			}
		}
	}
}
