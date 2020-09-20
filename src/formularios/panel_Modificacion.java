/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import SQL.metodosBaseDD;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.UUID;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Ezequiel
 */
public final class panel_Modificacion extends javax.swing.JPanel {

    /**
     * Creates new form panel_Modificacion
     */
    public panel_Modificacion() {
        initComponents();
        guardarGif();
        generarAños();
        bloquear();
    }
    metodosBaseDD metodos_base = new metodosBaseDD();
    public void generarContraseña()
    {
        String contraseña = "";
        contraseña = UUID.randomUUID().toString().toLowerCase().substring(0,10); //convertir el random a string y solo minuscula
        txtActualizarContraseña.setText(contraseña);
    }
    public void guardarGif()
    {
        ImageIcon gif;
        gif = new ImageIcon(getClass().getResource("/imagenes/Check.gif"));// retorna getclass el objeto ejecutado de la clase imageicon
        Icon auxiliarGif = new ImageIcon(gif.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
        btnGuardar.setIcon(auxiliarGif);     
    }
    public void generarAños() {
        int i;
        for (i = 2020; i >= 1955; i--) {
            ComboActualizarAño.addItem(String.valueOf(i));
        }
    }
    public void borrarDatos() {
        txtActualizarApellido.setText("");
        txtActualizarNombre.setText("");
        txtActualizarContraseña.setText("");
        //txtDniActualizar.setText("");
        txtActualizarDomicilio.setText("");
        txtActualizarTelefono.setText("");
        ComboActualizarArea.setSelectedIndex(0);
        ComboActualizarAño.setSelectedIndex(0);
        ComboActualizarDia.setSelectedIndex(0);
        ComboActualizarMes.setSelectedIndex(0);
        lblInformacionActualizar.setText("");
    }
    public void busquedaDeDni(){
        
        double dni = Double.parseDouble((String) txtDniActualizar.getText());
        String mensaje = metodosBaseDD.buscarDni(dni);
        if(mensaje.equals("Existe Dni")){
           lblInformacionActualizar.setText("Dni encontrado");
           desbloquear();
        }
        else{
           borrarDatos();
           lblInformacionActualizar.setText("Dni NO encontrado"); 
           bloquear();
        }    
    }
    public void modificarDatos(){
        String nombre = txtActualizarNombre.getText();
        String apellido = txtActualizarApellido.getText();
        int dia = Integer.parseInt((String)ComboActualizarDia.getSelectedItem());
        String mes = ComboActualizarMes.getSelectedItem().toString();
        int año = Integer.parseInt((String)ComboActualizarAño.getSelectedItem());
        String domicilio = txtActualizarDomicilio.getText();
        double telefono = Double.parseDouble((String) txtActualizarTelefono.getText());
        String area = ComboActualizarArea.getSelectedItem().toString();
        String contraseña = txtActualizarContraseña.getText();
        double dni = Double.parseDouble((String) txtDniActualizar.getText());
        metodos_base.modificarDatos(nombre, apellido, dia, mes, año, domicilio, telefono, area, contraseña, dni);
        borrarDatos();
        borrarDos();
    }
    
     public void bloquear() {
         for (Component a: jPanel3.getComponents()) {
             a.setEnabled(false);
         }
         for (Component b: jPanel4.getComponents()){
             b.setEnabled(false);
         }
     }
     public void desbloquear(){
         for (Component a: jPanel3.getComponents()) {
             a.setEnabled(true);
         }
         for (Component b: jPanel4.getComponents()){
             b.setEnabled(true);
         }
         validacion();
     }
     public void borrarDos(){
        lblInformacionActualizar.setText("Acerque el mouse para verificar DNI");
        txtDniActualizar.setText("");
        bloquear();
     }
     
     public void validacion(){
     if(ComboActualizarArea.getSelectedItem().equals("Elegir Area") || ComboActualizarAño.getSelectedItem().equals("Elija Año")
             || ComboActualizarDia.getSelectedItem().equals("Elija Dia") || ComboActualizarMes.getSelectedItem().equals("Elija Mes")
             || txtActualizarApellido.getText().isEmpty() || txtActualizarContraseña.getText().isEmpty() || txtActualizarDomicilio.getText().isEmpty()
             || txtActualizarNombre.getText().isEmpty() || txtActualizarTelefono.getText().isEmpty())
     {
         btnGuardar.setEnabled(false);
     }
     else{
         btnGuardar.setEnabled(true);
     }
}
     /*public void validar() {
        String mensaje = metodosBaseDD.buscarDni(Double.parseDouble((String) txtDniActualizar.getText()));
        if (mensaje.equals("Existe Dni")) {
            lblInformacionActualizar.setText("El Dni ya esta registrado.");
        } else {
            lblInformacionActualizar.setText("El Dni no esta registrado.");
        }
    }*/
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
        txtActualizarNombre = new javax.swing.JTextField();
        txtActualizarApellido = new javax.swing.JTextField();
        txtActualizarDomicilio = new javax.swing.JTextField();
        txtActualizarContraseña = new javax.swing.JTextField();
        ComboActualizarDia = new javax.swing.JComboBox<>();
        ComboActualizarArea = new javax.swing.JComboBox<>();
        lblInformacionContraseña = new javax.swing.JLabel();
        btnContraseñaRandomActualizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtActualizarTelefono = new javax.swing.JTextField();
        ComboActualizarAño = new javax.swing.JComboBox<>();
        ComboActualizarMes = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDniBuscar = new javax.swing.JLabel();
        txtDniActualizar = new javax.swing.JTextField();
        lblInformacionActualizar = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Modificacion de Empleado/a");
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

        txtActualizarNombre.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtActualizarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtActualizarNombreKeyReleased(evt);
            }
        });

        txtActualizarApellido.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtActualizarApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtActualizarApellidoKeyReleased(evt);
            }
        });

        txtActualizarDomicilio.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtActualizarDomicilio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtActualizarDomicilioKeyReleased(evt);
            }
        });

        txtActualizarContraseña.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtActualizarContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtActualizarContraseñaKeyReleased(evt);
            }
        });

        ComboActualizarDia.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ComboActualizarDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        ComboActualizarDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboActualizarDiaItemStateChanged(evt);
            }
        });

        ComboActualizarArea.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ComboActualizarArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir Area", "RRHH", "Calidad", "Sistemas", "Arquitectura", "Cobranzas", "Ventas" }));
        ComboActualizarArea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboActualizarAreaItemStateChanged(evt);
            }
        });

        lblInformacionContraseña.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInformacionContraseña.setText("<html><center>Generar contraseña automatica<p>(opcional)");

        btnContraseñaRandomActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnContraseñaRandomActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/generarRandom.png"))); // NOI18N
        btnContraseñaRandomActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContraseñaRandomActualizarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Telefono:");

        txtActualizarTelefono.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtActualizarTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtActualizarTelefonoKeyReleased(evt);
            }
        });

        ComboActualizarAño.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ComboActualizarAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija Año" }));
        ComboActualizarAño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboActualizarAñoItemStateChanged(evt);
            }
        });

        ComboActualizarMes.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ComboActualizarMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        ComboActualizarMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboActualizarMesItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Año de Nacimiento:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Mes de Nacimiento:");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel12.setText("Ingrese los datos a modificar");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(25, 25, 25))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtActualizarDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtActualizarApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                            .addComponent(txtActualizarNombre)))
                                    .addComponent(ComboActualizarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboActualizarMes, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboActualizarAño, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel7))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(txtActualizarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ComboActualizarArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblInformacionContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtActualizarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnContraseñaRandomActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtActualizarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtActualizarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtActualizarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ComboActualizarArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboActualizarDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtActualizarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(ComboActualizarMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnContraseñaRandomActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboActualizarAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformacionContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtActualizarDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Check.gif"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/goma.png"))); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel13.setText("Opciones");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel14.setText("Actualizar");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel15.setText(" Borrar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel14)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(73, 73, 73)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(85, 85, 85))
        );

        lblDniBuscar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDniBuscar.setText("Ingrese el dni a buscar:");

        txtDniActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniActualizarKeyTyped(evt);
            }
        });

        lblInformacionActualizar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInformacionActualizar.setText("Acerque el mouse para verificar DNI");
        lblInformacionActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInformacionActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInformacionActualizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(lblDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDniActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInformacionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInformacionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1135, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnContraseñaRandomActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContraseñaRandomActualizarActionPerformed
        generarContraseña();
        validacion();
    }//GEN-LAST:event_btnContraseñaRandomActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        modificarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDniActualizarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniActualizarKeyTyped
        if (txtDniActualizar.getText().length() == 8) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtDniActualizarKeyTyped

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        borrarDatos();
        borrarDos();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void lblInformacionActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacionActualizarMouseEntered
        busquedaDeDni();
    }//GEN-LAST:event_lblInformacionActualizarMouseEntered

    private void lblInformacionActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacionActualizarMouseExited
        lblInformacionActualizar.setText("Acerque el mouse para verificar DNI"); 
    }//GEN-LAST:event_lblInformacionActualizarMouseExited

    private void txtActualizarNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActualizarNombreKeyReleased
        validacion();
    }//GEN-LAST:event_txtActualizarNombreKeyReleased

    private void txtActualizarApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActualizarApellidoKeyReleased
        validacion();
    }//GEN-LAST:event_txtActualizarApellidoKeyReleased

    private void txtActualizarDomicilioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActualizarDomicilioKeyReleased
        validacion();
    }//GEN-LAST:event_txtActualizarDomicilioKeyReleased

    private void txtActualizarTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActualizarTelefonoKeyReleased
        validacion();
    }//GEN-LAST:event_txtActualizarTelefonoKeyReleased

    private void txtActualizarContraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActualizarContraseñaKeyReleased
        validacion();
    }//GEN-LAST:event_txtActualizarContraseñaKeyReleased

    private void ComboActualizarDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboActualizarDiaItemStateChanged
        validacion();
    }//GEN-LAST:event_ComboActualizarDiaItemStateChanged

    private void ComboActualizarMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboActualizarMesItemStateChanged
        validacion();
    }//GEN-LAST:event_ComboActualizarMesItemStateChanged

    private void ComboActualizarAñoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboActualizarAñoItemStateChanged
        validacion();
    }//GEN-LAST:event_ComboActualizarAñoItemStateChanged

    private void ComboActualizarAreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboActualizarAreaItemStateChanged
        validacion();
    }//GEN-LAST:event_ComboActualizarAreaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboActualizarArea;
    private javax.swing.JComboBox<String> ComboActualizarAño;
    private javax.swing.JComboBox<String> ComboActualizarDia;
    private javax.swing.JComboBox<String> ComboActualizarMes;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnContraseñaRandomActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel lblDniBuscar;
    private javax.swing.JLabel lblInformacionActualizar;
    private javax.swing.JLabel lblInformacionContraseña;
    private javax.swing.JTextField txtActualizarApellido;
    private javax.swing.JTextField txtActualizarContraseña;
    private javax.swing.JTextField txtActualizarDomicilio;
    private javax.swing.JTextField txtActualizarNombre;
    private javax.swing.JTextField txtActualizarTelefono;
    private javax.swing.JTextField txtDniActualizar;
    // End of variables declaration//GEN-END:variables
}
