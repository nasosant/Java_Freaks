public class OtherAllPeople {

	protected String name;
	protected String surname;
	protected int id;
	protected static int counter = 0;

	public OtherAllPeople(String name, String surname) {
		++id;
		this.name = name;
		this.surname = surname;
		id = counter;
	}

	public void toStringAllPeople() {
		System.out.printf("Name : %s \nSurname : %s \nid : %d \n", name, surname, id);
	}

	public int getId() {
		return this.id;
	}

	protected void finalize() {
		System.out.println("Object is destroyed by the Garbage Collector");
	}

}

