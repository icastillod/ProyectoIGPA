
package igpac2_Servidor;

import static igpac2_Servidor.Materia.statement;
import java.sql.*;
import java.util.ArrayList;

public class Tema {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
 
    //public static void main(String[] args) throws SQLException {
    public Tema() {}
    
    public int getidmateria(String materia ) throws SQLException{
        
        connection = Conexion.getConexion();
            
        String consultaMateria = "SELECT IdMateria FROM Materia WHERE Materia = "+materia;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(consultaMateria);
        int idmateria = resultSet.getInt("IdMateria");
        resultSet.close();
        resultSet = null;
        statement.close();
        statement= null;
        connection.close();
        connection=null;
        
        return idmateria; 
    }

    public ArrayList getTema(String materia)throws SQLException {
        
            int idmateria = getidmateria(materia);            
            String consulta = "SELECT Tema FROM Tema where IdMateria = " + idmateria;
            ArrayList lista=new ArrayList();
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(consulta);
 
            while (resultSet.next()) {
                
                String tema;
 
                tema = resultSet.getString("Tema");
               
                lista.add(tema);
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
