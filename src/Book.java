import java.util.ArrayList;
import java.util.Scanner;



public class Book {
	private String name;
	private String author;
	private int year;
	private int jsbn;
	private int inventory;
	private int price;
	private String format;
	private int size;
	private static int numberOfBooks;
	private static String str="" ;
	private static String specifications;
	
	
	
	
	public Book() {
		
	}
	//TODO Setter 
	public Book(String name,String author,int year,int jsbn,int inventory,int price ,String format,int size) {
		this.name=name;
		this.author=author;
		this.year=year;
		this.jsbn=jsbn;
		this.inventory=inventory;
		this.price=price;
		this.format=format;
		this.size=size;
	
	}
	 	 
	//TODO getter methods
	 
	 public  String getName() {
		 return this.name;
	 }
	 public String getAuthor() {
		 return this.author;
	 }
	 public int getYear() {
		 return this.year;		 
		 
	 }
	 public int getJsbn() {
		 return this.jsbn;		 
	 }
	 public int getInventory() {
		 return this.inventory;
	 }
	 public int getPrice() {
		 
		 return this.price;
	 }
	 public String getFormat() {
		 return this.format;
	 }
	 public int getSize() {
		 return this.size;		 
	 }
	 
	   //TODO add new book
	
	 static ArrayList list=new ArrayList();
	 public static void addNewBook() throws Exception {
			gettinNumberOfBooks();				
			Book b[]=new Book[numberOfBooks];
			for(int i=0; i<numberOfBooks;i++) {								
				Scanner inp=new Scanner(System.in);
				System.out.print("enter Book name: ");
				String name=inp.next();
				System.out.print("enter authors name: ");
				String author=inp.next();
				System.out.print("enter year of publication: ");
				int year=inp.nextInt();
				System.out.print("enter JSBN: ");
				int jsbn=inp.nextInt();
				System.out.print("enter Number of inventory: ");
				int inventory=inp.nextInt();
				System.out.print("enter price: ");
				int price=inp.nextInt();
				System.out.print("enter format: ");
				String format=inp.next();
				int size = 0;
				if(format.equals("pdf"))
				{
					System.out.print("enter size: ");
					 size=inp.nextInt();			
				}
				b[i]=new Book(name,author,year,jsbn,inventory,price,format,size);
				specifications=b[i].getName()+" "+b[i].getAuthor()+" "+b[i].getYear()+" "+b[i].getJsbn()+" "+b[i].getInventory()
						+" "+b[i].getPrice()+" "+b[i].getFormat()+" "+b[i].getSize();				
				System.out.println(specifications);
				
				
				if(str.contains(specifications))
				{
					System.out.println("specifications already registered\n"+ "you can chnge specifications by edit option ");
				}
				str += specifications;
				list.add (specifications);
				
				}
			
				}
		
		

	
	
	//TODO number of Books
	public static int gettinNumberOfBooks() {		
		Scanner inp=new Scanner(System.in);
		System.out.print("enter number of Books: ");
		numberOfBooks=inp.nextInt();
		return numberOfBooks;
	}
	
	
	//TODO edit specifications
	public static void editOption() throws Exception {
		Scanner inp=new Scanner(System.in);
		System.out.print("enter name or JSBN: ");
		String edit=inp.next();
		for(int i=0;i<numberOfBooks;i++) {
		if(((String) list.get(i)).contains(edit)) {				
				System.out.println(list.get(i));
				
				System.out.print("enter Book name: ");
				String name=inp.next();
				System.out.print("enter authors name: ");
				String author=inp.next();
				System.out.print("enter year of publication: ");
				int year=inp.nextInt();
				System.out.print("enter JSBN: ");
				int jsbn=inp.nextInt();
				System.out.print("enter Number of inventory: ");
				int inventory=inp.nextInt();
				System.out.print("enter price: ");
				int price=inp.nextInt();
				System.out.print("enter format: ");
				String format=inp.next();
				int size = 0;
				if(format.equals("pdf"))
				{
					System.out.print("enter size: ");
					 size=inp.nextInt();			
				}
				Book b=new Book(name,author,year,jsbn,inventory,price,format,size);
				specifications=b.getName()+" "+b.getAuthor()+" "+b.getYear()+" "+b.getJsbn()+" "+b.getInventory()
						+" "+b.getPrice()+" "+b.getFormat()+" "+b.getSize();				
				System.out.println(specifications);
			
			
		}	
		else
			System.out.println("specifications not found.");
	
		}
	}
				
	//TODO search book			
	public static void searchBook() {
		Scanner inp=new Scanner(System.in);
		System.out.print("enter name or JSBN: ");
		String search=inp.next();
		for(int i=0;i<numberOfBooks;i++) {
			if(((String) list.get(i)).contains(search)) 
				System.out.println(list.get(i));
			else
				System.out.println("not found.");
			
		}	
		
		
		
		
	}
			
			
		
		
		
	
			
		//TODO delete book
	public static void deleteBook() {
		Scanner inp=new Scanner(System.in);
		System.out.print("enter name or JSBN: ");
		String delete=inp.next();
		for(int i=0;i<numberOfBooks;i++) {
			if(((String) list.get(i)).contains(delete)) {
				System.out.println(list.get(i));
				System.out.print("are you sure?(yes or no)? ");
				String answer=inp.next();
				if(answer.equals("yes"))
					list.remove(i);
			}
		
		
		
	}
		
	}
	//TODO show books
	public static void showBooks() {
		for(int i=0;i<numberOfBooks;i++) {
			System.out.println(list.get(i));
		}
		
		
		
	}
	
	//TODO menu
	
	public static void menu() throws Exception {
		while(true) {
			System.out.print("1_add new book\n" + "2_edit book\n"+ "3_delete book\n"
		+"4_search book" + "5_show books\n" + "enter your choose: ");
			Scanner inp=new Scanner(System.in);
			int choose=inp.nextInt();
			switch(choose) {
				case 1 :
					addNewBook();
					break;
				case 2 :
					editOption();
					break;
				case 3:
					deleteBook();
					break;
				case 4:
					searchBook();
					break;
				case 5:
					showBooks();
					break;
			}
					
					
			
			
			
			
			
			
			
		}
	
		
		
		
	}
	
}
	


