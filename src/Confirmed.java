import java.util.Date;

public class Confirmed extends AllPeople {

	protected String area;
	protected String street;
	protected int street_number;
	protected int zip;
	protected boolean active_status;
	protected int cid;
	protected static int counterForConfirmed = 0;

	public Confirmed(String name, String surname, String email, int phonenumber, int AMKA, String area, String street,
			int street_number, int zip, boolean active_status) throws Exception {
		super(name, surname, email, phonenumber, AMKA);
		counterForConfirmed++;
		this.area = area;
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.active_status = active_status;
		cid = counterForConfirmed;
	}

	public Confirmed(int cid, String name, String surname, String email, int phonenumber, int AMKA, String area,
			String street, int street_number, int zip, boolean active_status) throws Exception {
		super(name, surname, email, phonenumber, AMKA);
		this.area = area;
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.active_status = active_status;
		this.cid = cid;
	}

	public void getsCured(Date cured_date) {
		PersonJdbo persondao = new PersonJdbo();

		// Add the patient to Cured
		persondao.insertIntoCured(new Cured(this,cured_date));
	}

	public void getsDeceased(Date deceased_date) {
		PersonJdbo persondao = new PersonJdbo();

		// Add the patient to Cured
		persondao.insertIntoCured(new Cured(this,deceased_date));

	public void confirmedtoString() {
		String s = "id = " + cid + toString() + "\naddress = " + street + " " + street_number + ", " + area + " " + zip
				+ "\nactive_status = " + active_status;
		System.out.println(s);
	}

	public static String setActive_status(boolean active_status) {
		String s = " SET active_status = '" + active_status + "'";
		return s;
	}

	public static String setArea(String area) {
		String s = " SET area = '" + area + "'";
		return s;
	}

	public static String setStreet(String street) {
		String s = " SET street = '" + street + "'";
		return s;
	}

	public static String setStreet_number(int street_number) {
		String s = " SET street_number = '" + street_number + "'";
		return s;
	}

	public static String setZip(int zip) {
		String s = " SET zip = '" + zip + "'";
		return s;
	}

	public static String setCid(int cid) {
		String s = " SET cid = '" + cid + "'";
		return s;
	}

}
