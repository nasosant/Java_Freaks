public class Confirmed extends AllPeople {

	protected String area;
	protected String street;
	protected int street_number;
	protected int zip;
	protected boolean active_status;
	protected int cid;
	protected int counterForConfirmed;

	public Confirmed(String name, String surname, String email, int phonenumber[], int AMKA, String area, String street,
			int street_number, int zip, boolean active_status) throws Exception {
		super(name, surname, email, phonenumber, AMKA);
		counterForConfirmed++;
		this.area = area;
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.active_status = active_status;
		PersonJdbo persondao = new PersonJdbo();
		cid = persondao.check("confirmed") + 1;
	}
	
	public Confirmed(int cid, String name, String surname, String email, int phonenumber[], int AMKA, String area, String street,
			int street_number, int zip, boolean active_status) throws Exception {
		super(name, surname, email, phonenumber, AMKA);
		this.area = area;
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.active_status = active_status;
		this.cid = cid;
	}


	public void confirmedtoString() {
		String s = "id = " + cid + toString() + "\naddress = " + street + " " + street_number + ", " + area + " " + zip
				+ "\nactive_status = " + active_status;
		System.out.println(s);
	}

}
