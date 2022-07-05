import java.util.ArrayList;
import java.util.Scanner;

public class Member {
	static Scanner input = new Scanner(System.in);

	private String name;
	private String family;
	private String nationalCode;
	private String phoneNumber;

	public Member() {

	}

	public Member(String name, String family, String nationalCode, String phoneNumber) {
		this.name = name;
		this.family = family;
		this.nationalCode = nationalCode;
		this.phoneNumber = phoneNumber;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		String output = String.format(
				"Member name: %s \nMember family: %s \nMember national code: %s \nMember phone: %s \n",
				name, family, nationalCode, phoneNumber);
		return output;
	}

	// static method
	public static int searchMember(ArrayList<Member> members, String search) {

		for (int i = 0; i < members.size(); i++) {
			String name = members.get(i).name;
			String family = members.get(i).family;
			String nationalCode = members.get(i).nationalCode;

			if (name.equalsIgnoreCase(search) || family.equalsIgnoreCase(search)
					|| nationalCode.equals(search)) {
				return i;
			}
		}

		return -1;
	}

	public static void addMember(ArrayList<Member> members) throws Exception {
		System.out.print("\n\n");
		input.nextLine();
		System.out.print("Member name: ");
		String name = input.nextLine();

		System.out.print("Member family: ");
		String family = input.nextLine();

		System.out.print("Member national code: ");
		String nationalCode = input.next();

		System.out.print("Member phone: ");
		String phoneNumber = input.next();

		if (searchMember(members, nationalCode) == -1) {
			Member m1 = new Member(name, family, nationalCode, phoneNumber);
			members.add(m1);

			System.out.print("\n");
			System.out.print("The member was added");
			Thread.sleep(3000);
		} else {
			System.out.print("\n");
			System.out.print("This member exists");
			Thread.sleep(3000);
		}
	}

	public static void editInformation(ArrayList<Member> members) throws Exception {
		System.out.print("\n\n");
		input.nextLine();
		System.out.print("Enter national code: ");
		String search = input.nextLine();
		int index = searchMember(members, search);

		if (index != -1) {
			System.out.print("\n\n");
			System.out.println(members.get(index).toString());

			System.out.print("\n");
			System.out.print("New name: ");
			members.get(index).setName(input.nextLine());

			System.out.print("New family: ");
			members.get(index).setFamily(input.nextLine());

			System.out.print("New national code: ");
			members.get(index).setNationalCode(input.next());

			System.out.print("New phone number: ");
			members.get(index).setPhoneNumber(input.next());

			System.out.print("\n");
			System.out.print("The member was updated");
			Thread.sleep(3000);
		} else {
			System.out.print("\n");
			System.out.print("Oops the member was not found");
			Thread.sleep(3000);
		}
	}

	public static void searchMember(ArrayList<Member> members) throws Exception {
		System.out.print("\n\n");
		input.nextLine();
		System.out.print("Enter name or family or national code: ");
		String search = input.nextLine();
		int index = searchMember(members, search);

		if (index != -1) {
			System.out.print("\n\n");
			System.out.println(members.get(index).toString());
			System.out.print("\nIf you want to go back to the previous menu, enter a character: ");
			input.next();
		} else {
			System.out.print("\n");
			System.out.print("Oops the book was not found");
			Thread.sleep(3000);
		}
	}

	// menu
	public static void menu(ArrayList<Member> members) throws Exception {
		menuLoop: while (true) {
			System.out.print("\n\n\n");
			System.out.print("2,1) Add new member \n2,2) Edit member \n2,3) Search member \n2,0) Back"
					+ "\n\nEnter your choice: ");
			int choose = input.nextInt();

			switch (choose) {
				case 1:
					addMember(members);
					break;
				case 2:
					editInformation(members);
					break;
				case 3:
					searchMember(members);
					break;
				case 0:
					break menuLoop;
			}

		}

	}

}
