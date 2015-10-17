package igpac2_Servidor;

import java.sql.*;
import java.util.ArrayList;

/**
* Esta clase realiza las consultas a la base de datos para capturar y almacenar en memoria las materias existentes
* @author: Ivonne Castillo, Gerardo Rico
* @version: 30/09/2015 
*/

public class Materia 
{
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
 
    //public static void main(String[] args) throws SQLException {
    public Materia() {}

    public ArrayList getMateria()throws SQLException {
        
            connection = Conexion.getConexion();
            String consulta = "SELECT IdMateria, Materia FROM Materia";
            ArrayList lista=new ArrayList();
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(consulta);
 
            while (resultSet.next()) {
                int idmateria;
                String materia;
 
                idmateria = resultSet.getInt("IdMateria");
                materia = resultSet.getString("Materia");
               
                lista.add(materia);
            }
             
            resultSet.close();
            resultSet = null;
            statement.close();
            statement= null;
            connection.close();
            connection=null;
            
            return lista;
    }
}
