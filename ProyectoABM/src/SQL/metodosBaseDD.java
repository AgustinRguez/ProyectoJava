/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustin
 */
public class metodosBaseDD {
    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado; //result de cada consulta a bdd
    int i;
    
    //metodos para conectarse
    
    public void altaEmpleado(double dni, String nombre, String apellido, int dia, String mes, int año, String domicilio, double telefono,
                             String area, String contraseña)
    {
        try {
            conexion = conexion_basedatos.conexionALaBase();
            String consulta = "INSERT INTO datos_empleado (dni,nombre,apellido,dia,mes,año,domicilio,telefono,area,contraseña) VALUES (?,?,?,?,?,?,?,?,?,?)"; //evitar sql inyection
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setDouble(1, dni);
            sentenciaPreparada.setString(2, nombre);
            sentenciaPreparada.setString(3, apellido);
            sentenciaPreparada.setInt(4, dia);
            sentenciaPreparada.setString(5, mes);
            sentenciaPreparada.setInt(6, año);
            sentenciaPreparada.setString(7, domicilio);
            sentenciaPreparada.setDouble(8, telefono);
            sentenciaPreparada.setString(9, area);
            sentenciaPreparada.setString(10, contraseña);
            i = sentenciaPreparada.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(null, "Datos cargados");//en medio de pantalla null
                }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error al guardar");
                    }
            conexion.close();
        } catch (HeadlessException | SQLException e)
          {
                System.out.println("Error: " + e); //muestra excepcion
          }
                /*finally //cerrado forzoso por si no pasa el primer close
                {
                    try 
                    {
                      conexion.close();
                    } catch (SQLException e)
                      {
                        System.out.println("Error: " + e);
                      }
                }*/
    }
    
    public static String buscarDni(double dni)
    {
        String auxiliarMensaje = null;
        try {
            conexion = conexion_basedatos.conexionALaBase();
            String consulta = "SELECT dni FROM datos_empleado WHERE dni = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setDouble(1, dni);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next())
            {
                auxiliarMensaje = "Existe Dni";
            }
                else
                {
                    auxiliarMensaje = "No existe Dni";
                }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
                /*finally //cerrado forzoso por si no pasa el primer close
                {
                    try 
                    {
                      conexion.close();
                    } catch (SQLException e)
                      {
                        System.out.println("Error: " + e);
                      }
                }*/
        return auxiliarMensaje;
    }
}
