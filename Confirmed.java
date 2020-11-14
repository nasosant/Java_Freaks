import java.util.Scanner;

public class Confirmed extends AllPeople {

	protected static Confirmed confTable[] = new Confirmed[100];
	private static int counter = 0;

	public Confirmed(String name, String surname) {
		super(name, surname);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia
		confTable[counter] = this;
		counter++;
	}

	public static void addPatient() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Name of the patient: ");
		String name = input.next();
		System.out.print("Enter the surname: ");
		String surname = input.next();
		Confirmed patient = new Confirmed(name, surname);
	}

}

