
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Conexion {
    String url;
    Connection conexion;
    public Conexion(String url){
        this.url = url;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void conectar(){
        try {
            Class.forName("org.sqlite.JDBC");//para activar el driver
            conexion = DriverManager.getConnection("jdbc:sqlite:"+url);
            
        } catch (SQLException e) {
            System.out.println("Error con la conexin a la base de datos: "+e);
        }
          catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null,ex);
        } 
    
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        }catch (SQLException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error Cerrando", e);
        }
    }
   
}