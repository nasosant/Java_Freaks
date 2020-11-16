public class AllPeople {

	protected String name;
	protected String surname;
	protected String address;
	protected String email;
	protected int phonenumber;
	protected int AMKA;
	private int id;
	protected static int counter_for_id = 0;

	public AllPeople(String name, String surname, String address, String email, int phonenumber, int AMKA) {
		++counter_for_id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.AMKA = AMKA;
		id = counter_for_id;
	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", id=" + id;
	}

	public int getId() {
		return this.id;
	}

	protected void finalize(AllPeople person) {
		System.out.println("The patient " + person.name + " " + person.surname + " with id=" + person.id + " has been cured from Covid19");
	}

}

