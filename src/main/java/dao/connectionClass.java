package dao;
 
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class connectionClass {

    public Connection getConnection()
            throws SQLException, ClassNotFoundException {
        try{
         Class.forName("com.mysql.jdbc.Driver");
       // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return //DriverManager.getConnection(
                //"jdbc:mysql://localhost:3309/mydb", "root", "root");
               DriverManager.getConnection(
                "jdbc:mysql://localhost/mydb", "root", "dragon");
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        Connection conexion = null;
        
        return conexion;
    }
    

}

