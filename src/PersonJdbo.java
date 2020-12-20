import java.sql.*;

public class PersonJdbo {
	Connection connection;

	public PersonJdbo() {
		this.connection = null;
	}

	public void connect() throws Exception {
		try {
			// Class.forName("com.mysql.jdbc.Driver"); Δεν νομίζω οτι χρειάζεται
			String url = "jdbc:mysql://140.238.84.59:3306/";
			String db = "covid_tracking";
			String user = "katerina";
			String password = "K@ter1n@";
			connection = DriverManager.getConnection(url + db, user, password);
			if (connection != null) {
				System.out.println("Successfully connected to the database");
			}
		} catch (Exception e) {
			System.out.println("In Method: connect\nException: " + e.getMessage());
		}

	}

	public Person getPerson(int id) throws Exception {
		try {
			connect();
			String query = "SELECT name FROM Person WHERE id = " + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			String name = resultSet.getString(1);
			Person person = new Person(id, name);
			statement.close();
			connection.close();
			return person;
		} catch (Exception e) {
			System.out.println("In Method: getPerson\nException: " + e.getMessage());
			return null;
		}

	}

	public void addPerson(Person person) throws Exception {
		try {
			connect();
			String query = "insert into Person values (?,?)";
			PreparedStatement pstatement;
			pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, person.id);
			pstatement.setString(2, person.name);
			int rows = pstatement.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + " row/s affected");
				System.out.println("A new Person has been inserted successfully");
			}
			pstatement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("In Method: addPerson\nException: " + e.getMessage());
		}
	}

	public void removePerson(int id) throws Exception {
		try {
			connect();
			String query = "DELETE FROM Person WHERE id = " + id;
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
			System.out.println("In Method: removePerson\nException: " + e.getMessage());
		}
	}
}

