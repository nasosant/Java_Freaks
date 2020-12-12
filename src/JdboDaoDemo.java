import java.sql.*;

public class JdboDaoDemo {

	public static void main(String[] args) {
		PersonDAO persondao = new AllPeopleDAO();

		Person person1 = persondao.getPerson(1);// Get a Person from DataBase
		System.out.println(person1.name);

		Person person1 = new Person(2, "Nikos");// Create a Person from DataBase
		persondao.addPerson(person1);
	}

}

public class PersonDao {

	Connection connection = null;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connection connection = DriverManager.getConnection(String url,String user,String password);
			// Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=test.db","covidusr","C0v1dusr!");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=test.db");
			if (connection != null) {
				System.out.println("Successfully connected to the database")
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Person getPerson(int id) {
		try {
			dao.connect();
			String query = "SELECT name FROM Person WHERE id = " + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("query");
			resultSet.next();
			String name = resultSet.getString(1);
			Person person = new Person(id, name);
			return person;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		statement.close();
		Connection.close();
	}

	public void addPerson(Person person) {
		try {
			dao.connect();
			String query = "insert into Person (?,?)";
			PreparedStatement pstatement;
			pstatement = connection.prepareStatement(query);
			Pstatement.setInt(1, person.id);
			Pstatement.setString(2, person.name);
			int rows = Pstatement.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + "row/s affected");
				System.out.println("A new Person has been inserted successfully")
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Pstatement.close();
		Connection.close();
	}

	public void removePerson(int id) {
		try {
			dao.connect();
			String query = "DELETE FROM Person WHERE id = " + id;
			PreparedStatement pstatement;
			pstatement = connection.prepareStatement(query);
			int rows = Pstatement.executeUpdate();
			if (rows > 0) {
				System.out.println(rows + "row/s affected");
				System.out.println("The person with the id = " + id + "has been deleted");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Pstatement.close();
		Connection.close();
	}
}

public class Person {
	int id;
	String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

