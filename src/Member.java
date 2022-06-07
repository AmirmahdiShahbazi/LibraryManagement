import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	private String name;
	private String nationalCode;
	private String phoneNumber;
	private int numberOfMembers;
	private String specifications;
	private ArrayList list=new ArrayList();
	
	public Member() {
		
	}
	//TODO setter
	public Member(String name, String nationalCode,String phoneNumber) {
		this.name=name;
		this.nationalCode=nationalCode;
		this.phoneNumber=phoneNumber;
		
	//TODO getter methods							
	}
	public String getName() {
		return name;
	}
	
	public String getNationalCode() {
		return nationalCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//TODO number of members
	public int getingNumberOfMembers() {
		Scanner inp=new Scanner(System.in);
		System.out.print("enter number of members: ");	
		numberOfMembers=inp.nextInt();
		return numberOfMembers;
		
		
		
	}
	
	//TODO add new member
	public void addNewMember() {
		String str="";
		getingNumberOfMembers();
		Member[] member=new Member[numberOfMembers];
		for(int i=0;i<numberOfMembers;i++) {
			Scanner inp=new Scanner(System.in);
			System.out.print("enter members name: ");
			String name=inp.next();
			System.out.print("enter members national code: ");
			String nationalCode=inp.next();
			System.out.print("enter phone number: ");
			String phoneNumber=inp.next();
			member[i] =new Member(name,nationalCode,phoneNumber);
			specifications=member[i].getName()+member[i].nationalCode+member[i].phoneNumber;			
			if(str.contains(specifications))
			{
				System.out.println("specifications already registered\n"+ "you can chnge specifications by edit option ");
			}
			else {
				System.out.println(specifications);
				str+=specifications;
			}			
			list.add(specifications);
		
		}
		
		
	}
	//TODO edit information
	public void editInformation() {
		Scanner inp=new Scanner(System.in);
		System.out.print("enter national code: ");
		String edit=inp.next();
		for(int i=0;i<numberOfMembers;i++) {
			if(((String) list.get(i)).contains(edit)) {
				System.out.println(list.get(i));				
				System.out.print("enter Members name: ");
				String name=inp.next();
				System.out.print("enter members national code: ");
				String natioalCode=inp.next();
				System.out.print("enter members phone number ");
				String phoneNumber=inp.next();
				}
		}
	

	}
	//TODO search member
	public void searchMember() {
		Scanner inp=new Scanner(System.in);
		System.out.print("enter national code: ");
		String search=inp.next();
		for(int i=0;i<numberOfMembers;i++) {
			if(((String) list.get(i)).contains(search)) 
				System.out.println(list.get(i));
		
		}
		
		
		
		
	}
	
	
	
	
	//TODO menu
	public void menu() throws Exception {
		while(true) {
			System.out.print("1_add new member\n" + "2_edit members information\n"+ "3_search member\n "
		+"enter your chioce: ");
			Scanner inp=new Scanner(System.in);
			int choose=inp.nextInt();
			switch(choose) {
				case 1 :
					addNewMember();
					break;
				case 2 :
					editInformation();
					break;									
				case 3:
					searchMember();
					break;
				
					
			 }
					
					
			
			
			
			
			
			
			
		}
	
		
		
		
	}
		
		

}

