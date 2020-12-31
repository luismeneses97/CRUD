
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.concurrent.atomic.AtomicInteger;

public class Empleado {
   private final static AtomicInteger count = new AtomicInteger(0); 
   private long id;
   private String nombre,apellido, correo, celular, cargo, salario;
   private Boolean esProveedor;
public Empleado(){
    
}
  
public Empleado(String nombre, String correo, String celular, String salario){
    this.nombre = nombre;
    this.correo = correo;
    this.celular = celular;
    this.salario = salario;
    this.id = count.incrementAndGet();
}
public Empleado(long id, String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo){
    this.id = id;
    this.nombre = nombre;
    this.apellido= apellido;
    this.correo = correo;
    this.celular = celular;
    this.cargo = cargo;
    this.salario = salario;
    this.esProveedor = esProveedor;
}
public Empleado(String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo){
    this.nombre = nombre;
    this.apellido= apellido;
    this.correo = correo;
    this.celular = celular;
    this.cargo = cargo;
    this.salario = salario;
    this.esProveedor = esProveedor;
    this.id = count.incrementAndGet();
}
public void setId(long id){
    this.id  = id;
}
public long getId(){
    return id;
}
public void setNombre(String nombre){
    this.nombre  = nombre;
}
public String getNombre(){
    return nombre;
}
public void setApellido(String apellido){
    this.apellido  = apellido;
}
public String getApellido(){
    return apellido;
}
public void setCorreo(String correo){
    this.correo  = correo;
}
public String getCorreo(){
    return correo;
}
public void setCelular(String celular){
    this.celular  = celular;
}
public String getCelular(){
    return celular;
}
public void setEsProveedor(Boolean esProveedor){
    this.esProveedor  = esProveedor;
}
public Boolean getEsProveedor(){
    return esProveedor;
}
public void setSalario(String salario){
    this.salario  = salario;
}
public String getSalario(){
    return salario;
}
public void setCargo(String cargo){
    this.cargo  = cargo;
}
public String getCargo(){
    return cargo;
}
public void Crear(){
    try {
        Conexion objetoConexion = new Conexion("mydb.db");
        objetoConexion.conectar();//hace la conexion con la base de datos
        Statement stmt = objetoConexion.conexion.createStatement();
        String query = "INSERT INTO empleados (nombre, apellido, correo, celular, esProveedor, salario, cargo)"+
                   " VALUES ('"+this.nombre+"','"+this.apellido+"', '"+this.correo+"','"+this.celular+"','"+this.esProveedor+"','"+this.salario+"','"+this.cargo+"');";
        stmt.execute(query);
        
        stmt.close();
        objetoConexion.cerrarConexion();
    } catch (SQLException e) {
    }
}
public static void Actualizar(long id, String nombre, String apellido, String correo, String celular, Boolean esProveedor, String salario, String cargo){
    try {
        Conexion objetoConexion = new Conexion("mydb.db");
        objetoConexion.conectar();
        Statement stmt = objetoConexion.getConexion().createStatement();
        String query = "UPDATE empleados SET nombre='"+nombre+"', apellido = '"+apellido+"', correo = '"+correo+"', celular = '"+celular+"', esProveedor = '"+esProveedor+"', salario =  '"+salario+"', cargo = '"+cargo+"' "+
                "WHERE id = "+id+";";
        stmt.executeUpdate(query);
        stmt.close();
        objetoConexion.cerrarConexion();
    } catch (Exception e) {
    }
}
public static void Borrar(long id){
        try{
            Conexion objetoConexion = new Conexion("mydb.db");
            objetoConexion.conectar();
            Statement stmt = objetoConexion.getConexion().createStatement();
            String query = "DELETE FROM empleados WHERE id = "+(int)id+";";
            stmt.execute(query);
            stmt.close();
            objetoConexion.cerrarConexion();
        }catch(SQLException ex) {
        
        }
    }

public static ArrayList<Empleado> Leer(){
    ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    try {
        Conexion objetoConexion = new Conexion("mydb.db");
        objetoConexion.conectar();
        Statement stmt = objetoConexion.getConexion().createStatement();
        String query = "SElECT * FROM empleados;";
        ResultSet result = stmt.executeQuery(query);
        while(result.next()){
            long id = result.getLong("id");
            String nombre = result.getString("nombre");
            String apellido = result.getString("apellido");
            String correo = result.getString("correo");
            String celular = result.getString("celular");
            Boolean esProveedor = result.getBoolean("esProveedor");
            String salario = result.getString("salario");
            String cargo = result.getString("cargo");
            empleados.add(new Empleado(id, nombre, apellido,correo, celular, esProveedor, salario, cargo));
        }
        result.close();
        objetoConexion.cerrarConexion();
    } catch (SQLException e) {
    }
    return empleados;
}

}
