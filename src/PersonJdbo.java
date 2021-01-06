import java.sql.*;

public class PersonJdbo {
	Connection connection;

	public PersonJdbo() {
		this.connection = null;
	}

	public void connect() throws Exception {
		try {
			String url = "jdbc:mysql://140.238.84.59:3306/";
			String db = "covid_tracking";
			String user = "katerina";
			String password = "K@ter1n@";
			connection = DriverManager.getConnection(url + db, user, password);
			if (connection != null) {
				System.out.println("Successfully connected to the database");
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.connect\nException: " + e.getMessage());
		}

	}

	public void alterTables(int id, String fromClass) throws Exception {
		try {
			connect();
			String query = "UPDATE " + fromClass + AllPeople.setName("Nikos") + " WHERE id = " + id;
			PreparedStatement pstatement;
			pstatement = connection.prepareStatement(query);
			int rows = pstatement.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " row/s affected");
				pstatement.close();
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.alterTables\nException: " + e.getMessage());
		}
	}

	public AllPeople getPerson(int id, String fromClass) throws Exception {
		try {
			connect();
			String query = "SELECT * FROM " + fromClass + " WHERE id = " + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			String name = resultSet.getString("name");
			String surname = resultSet.getString("surname");
			int AMKA = resultSet.getInt("AMKA");
			String email = resultSet.getString("email");
			if (fromClass == "victim_contacts") {
				String query2 = "SELECT * FROM contact_phone WHERE id = " + id;
				Statement statement2 = connection.createStatement();
				ResultSet resultSet2 = statement2.executeQuery(query2);
				int counter = 0;
				while (resultSet2.next()) {
					counter++;
				}
				resultSet2 = statement2.executeQuery(query2);
				int[] phonenumber = new int[counter];
				int i = -1;
				while (resultSet2.next()) {
					i++;
					phonenumber[i] = resultSet2.getInt("phone");
				}
				int confirmed_id = resultSet.getInt("id");
				String victim_relationship = resultSet.getString("victim_relationship");
				String danger = resultSet.getString("danger");
				VictimContact victimContact = new VictimContact(id, name, surname, email, phonenumber, AMKA,
						confirmed_id, victim_relationship, danger);
				statement.close();
				connection.close();
				System.out.println("Successfully got the person with the id=" + id + " from " + fromClass);
				return victimContact;
			} else {
				String query2 = "SELECT * FROM confirmed_phone WHERE id = " + id;
				Statement statement2 = connection.createStatement();
				ResultSet resultSet2 = statement2.executeQuery(query2);
				int counter = 0;
				while (resultSet2.next()) {
					counter++;
				}
				resultSet2 = statement2.executeQuery(query2);
				int[] phonenumber = new int[counter];
				int i = -1;
				while (resultSet2.next()) {
					i++;
					phonenumber[i] = resultSet2.getInt("phone");
				}
				String area = resultSet.getString("area");
				String street = resultSet.getString("street");
				int street_number = resultSet.getInt("street_number");
				int zip = resultSet.getInt("zip");
				boolean active_status = resultSet.getBoolean("active_status");
				Confirmed confirmed = new Confirmed(id, name, surname, email, phonenumber, AMKA, area, street,
						street_number, zip, active_status);
				statement.close();
				connection.close();
				System.out.println("Successfully got the person with the id=" + id + " from " + fromClass);
				return confirmed;
			}

		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.getPerson\nException: " + e.getMessage());
			return null;
		}

	}

	public void addVictimContact(VictimContact victimContact) throws Exception {
		try {
			connect();
			String query = "insert into victim_contacts(name, surname, email, AMKA, confirmed_id, victim_relationship, danger) values (?,?,?,?,?,?,?)";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setString(1, victimContact.name);
			pstatement.setString(2, victimContact.surname);
			pstatement.setString(3, victimContact.email);
			pstatement.setInt(4, victimContact.AMKA);
			pstatement.setInt(5, victimContact.confirmed_id);
			pstatement.setString(6, victimContact.victim_relationship);
			pstatement.setString(7, victimContact.danger);
			int rows = pstatement.executeUpdate();
			String query2 = "insert into contact_phone(id,phone) values (?,?)";
			PreparedStatement pstatement2 = connection.prepareStatement(query2);
			for (int i = 0; i < victimContact.phonenumber.length; i++) {
				pstatement2.setInt(1, victimContact.vid);
				pstatement2.setInt(2, victimContact.phonenumber[i]);
				rows += pstatement2.executeUpdate();
			}
			if (rows > 0) {
				System.out.println(rows + " row/s affected");
				System.out.println("A new Person has been inserted successfully");
				pstatement.close();
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.addVictimContact\nException: " + e.getMessage());
		}
	}

	public void addConfirmed(Confirmed confirmed) throws Exception {
		try {
			connect();
			String query = "insert into confirmed(name, surname, email, AMKA, area, street, street_number, zip, active_status) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setString(1, confirmed.name);
			pstatement.setString(2, confirmed.surname);
			pstatement.setString(3, confirmed.email);
			pstatement.setInt(4, confirmed.AMKA);
			pstatement.setString(5, confirmed.area);
			pstatement.setString(6, confirmed.street);
			pstatement.setInt(7, confirmed.street_number);
			pstatement.setInt(8, confirmed.zip);
			pstatement.setBoolean(9, confirmed.active_status);
			int rows = pstatement.executeUpdate();
			String query2 = "insert into confirmed_phone(id,phone) values (?,?)";
			PreparedStatement pstatement2 = connection.prepareStatement(query2);
			for (int i = 0; i < confirmed.phonenumber.length; i++) {
				pstatement2.setInt(1, confirmed.cid);
				pstatement2.setInt(2, confirmed.phonenumber[i]);
				rows += pstatement2.executeUpdate();
			}
			if (rows > 0) {
				System.out.println(rows + " row/s affected");
				System.out.println("A new Person has been inserted successfully");
				pstatement.close();
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.addConfirmed\nException: " + e.getMessage());
		}
	}

	public void removePerson(int id, String fromClass) throws Exception {
		try {
			connect();
			String query = "DELETE FROM " + fromClass + " WHERE id = " + id;
			PreparedStatement pstatement;
			pstatement = connection.prepareStatement(query);
			int rows = pstatement.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " row/s affected");
				System.out.println("The person with the id=" + id + " has been deleted");
				pstatement.close();
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.removePerson\nException: " + e.getMessage());
		}
	}

	public AllPeople showAll(String fromClass, int count) throws Exception {
		try {
			connect();
			String query = "SELECT * FROM " + fromClass;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			int i = 0;
			while (resultSet.next()) {
				i++;
				if (fromClass == "victim_contacts") {
					VictimContact victimContact = (VictimContact) getPerson(count, fromClass);
					return victimContact;
				} else {
					Confirmed patient = (Confirmed) getPerson(count, fromClass);
					return patient;
				}
			}
			if (i == 0) {
				System.out.println("None has been inserted yet");
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.showAll\nException: " + e.getMessage());
		}
		return null;
	}

	public int check(String fromClass) throws Exception {
		int i = 0;
		try {
			connect();
			String query = "SELECT * FROM " + fromClass;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				i++;
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.check\nException: " + e.getMessage());
		}
		return i;
	}
}
