package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
      Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bd_libreria";
            String user = "root";
            String password = "";
            con= DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        
        } catch (SQLException e) {
            con=null;
            System.out.println("Error no se establecer la conexion:" + e.getMessage());
        }
        return null;
    }
}
