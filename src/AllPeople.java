public class AllPeople {

	protected String name;
	protected String surname;
	protected String email;
	protected int phonenumber;
	protected int AMKA;

	public AllPeople(String name, String surname, String email, int phonenumber, int AMKA) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.AMKA = AMKA;
	}

	@Override
	public String toString() {
		String s = "\nname = " + name + "\nsurname = " + surname + "\nemail = " + email + "\nphonenumber = "
				+ phonenumber + "\nAMKA = " + AMKA;
		return s;
	}

	public static String setName(String name) {
		String s = " SET name = '" + name + "'";
		return s;
	}

	public static String setSurname(String surname) {
		String s = " SET surname = '" + surname + "'";
		return s;
	}

	public static String setEmail(String email) {
		String s = " SET email = '" + email + "'";
		return s;
	}

	public static String setPhonenumber(int phonenumber) {
		String s = " SET phonenumber = '" + phonenumber + "'";
		return s;
	}

	public static String setAMKA(int AMKA) {
		String s = " SET ΑMKA = '" + AMKA + "'";
		return s;
	}

}
