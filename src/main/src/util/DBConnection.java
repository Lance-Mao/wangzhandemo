package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pc on 17-5-13.
 */
public class DBConnection {
    private static Connection conn;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        try {
            conn = DriverManager.getConnection(url, "root", "root");
            if (conn != null) {
                System.out.println(123);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
