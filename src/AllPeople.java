public abstract class AllPeople { //can be renamed to Patient

	protected String name;
	protected String surname;
	protected String address;
	protected String email;
	protected int phonenumber;
	protected int AMKA;
	private int id;
	protected static int counter_for_id = 0;

	public AllPeople(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		counter_for_id++;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.AMKA = AMKA;
		id = counter_for_id;
	}

// 	public static AllPeople[] duplicateTable(int length, AllPeople[] Table) {
// 		AllPeople newTable[] = new AllPeople[2 * length];
// 		for (int i = 0; i < length; i++) {
// 			newTable[i] = Table[i];
// 		}
// 		return newTable;
// 	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", id=" + id; // na balo ta alla pedia
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public static void destructor(int pos, AllPeople[] Table) {
		// Table[pos].finalize();
		System.out.println("The patient has been cured from Covid19");
		Table[pos] = null;
		// System.gc();
	}

	/*
	 * protected void finalize() {
	 * System.out.println("The patient has been cured from Covid19"); }
	 */

}
