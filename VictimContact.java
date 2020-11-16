import java.util.Scanner;

public class VictimContact extends AllPeople {

	protected static VictimContact victimContactTable[] = new VictimContact[1];
	protected static VictimContact HighDanger[] = new VictimContact[1];
	protected static VictimContact LowDanger[] = new VictimContact[1];
	protected static int counter = 0;

	public VictimContact(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		super(name, surname, address, email, phonenumber, AMKA);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		if (counter == victimContactTable.length) {
			victimContactTable = (VictimContact[]) duplicateTable(victimContactTable.length, victimContactTable);
		}
		victimContactTable[counter] = this;
		counter++;
	}

	public static void addVictimContact() {
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
		new VictimContact(name, surname, address, email, phonenumber, AMKA);
	}

	// diaxorismos upsilou-xamhlou kindunou

	/*public void classifyContact() {
		String result;
		if (true) {
			result = "υψηλού";
		} else {
			result = "χαμηλού";
		}
	}*/

}

