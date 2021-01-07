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

	public void alterTables(int id, String fromClass, String set) throws Exception {
		try {
			connect();
			String query = "UPDATE " + fromClass + set + " WHERE id = " + id;
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
			String email = resultSet.getString("email");
			int phonenumber = resultSet.getInt("phonenumber");
			int AMKA = resultSet.getInt("AMKA");
			if (fromClass == "victim_contacts") {
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
			String query = "insert into victim_contacts(name, surname, email, phonenumber, AMKA, confirmed_id, victim_relationship, danger) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setString(1, victimContact.name);
			pstatement.setString(2, victimContact.surname);
			pstatement.setString(3, victimContact.email);
			pstatement.setInt(4, victimContact.phonenumber);
			pstatement.setInt(5, victimContact.AMKA);
			pstatement.setInt(6, victimContact.confirmed_id);
			pstatement.setString(7, victimContact.victim_relationship);
			pstatement.setString(8, victimContact.danger);
			int rows = pstatement.executeUpdate();
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
			String query = "insert into confirmed(name, surname, email, phonenumber, AMKA, area, street, street_number, zip, active_status) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setString(1, confirmed.name);
			pstatement.setString(2, confirmed.surname);
			pstatement.setString(3, confirmed.email);
			pstatement.setInt(4, confirmed.phonenumber);
			pstatement.setInt(5, confirmed.AMKA);
			pstatement.setString(6, confirmed.area);
			pstatement.setString(7, confirmed.street);
			pstatement.setInt(8, confirmed.street_number);
			pstatement.setInt(9, confirmed.zip);
			pstatement.setBoolean(10, confirmed.active_status);
			int rows = pstatement.executeUpdate();
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

	public void insertIntoCured_Deceased(Cured_Deceased patient, String fromclass) throws Exception {
		try {
			connect();
			String query = "insert into " + fromclass + "(id," + fromclass + "_date) values (?,?)";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, patient.id);
			java.sql.Date sql_date = new java.sql.Date(patient.date.getTime());
			pstatement.setDate(2, sql_date);
			int rows = pstatement.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " row/s affected");
				System.out.println("A new Person has been inserted successfully");
				pstatement.close();
				connection.close();
			}
		} catch (Exception e) {
			System.out.println("In Method: PersonJdbo.insertIntoCured\nException: " + e.getMessage());
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
