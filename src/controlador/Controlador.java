package controlador;
import com.mysql.jdbc.Statement;
import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Controlador {
    
    private Connection conexion;
    ConexionBD conexionBD=null;
    
    public Controlador() {
         conexionBD = new ConexionBD();
    }
        
       
    public boolean  validarCredenciales (String email, String contraseña, String tipoUsuario){
        
        boolean respuesta=false;
        String query = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ? AND role = ?";
        conexion = conexionBD.getConnection();
        try {
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, email);
                statement.setString(2, contraseña);
                statement.setString(3, tipoUsuario);
                
                ResultSet resultado = statement.executeQuery();
                
                if (resultado.next()) {
                    respuesta=true;
                }
                
                resultado.close();
            }
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return respuesta;
    }   
    
    public int insertarDatos( String dni,String nombres,String apellidos,String direccion,String telefono,String email, String contraseña ){
        PreparedStatement ps;
        String sql;
        int idDevuelto=0 ;
        try{
            conexion = conexionBD.getConnection();
            sql = "insert into usuarios (dni,nombre,apellido,direccion,telefono,email,contraseña) values(?,?,?,?,?,?,?)";
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dni);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, email);
            ps.setString(7, contraseña);
            
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            if (result.next()) {
                idDevuelto = result.getInt(1);
                return idDevuelto;
            }
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
           return idDevuelto;
    }
    
    public void eliminarUsuario(int id){
          PreparedStatement ps;
        String sql;
        int idDevuelto=0 ;
        try{
            conexion = conexionBD.getConnection();
            sql = "delete from usuarios  where id=?";
            ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);
           
            ps.executeUpdate();
    
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
     }
    
    public void actualizarUsuario( int id,String dni,String nombres,String apellidos,String direccion,String telefono,String email, String contraseña ){
        PreparedStatement ps;
        String sql;
        int idDevuelto=0 ;
        try{
            conexion = conexionBD.getConnection();
            sql = "update usuarios  set dni=?,nombre=?,apellido=?,direccion=?,telefono=?,email=?,contraseña=? where id=?";
            ps = conexion.prepareStatement(sql);

            ps.setString(1, dni);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.setString(6, email);
            ps.setString(7, contraseña);
            ps.setInt(8, id);
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El usuario fue actualizado");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

    }
}
