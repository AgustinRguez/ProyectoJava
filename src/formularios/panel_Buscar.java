package formularios;

import SQL.conexion_basedatos;
import SQL.metodosBaseDD;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Agustin
 */
public final class panel_Buscar extends javax.swing.JPanel {

    public panel_Buscar() {
        initComponents();
        cargarDatosEnLaTabla();
        
    }
    DefaultTableModel tabla;
    String columnas[] = {"Dni", "Nombre", "Apellido", "Dia", "Mes", "Año", "Domicilio", "Telefono", "Area", "Contraseña"};
    String filas[] = new String[10];
    Connection conexion;
    PreparedStatement sentenciaPreparada;
    ResultSet resultado; 

    public void cargarDatosEnLaTabla() {
        tabla = new DefaultTableModel(null, columnas);
        try {
            conexion = conexion_basedatos.conexionALaBase();
            String consulta = "SELECT * FROM datos_empleado";
            sentenciaPreparada = conexion.prepareStatement(consulta);           
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) {
                filas[0] = resultado.getString(1);
                filas[1] = resultado.getString(2);
                filas[2] = resultado.getString(3);
                filas[3] = resultado.getString(4);
                filas[4] = resultado.getString(5);
                filas[5] = resultado.getString(6);
                filas[6] = resultado.getString(7);
                filas[7] = resultado.getString(8);
                filas[8] = resultado.getString(9);
                filas[9] = resultado.getString(10);
                tabla.addRow(filas);
            }
            tblTablaConDatos.setModel(tabla);
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } 
        
            finally //cerrado forzoso por si no pasa el primer close
            {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(panel_Buscar.class.getName()).log(Level.SEVERE,null,ex);
                    System.out.println("Error: " + ex);
                }
            }
    }

    public void buscarDatosPorDni(double dni) {
        tabla = new DefaultTableModel(null, columnas);
        try {
            conexion = conexion_basedatos.conexionALaBase();
            String consulta = "SELECT * FROM datos_empleado WHERE dni = ?"/*LIKE  + '"' + dni + "%" + '"'*/;
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setDouble(1, dni);
            resultado = sentenciaPreparada.executeQuery();
            while (resultado.next()) {
                filas[0] = resultado.getString(1);
                filas[1] = resultado.getString(2);
                filas[2] = resultado.getString(3);
                filas[3] = resultado.getString(4);
                filas[4] = resultado.getString(5);
                filas[5] = resultado.getString(6);
                filas[6] = resultado.getString(7);
                filas[7] = resultado.getString(8);
                filas[8] = resultado.getString(9);
                filas[9] = resultado.getString(10);
                tabla.addRow(filas);
            }
            tblTablaConDatos.setModel(tabla);
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } 
            finally //cerrado forzoso por si no pasa el primer close
            {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(panel_Buscar.class.getName()).log(Level.SEVERE,null,ex);
                    System.out.println("Error: " + ex);
                }
            }
    }
    public void filtrar(double dni) {
        tabla = new DefaultTableModel(null, columnas);
        try {
            conexion = conexion_basedatos.conexionALaBase();
            String consulta = "SELECT * FROM datos_empleado WHERE dni = ?"/*LIKE  + '"' + dni + "%" + '"'*/;
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setDouble(1, dni);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next()){
                lblInformacionBusqueda.setText("Resultados posibles");
            }
            else{
                lblInformacionBusqueda.setText("Sin resultados");
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } 
                finally //cerrado forzoso por si no pasa el primer close
                {
                    try {
                        conexion.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(panel_Buscar.class.getName()).log(Level.SEVERE,null,ex);
                        System.out.println("Error: " + ex);
                    }
                }
        
    }
    public void limpiar(){
        if(txtIngresarDniBusqueda.getText().isEmpty()){
            lblInformacionBusqueda.setText("Acerque el mouse para verificar DNI");
            txtIngresarDniBusqueda.setText("");
            cargarDatosEnLaTabla();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaConDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtIngresarDniBusqueda = new javax.swing.JTextField();
        lblInformacionBusqueda = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(1119, 665));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Busqueda de empleado/a");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel12.setText("Datos de empleado/a");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tblTablaConDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        jScrollPane1.setViewportView(tblTablaConDatos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1066, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese DNI para realizar busqueda:");

        txtIngresarDniBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIngresarDniBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresarDniBusquedaKeyTyped(evt);
            }
        });

        lblInformacionBusqueda.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInformacionBusqueda.setText("Acerque el mouse para verificar DNI");
        lblInformacionBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInformacionBusquedaMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtIngresarDniBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(lblInformacionBusqueda))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIngresarDniBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInformacionBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1119, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngresarDniBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresarDniBusquedaKeyTyped
         if (txtIngresarDniBusqueda.getText().length() == 8) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtIngresarDniBusquedaKeyTyped

    private void lblInformacionBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacionBusquedaMouseEntered
        buscarDatosPorDni(Double.parseDouble((String)txtIngresarDniBusqueda.getText()));
        filtrar(Double.parseDouble((String) txtIngresarDniBusqueda.getText()));
    }//GEN-LAST:event_lblInformacionBusquedaMouseEntered

    private void txtIngresarDniBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresarDniBusquedaKeyReleased
        limpiar();
    }//GEN-LAST:event_txtIngresarDniBusquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblInformacionBusqueda;
    public javax.swing.JTable tblTablaConDatos;
    public javax.swing.JTextField txtIngresarDniBusqueda;
    // End of variables declaration//GEN-END:variables
}
