package modelo;
import com.mysql.jdbc.Statement;
import modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CategoriasDAO {
    private Connection conexion;
    ConexionBD conexionBD=null;
    
    public CategoriasDAO() {
         conexionBD = new ConexionBD();
    }
    
    public int insertarCategorias( String tipo ){
        PreparedStatement ps;
        String sql;
        int idDevuelto=0 ;
        try{
            conexion = conexionBD.getConnection();
            sql = "insert into categorias (tipo) values(?)";
            ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tipo);
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
    
    public void eliminarCategorias(int id){
        PreparedStatement ps;
        String sql;
        int idDevuelto=0 ;
        try{
            conexion = conexionBD.getConnection();
            sql = "delete from categorias  where id=?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
     }
    
    public void actualizarCategorias( int id,String tipo ){
        PreparedStatement ps;
        String sql;
        int idDevuelto=0 ;
        try{
            conexion = conexionBD.getConnection();
            sql = "update usuarios  set dni=?,nombre=?,apellido=?,direccion=?,telefono=?,email=?,contraseña=? where id=?";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setInt(2, id);            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "La categoria fue actualizada");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
}
