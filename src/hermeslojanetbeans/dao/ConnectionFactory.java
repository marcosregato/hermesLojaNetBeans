package hermeslojanetbeans.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // db parameters
            String url =  "jdbc:sqlite:C:\\workspace\\hermesLojaNetBeans\\src\\BD\\hermesProduto_db.db";
            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
}
