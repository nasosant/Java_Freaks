public class AllPeople {

	protected String name;
	protected String surname;
	protected String email;
	protected int phonenumber;
	protected int AMKA;
	private int id;

	public AllPeople(String name, String surname, String email, int phonenumber, int AMKA) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.AMKA = AMKA;
		id = 0;
	}

	@Override
	public String toString() {
		return "name=" + name + ", surname=" + surname + ", id=" + id;
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
}
