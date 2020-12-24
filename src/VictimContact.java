public class VictimContact extends AllPeople {

	protected String victim_relationship;
	protected String danger;
	protected int confirmed_id;

	public VictimContact(String name, String surname, String email, int phonenumber, int AMKA, int confirmed_id,
			String victim_relationship, String danger) {
		super(name, surname, email, phonenumber, AMKA);
		this.victim_relationship = victim_relationship;
		// this.danger = classifyContact(victim_relationship);
		this.confirmed_id = confirmed_id;
	}

	public void getSick(int id, String area, String street, int street_number, int zip, boolean active_status)
			throws Exception {
		PersonJdbo persondao = new PersonJdbo();

		// Get the person from DataBase
		VictimContact victimContact = (VictimContact) persondao.getPerson(id, "VictimContact");

		// Create the patient to DataBase
		Confirmed patient = new Confirmed(victimContact.name, victimContact.surname, victimContact.email,
				victimContact.phonenumber, victimContact.AMKA, area, street, street_number, zip, active_status);
		persondao.addConfirmed(patient);

		// Remove a Person from DataBase
		persondao.removePerson(id, "VictimContact");
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
