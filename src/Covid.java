public class Covid {

	public static void main(String[] args) throws Exception {
		// Call the method login() and starts the program with the Registration
		checkId("confirmed");
		checkId("victim_contacts");
		Registration obj = new Registration();
		obj.login();
	}

	public static void checkId(String fromClass) throws Exception {
		PersonJdbo persondao = new PersonJdbo();
		int count = persondao.check(fromClass);
		for (int i = 1; i <= count; i++) {
			AllPeople person = persondao.showAll(fromClass, i);
			if (person == null) {
				count++;
			} else {
				if (fromClass.equals("confirmed")) {
					Confirmed patient = (Confirmed) person;
					Confirmed.counterForConfirmed = patient.cid + 1;
				} else {
					VictimContact victim = (VictimContact) person;
					VictimContact.counterForVictimContact = victim.vid + 1;
				}
			}
		}
	}
}
