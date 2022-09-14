
package sv.edu.udb.util;
import java.sql.*;
 /*    
    ¿Qué tal usar SSL pero desactivar la verificación del servidor como cuando
    está en modo de desarrollo en su propia computadora : ?verifyServerCertificate=false&useSSL=true    
    *************
    
    Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
    Cambios a relizar : com.mysql.cj.jdbc.Driver
    
   *************
    The server time zone value 'Hora est�ndar, Am�rica Centra' is unrecognized or represents more than one time zone
    Cambios a relizar :?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
  */

public class Conexion {
    private Connection conexion = null;
    private Statement s = null;
    private ResultSet rs = null;
    private String query = "";
    
    //constructor
    public Conexion() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://localhost/Guia6poo1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","12345");
            s = conexion.createStatement();
        }
        catch(Exception ex){
            System.out.println("ERROR: No encuentro el driver de la BD: " +ex.getMessage());                        
        }
    }
    
    public ResultSet GetRs(){
        return rs;
    }
    
    public void setRs(String consulta){
        try{
            this.rs = s.executeQuery(consulta);
        } catch(SQLException e2) {
            System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
        }
    }
    
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
}
