import java.util.Scanner;

public class VictimContact extends AllPeople {

	protected static VictimContact victimContactTable[] = new VictimContact[1];
	protected static VictimContact HighDanger[] = new VictimContact[1];
	protected static VictimContact TemperatureofHighDanger[] = new VictimContact[14];
	protected static VictimContact LowDanger[] = new VictimContact[1];
	protected static VictimContact TemperatureofLowDanger[] = new VictimContact[14];
	private static int i = 0; // counter for HighDanger
	private static int j = 0; // counter for LowDanger
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
			String placeToMeet, double Time, String Worksector) {
		super(name, surname, address, email, phonenumber, AMKA);
		this.housemate = housemate;
		this.directContact = directContact;
		this.contactwhilesymptomsoccured = contactwhilesymptomsoccured;
		this.placeToMeet = placeToMeet;
		this.Distance = Distance;
		this.Time = Time;
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
	 * phonenumber = input.nextInt(); int AMKA = input.nextInt(); new
	 * VictimContact(name, surname, address, email, phonenumber, AMKA); }
	 */

	public static void classifyContact(VictimContact possiblepatient) {
		if (housemate == "yes" || directContact == "yes" || contactwhilesymptomsoccured == "yes"
				|| (Distance <= 2 && Time > 15) || placeToMeet == "internal" || Worksector == "healthdomain") {
			if (i == HighDanger.length) {
				HighDanger = (VictimContact[]) duplicateTable(HighDanger.length, HighDanger);
			}
			HighDanger[i] = possiblepatient;
			i++;
			highdanger();
		} else {
			if (j == LowDanger.length) {
				LowDanger = (VictimContact[]) duplicateTable(LowDanger.length, LowDanger);
			}
			LowDanger[j] = possiblepatient;
			j++;
			lowdanger();
		}
	}

	public static void highdanger() {

	}

	public static void lowdanger() {

	}

	/*
	 * System.out.println("The contact should abide by the following orders.");
	 * System.out.println("Firstly, staying indoors and have health supervision.");
	 * System.out.println("Secondly,."); System.out.println(".");
	 * System.out.println(".");
	 */
}

