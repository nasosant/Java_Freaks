public class Covid {

	public static void main(String[] args) throws Exception {
		// Call the method login() and starts the programm with the Registration
		PersonJdbo persondao = new PersonJdbo();
		int count = persondao.check("confirmed");
		for (int i = 1; i <= count; i++) {
			Confirmed patient = (Confirmed) persondao.showAll("confirmed", i);
			if (patient == null) {
				count++;
			} else {
				Confirmed.counterForConfirmed = patient.cid + 1;
			}
		}
		int count_1 = persondao.check("victim_contacts");
		for (int i = 1; i <= count_1; i++) {
			VictimContact victim = (VictimContact) persondao.showAll("victim_contacts", i);
			if (victim == null) {
				count_1++;
			} else {
				VictimContact.counterForVictimContact = victim.vid + 1;
			}
		}
		Registration obj = new Registration();
		obj.login();
	}

}
