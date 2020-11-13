import java.util.Scanner;

public class VictimContact extends AllPeople {
	
	public VictimContact(String name, String surname) {
		super(name, surname);
		// oti allh plhroforia zhtao na dinetai kata thn epikoinonia 
	}
	
	
	public static void addVictimContact() {
		 Scanner input = new Scanner(System.in);
		 System.out.print("Enter the Name of the patient: ");
		 String name = input.next();
		 System.out.print("Enter the surname: ");
		 String surname = input.next();
		 VictimContact possiblepatient = new VictimContact(name, surname);
		 input.close();
	}

	
	public void classifyContact () {
		//diaxorismos upsilou-xamhlou kindunou
		String result;
		if () {
			result="υψηλού";
		} else {
			result="χαμηλού";
		}
	}

}

