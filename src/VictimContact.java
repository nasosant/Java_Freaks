public class VictimContact extends AllPeople {

	protected String victim_relationship;
	protected String danger;
	protected int confirmed_id;
	protected int vid;
	protected static int counterForVictimContact = 0;

	public VictimContact(String name, String surname, String email, int phonenumber, int AMKA, int confirmed_id,
			String victim_relationship, String danger) {
		super(name, surname, email, phonenumber, AMKA);
		counterForVictimContact++;
		this.victim_relationship = victim_relationship;
		this.confirmed_id = confirmed_id;
		this.danger = danger; // this.danger = classifyContact(victim_relationship);
		vid = counterForVictimContact;
	}

	public VictimContact(int vid, String name, String surname, String email, int phonenumber, int AMKA,
			int confirmed_id, String victim_relationship, String danger) {
		super(name, surname, email, phonenumber, AMKA);
		this.victim_relationship = victim_relationship;
		this.confirmed_id = confirmed_id;
		this.danger = danger; // this.danger = classifyContact(victim_relationship);
		this.vid = vid;
	}

	public static void getSick(int id, String area, String street, int street_number, int zip) throws Exception {
		PersonJdbo persondao = new PersonJdbo();

		// Get the person from DataBase
		VictimContact victimContact = (VictimContact) persondao.getPerson(id, "victim_contacts");

		// Create the patient to DataBase
		Confirmed patient = new Confirmed(victimContact.name, victimContact.surname, victimContact.email,
				victimContact.phonenumber, victimContact.AMKA, area, street, street_number, zip, true);

		// Add a Confirmed to DataBase
		persondao.addConfirmed(patient);

		// Remove a Person from DataBase
		persondao.removePerson(id, "victim_contacts");
	}

	public void victimContacttoString() {
		String s = "id = " + vid + toString() + "\nvictim_relationship = " + victim_relationship + "\ndanger = "
				+ danger + "\ncaught the flu from the patient with id = " + confirmed_id;
		System.out.println(s);
	}

	public static String setVictim_relationship(String victim_relationship) {
		String s = " SET victim_relationship = '" + victim_relationship + "'";
		return s;
	}

	public static String setDanger(String danger) {
		String s = " SET danger = '" + danger + "'";
		return s;
	}

	public static String setConfirmed_id(int confirmed_id) {
		String s = " SET confirmed_id = '" + confirmed_id + "'";
		return s;
	}

	public static String setVid(int vid) {
		String s = " SET vid = '" + vid + "'";
		return s;
	}

}
