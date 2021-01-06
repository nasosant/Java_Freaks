public class AllPeople {

	protected String name;
	protected String surname;
	protected String email;
	protected int phonenumber[];
	protected int AMKA;

	public AllPeople(String name, String surname, String email, int phonenumber[], int AMKA) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.AMKA = AMKA;
	}

	@Override
	public String toString() {
		String s = "\nname = " + name + "\nsurname = " + surname + "\nemail = " + email + "\nphonenumber = ";
		for (int i = 0; i < phonenumber.length; i++) {
			if (i > 0) {
				s += ", ";
			}
			s += phonenumber[i];
		}
		s += "\nAMKA = " + AMKA;
		return s;
	}

	public static String setName(String name) {
		String s = " SET name = '" + name + "'";
		return s;
	}

	public void setSurname(String surname) {

	}

	public void setEmail(String email) {

	}

	public void setPhonenumber(int[] phonenumber) {

	}

	public void setAMKA(int ΑMKA) {

	}

}
