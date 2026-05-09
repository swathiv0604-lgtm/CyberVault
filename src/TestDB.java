import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cybervault",
                "root",
                "root"
            );

            System.out.println("CONNECTED SUCCESSFULLY");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}