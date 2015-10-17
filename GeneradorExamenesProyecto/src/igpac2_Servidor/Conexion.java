package igpac2_Servidor;

import java.sql.*;
/**
* Esta clase muesta realiza la conexion a la base de datos IGPA
* @author: Ivonne Castillo, Gerardo Rico
* @version: 30/09/2015 
*/

public class Conexion {
    
    private static Connection connection = null;
    
    private static final Driver driver = new org.apache.derby.jdbc.ClientDriver();
    private static final String URLDerby = "jdbc:derby://localhost:1527/IGPA";
    
    private static final String user = "IGPA";
    private static final String password = "IGPA";
   
    
    public static Connection getConexion() throws SQLException {
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URLDerby, user, password);
        return connection;
    }   
}

