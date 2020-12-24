import java.util.Scanner;

public class VictimContact extends AllPeople {
	protected String victim_relationship;
	protected String danger;
	protected int confirmed_id;

	public VictimContact(String name, String surname, int confirmed_id, int AMKA, String email,
			String victim_relationship, String danger, int phonenumber) {
		super(name, surname, email, phonenumber, AMKA);
		this.victim_relationship = victim_relationship;
		this.danger = classifyContact(victim_relationship);
		this.confirmed_id = confirmed_id;
	}

	public static String classifyContact(String victim_relationship) {
		if (victim_relationship == "housemate" || victim_relationship == "directContact"
				|| contactwhilesymptomsoccured == "yes" || (Distance <= 2 && Time > 15) || placeToMeet == "internal"
				|| Worksector == "healthdomain") {
			return "high";
		} else {
			return "low";
		}
	}
}
