import java.util.Scanner;

public class Confirmed extends AllPeople {

	protected static Confirmed confTable[] = new Confirmed[1];
	protected static int counter = 0;

	public Confirmed(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		super(name, surname, address, email, phonenumber, AMKA);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		if (counter == confTable.length) {
			confTable = (Confirmed[]) duplicateTable(confTable.length, confTable);
		}
		confTable[counter] = this;
		counter++;
	}

	public static void getSick(int id) {
		int pos = -1;
		for (int i = 0; i < VictimContact.victimContactTable.length; i++) {
			if (VictimContact.victimContactTable[i].getId() == id) {
				pos = i;
				break;
			}
		}
		int temp = AllPeople.counter_for_id;
		AllPeople.counter_for_id = id - 1;

		new Confirmed(VictimContact.victimContactTable[pos].name, VictimContact.victimContactTable[pos].surname,
				VictimContact.victimContactTable[pos].address, VictimContact.victimContactTable[pos].email,
				VictimContact.victimContactTable[pos].phonenumber, VictimContact.victimContactTable[pos].AMKA);

		AllPeople.counter_for_id = temp;
		AllPeople.destructor(VictimContact.victimContactTable[pos]);
		VictimContact.counter = VictimContact.counter - 1;
		VictimContact.victimContactTable[pos] = VictimContact.victimContactTable[VictimContact.counter];
	}

	public static void addPatient() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the patient's personal details");
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

