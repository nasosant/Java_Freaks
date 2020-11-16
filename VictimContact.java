import java.util.Scanner;

public class VictimContact extends AllPeople {

	protected static VictimContact victimContactTable[] = new VictimContact[100];
	protected static VictimContact HighDanger[] = new VictimContact[100];
	protected static VictimContact LowDanger[] = new VictimContact[100];
	private static int i = 0;
	private static int j = 0;
	protected static int counter = 0;
	protected static String housemate;
	protected static String directContact;
	protected static String contactwhilesymptomsoccured;
	protected static String placeToMeet;
	protected static double Distance;
	protected static double Time;
	protected static String Worksector;

	public VictimContact(String name, String surname, String address, String email, int phonenumber, int AMKA,
			String housemate, String directContact, String contactwhilesymptomsoccured, double Distance,
			String placeToMeet, double time, String Worksector) {
		super(name, surname, address, email, phonenumber, AMKA);
		this.housemate = housemate;
		this.directContact = directContact;
		this.contactwhilesymptomsoccured = contactwhilesymptomsoccured;
		this.placeToMeet = placeToMeet;
		this.Distance = Distance;
		this.Time = time;
		this.Worksector = Worksector;
		if (counter == victimContactTable.length) {
			victimContactTable = (VictimContact[]) duplicateTable(victimContactTable.length, victimContactTable);
		}
		victimContactTable[counter] = this;
		counter++;
		classifyContact(this);
	}

	/*
	 * public static void addVictimContact() { Scanner input = new
	 * Scanner(System.in); String name = input.next(); String surname =
	 * input.next(); String address = input.next(); String email = input.next(); int
	 * phonenumber = input.nextInt(); int AMKA = input.nextInt(); VictimContact
	 * possiblepatient = new VictimContact(name, surname, address, email,
	 * phonenumber, AMKA); }
	 */

	public static void classifyContact(VictimContact possiblepatient) {
		if (housemate == "yes" || directContact == "yes" || contactwhilesymptomsoccured == "yes"
				|| (Distance <= 2 && Time > 15) || placeToMeet == "internal" || Worksector == "healthdomain") {
			HighDanger[i] = possiblepatient;
			i++;
			highdanger();
		} else {
			LowDanger[j] = possiblepatient;
			j++;
			lowdanger();
		}
	}

	public static void highdanger() {

		System.out.println("The contact should abide by the following orders.");
		System.out.println("Firstly, staying indoors and have health supervision.");
		System.out.println("Secondly,.");
		System.out.println(".");
		System.out.println(".");

	}

	public static void lowdanger() {

	}
}

