import java.util.Scanner;

public class Confirmed extends AllPeople {

	protected String area;
	protected String street;
	protected int street_number;
	protected int zip;
	protected boolean active_status;

	public Confirmed(String name, String surname, int AMKA, String area, String street, int street_number, int zip,
			String email, boolean active_status, int phonenumber) {
		super(name, surname, email, phonenumber, AMKA);
		this.area = area;
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.active_status = active_status;
	}

}
