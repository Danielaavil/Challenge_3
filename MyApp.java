import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyApp {
    public static void main(String[] args) {
        Connection connection = DatabaseConnector.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM mytable";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    // Process the query results
                    String data = resultSet.getString("column_name");
                    System.out.println(data);
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
