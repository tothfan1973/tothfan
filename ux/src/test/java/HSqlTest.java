import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HSqlTest {

    @Test
    public void basicTest() {

        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:C:/Users/cloudlink/Desktop/tothfan/database;user=sa");
            statement = connection.createStatement();

            String sql = "SELECT * FROM PERSON";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("EMPLOYEE Salary:"
                        + resultSet.getString("EMAIL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}




