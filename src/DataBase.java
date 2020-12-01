import java.sql.*;

public class DataBase{

    public static void main (String[] args) {

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=test.db");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("name")+", " + resultSet.getString("email"));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}
