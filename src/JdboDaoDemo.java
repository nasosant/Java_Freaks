import java.sql.*;

public class JdboDaoDemo {

	public static void main(String[] args) {
		PersonDao persondao = new PersonDao();

		Person person1 = persondao.getPerson(1);// Get a Person from DataBase
		System.out.println(person1.name);

		person1 = new Person(2, "Nikos");// Create a Person from DataBase
		persondao.addPerson(person1);
	}

	public static class PersonDao {

		Connection connection = null;

		public void connect() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://140.238.84.59:3306/COVID tracking", "katerina", "K@ter1n@");
				if (connection != null) {
					System.out.println("Successfully connected to the database");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		public Person getPerson(int id) {
			try {
				connect();
				String query = "SELECT name FROM Person WHERE id = " + id;
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("query");
				resultSet.next();
				String name = resultSet.getString(1);
				Person person = new Person(id, name);
				statement.close();
				connection.close();
				return person;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}

		public void addPerson(Person person) {
			try {
				connect();
				String query = "insert into Person values (?,?)";
				PreparedStatement pstatement;
				pstatement = connection.prepareStatement(query);
				pstatement.setInt(1, person.id);
				pstatement.setString(2, person.name);
				int rows = pstatement.executeUpdate();
				if (rows > 0) {
					System.out.println(rows + "row/s affected");
					System.out.println("A new Person has been inserted successfully")
				}
				pstatement.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public void removePerson(int id) {
			try {
				connect();
				String query = "DELETE FROM Person WHERE id = " + id;
				PreparedStatement pstatement;
				pstatement = connection.prepareStatement(query);
				int rows = pstatement.executeUpdate();
				if (rows > 0) {
					System.out.println(rows + "row/s affected");
					System.out.println("The person with the id = " + id + "has been deleted");
					pstatement.close();
					connection.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public static class Person {
		int id;
		String name;

		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}

