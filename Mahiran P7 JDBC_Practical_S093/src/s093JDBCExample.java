import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class s093JDBCExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "root@123";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("S093 MAHIRAN KAROTIYA");
            System.out.println("Connected to MySQL successfully!");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM student"
            );

            System.out.println("\nStudent Records:");
            System.out.println("-----------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "  " +
                    rs.getString("name") + "  " +
                    rs.getInt("marks")
                );
            }

            rs.close();
            stmt.close();
            con.close();

            System.out.println("\nConnection closed.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}