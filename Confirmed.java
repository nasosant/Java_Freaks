import java.util.Scanner;

public class Confirmed extends AllPeople {

	protected static Confirmed confTable[] = new Confirmed[100];
	protected static int counter = 0;

	public Confirmed(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		super(name, surname, address, email, phonenumber, AMKA);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		if (counter == confTable.length) {
			confTable = duplicateTable(confTable.length, confTable);
		}
		confTable[counter] = this;
		counter++;
	}

	public static Confirmed[] duplicateTable(int length, Confirmed[] confTable) {
		Confirmed newconfTable[] = new Confirmed[2 * length];
		for (int i = 0; i < length; i++) {
			newconfTable[i] = confTable[i];
		}
		return newconfTable;
	}

	// public static getSick ()

	public static void addPatient() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the patient's personal details");
		System.out.print("Enter the name: ");
		String name = input.next();
		System.out.print("Enter the surname: ");
		String surname = input.next();
		System.out.print("Enter the address: ");
		String address = input.next();
		System.out.print("Enter the email: ");
		String email = input.next();
		System.out.print("Enter the phonenumber: ");
		int phonenumber = input.nextInt();
		System.out.print("Enter the AMKA: ");
		int AMKA = input.nextInt();
		new Confirmed(name, surname, address, email, phonenumber, AMKA);
	}

}

