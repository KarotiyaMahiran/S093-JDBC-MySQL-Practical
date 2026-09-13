import java.sql.*;

public class S093JDBC {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "root@123";

        String query = "SELECT * FROM student";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)
        ) {

            System.out.println("S093 MAHIRAN KAROTIYA");
            System.out.println("JDBC Connection Successful!");
            System.out.println();

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println(
                    "ID: " + id +
                    ", Name: " + name +
                    ", Marks: " + marks
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}