package SQL;
/**
 *
 * @author Agustin
 */
import java.sql.*;
import java.net.URL;

public class conexion_basedatos {
   private static String url = "jdbc:mysql://localhost/baseabm"; //lee local y ruta
   private static String usuario = "root";
   private static String contraseña = "root";
    
    public static Connection conexionALaBase()
    {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //jdbc API, permite ejecuciones en bdd
        //crea una representacion en memoria de la clase a traves de class devolviendo la referencia como instancia(conexion entre ambas clases permitiendo interactuar)de clase
            conexion = DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("Conexion hecha");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " +e);
        }
        return conexion;
    }
}
