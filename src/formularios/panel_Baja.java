package formularios;

import SQL.conexion_basedatos;
import SQL.metodosBaseDD;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustin
 */
public final class panel_Baja extends javax.swing.JPanel {

    public panel_Baja() {
        initComponents();
        eliminarPng();
        bloquear();
        //guardarGif();
    }
    metodosBaseDD instancia = new metodosBaseDD();
    private static Connection conexion; //se puede poner public la variable de metodosSql e importandola
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;
    
    public void guardarGif() {
        ImageIcon gif;
        gif = new ImageIcon(getClass().getResource("/imagenes/eliminar_gif.gif"));// retorna getclass el objeto ejecutado de la clase imageicon
        Icon auxiliarGif = new ImageIcon(gif.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btnAceptarEliminar.setIcon(auxiliarGif);
    }

    public void eliminarPng() {
        ImageIcon gif;
        gif = new ImageIcon(getClass().getResource("/imagenes/imagen_eliminar_png.png"));// retorna getclass el objeto ejecutado de la clase imageicon
        Icon auxiliarGif = new ImageIcon(gif.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btnAceptarEliminar.setIcon(auxiliarGif);
    }

    public void bloquear() {
        for (Component a : jPanel3.getComponents()) {
            a.setEnabled(false);
        }
        for (Component b : jPanel4.getComponents()) {
            b.setEnabled(false);
        }
        eliminarPng();
    }

    public void desbloquear() {
        for (Component a : jPanel3.getComponents()) {
            a.setEnabled(true);
        }
        for (Component b : jPanel4.getComponents()) {
            b.setEnabled(true);
        }
        guardarGif();
    }

    public void borrarDatosConDniIncluido() {
        lblNombreDelBorrado.setText("");
        lblApellidoDelBorrado.setText("");
        lblDiaDelBorrado.setText("");
        lblMesDelBorrado.setText("");
        lblAñoDelBorrado.setText("");
        lblDomicilioDelBorrado.setText("");
        lblTelefonoDelBorrado.setText("");
        lblAreaDelBorrado.setText("");
        lblContraseñaDelBorrado.setText("");
        txtIngresarDni.setText("");
    }
    public void borrarDatosDosSinDniIncluido(){
        lblNombreDelBorrado.setText("");
        lblApellidoDelBorrado.setText("");
        lblDiaDelBorrado.setText("");
        lblMesDelBorrado.setText("");
        lblAñoDelBorrado.setText("");
        lblDomicilioDelBorrado.setText("");
        lblTelefonoDelBorrado.setText("");
        lblAreaDelBorrado.setText("");
        lblContraseñaDelBorrado.setText("");
    }
    public void buscarParaEliminar(double dni){
        try {
            conexion = conexion_basedatos.conexionALaBase();
            String busqueda = "SELECT * FROM datos_empleado WHERE dni = ?";
            sentenciaPreparada = conexion.prepareStatement(busqueda);
            sentenciaPreparada.setDouble(1, dni);
            resultado = sentenciaPreparada.executeQuery();
            if(resultado.next()){
                lblInformacionEliminar.setText("<html><center>Dni encontrado, puede eliminar y quitar el mouse");
                lblNombreDelBorrado.setText(resultado.getString("nombre"));
                lblApellidoDelBorrado.setText(resultado.getString("apellido"));
                lblDiaDelBorrado.setText(resultado.getString("dia"));
                lblMesDelBorrado.setText(resultado.getString("mes"));
                lblAñoDelBorrado.setText(resultado.getString("año"));
                lblDomicilioDelBorrado.setText(resultado.getString("domicilio"));
                lblTelefonoDelBorrado.setText(resultado.getString("telefono"));
                lblAreaDelBorrado.setText(resultado.getString("area"));
                lblContraseñaDelBorrado.setText(resultado.getString("contraseña")); 
                desbloquear();
            }
            else{
                lblInformacionEliminar.setText("<html><center>Dni No encontrado, no puede eliminar");
                bloquear();
                borrarDatosDosSinDniIncluido();
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
                finally //cerrado forzoso por si no pasa el primer close
                {
                    try 
                    {
                      conexion.close();
                    } catch (SQLException e)
                      {
                        System.out.println("Error: " + e);
                      }
                }
        limpiarCaja();
    }
    public void limpiarCaja(){
        if(txtIngresarDni.getText().isEmpty()){
            lblInformacionEliminar.setText("Acerque el mouse para verificar DNI");
            borrarDatosConDniIncluido();
            bloquear();
        }
    }
    public void preguntarAlEliminar(){
        int pregunta;
        pregunta = JOptionPane.showConfirmDialog(null, "Eliminar al empleado de la base de datos?", "Confirmar borrado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(pregunta == 0){
            instancia.eliminarEmpleado(Double.parseDouble((String)txtIngresarDni.getText()));
            borrarDatosConDniIncluido();
            bloquear();
        }
        else if(pregunta == 1){
            JOptionPane.showMessageDialog(null, "No se ha eliminado al empleado de la base de datos");
            borrarDatosConDniIncluido();
            bloquear();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNombreDelBorrado = new javax.swing.JLabel();
        lblApellidoDelBorrado = new javax.swing.JLabel();
        lblDiaDelBorrado = new javax.swing.JLabel();
        lblMesDelBorrado = new javax.swing.JLabel();
        lblAñoDelBorrado = new javax.swing.JLabel();
        lblDomicilioDelBorrado = new javax.swing.JLabel();
        lblTelefonoDelBorrado = new javax.swing.JLabel();
        lblAreaDelBorrado = new javax.swing.JLabel();
        lblContraseñaDelBorrado = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnAceptarEliminar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtIngresarDni = new javax.swing.JTextField();
        lblInformacionEliminar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Baja de Empleado/a");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Apellido/s:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Dia de Nacimiento:");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Domicilio:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("Area de trabajo:");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Contraseña:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Telefono:");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Año de Nacimiento:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Mes de Nacimiento:");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel12.setText("Datos del empleado/a");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblNombreDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNombreDelBorrado.setText("---");

        lblApellidoDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblApellidoDelBorrado.setText("---");

        lblDiaDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDiaDelBorrado.setText("---");

        lblMesDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblMesDelBorrado.setText("---");

        lblAñoDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAñoDelBorrado.setText("---");

        lblDomicilioDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDomicilioDelBorrado.setText("---");

        lblTelefonoDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblTelefonoDelBorrado.setText("---");

        lblAreaDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAreaDelBorrado.setText("---");

        lblContraseñaDelBorrado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblContraseñaDelBorrado.setText("---");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(108, 108, 108)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombreDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(lblApellidoDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiaDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMesDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAñoDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDomicilioDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefonoDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(46, 46, 46)
                        .addComponent(lblAreaDelBorrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblContraseñaDelBorrado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(213, 213, 213))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNombreDelBorrado)
                    .addComponent(jLabel7)
                    .addComponent(lblAreaDelBorrado))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblApellidoDelBorrado)
                    .addComponent(jLabel8)
                    .addComponent(lblContraseñaDelBorrado))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDiaDelBorrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblMesDelBorrado))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblAñoDelBorrado))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDomicilioDelBorrado))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTelefonoDelBorrado))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnAceptarEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptarEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen_eliminar_png.png"))); // NOI18N
        btnAceptarEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEliminarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setText("Opciones");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel14.setText("Eliminar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(btnAceptarEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(73, 73, 73)
                .addComponent(btnAceptarEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(303, Short.MAX_VALUE))
        );

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel25.setText("Ingrese Dni del empleado a borrar:");

        txtIngresarDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresarDniKeyTyped(evt);
            }
        });

        lblInformacionEliminar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInformacionEliminar.setText("Acerque el mouse para verificar DNI");
        lblInformacionEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInformacionEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInformacionEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIngresarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInformacionEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIngresarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInformacionEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEliminarActionPerformed
        preguntarAlEliminar();
    }//GEN-LAST:event_btnAceptarEliminarActionPerformed

    private void txtIngresarDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresarDniKeyTyped
        if (txtIngresarDni.getText().length() >= 8) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        limpiarCaja();
    }//GEN-LAST:event_txtIngresarDniKeyTyped

    private void lblInformacionEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacionEliminarMouseEntered
        buscarParaEliminar(Double.parseDouble((String)txtIngresarDni.getText()));
    }//GEN-LAST:event_lblInformacionEliminarMouseEntered

    private void lblInformacionEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacionEliminarMouseExited
        lblInformacionEliminar.setText("Acerque el mouse para verificar DNI");
    }//GEN-LAST:event_lblInformacionEliminarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblApellidoDelBorrado;
    private javax.swing.JLabel lblAreaDelBorrado;
    private javax.swing.JLabel lblAñoDelBorrado;
    private javax.swing.JLabel lblContraseñaDelBorrado;
    private javax.swing.JLabel lblDiaDelBorrado;
    private javax.swing.JLabel lblDomicilioDelBorrado;
    private javax.swing.JLabel lblInformacionEliminar;
    private javax.swing.JLabel lblMesDelBorrado;
    private javax.swing.JLabel lblNombreDelBorrado;
    private javax.swing.JLabel lblTelefonoDelBorrado;
    public javax.swing.JTextField txtIngresarDni;
    // End of variables declaration//GEN-END:variables
}
