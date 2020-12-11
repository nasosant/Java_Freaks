import java.sql.*;

public class JdboDaoDemo {

	public static void main(String[] args) {
		PersonDAO persondao = new AllPeopleDAO();

		Person person1 = persondao.getPerson(1);// Get a Person from DataBase
		dao.connect();
		System.out.println(person1.name);

		Person person1 = new Person(2, "Nikos");// Create a Person from DataBase
		dao.connect();
		persondao.addPerson(person1);
	}

}

public class PersonDao {

	Connection connection = null;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Connection connection = DriverManager.getConnection(String url,String user,String password);
			// Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=test.db","covidusr","C0v1dusr!")
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=test.db");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Person getPerson(int id) {
		try {
			String query = "SELECT name FROM Person WHERE id=" + id;
			Person person = new Person(id);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("query");
			resultSet.next();
			String name = resultSet.getString(1);
			person.name = name;
			return person;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		Connection.close();
	}

	public void addPerson(Person person) {
		String query = "insert into Person (?,?)";
		PreparedStatement pstatement;
		try {
			pstatement = connection.prepareStatement(query);
			Pstatement.setInt(1, person.id);
			Pstatement.setString(2, person.name);
			Pstatement.executeUpdate();
			int count = Pstatement.executeUpdate();
			System.out.println(count + "row/s affected");
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

	public Person(int id) {
		this.id = id;
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

