package formularios;
import java.awt.CardLayout;
import java.awt.Color;
import java.net.*;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
/**
 *
 * @author Agustin
 */
public final class frm_Menu_Principal extends javax.swing.JFrame {

    panel_Alta panel = new panel_Alta();
    panel_Modificacion panelModificacion = new panel_Modificacion();
    panel_Baja panelBaja = new panel_Baja();
    panel_Buscar panelBuscar = new panel_Buscar();
    CardLayout vista;
    
    public frm_Menu_Principal() //constructor
    {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        iconoDelPrograma();
        vista = (CardLayout) panel_Vista_Principal.getLayout();
    }
    public void iconoDelPrograma()
    {
        URL url = getClass().getResource("/imagenes/icono_del_programa.png");
        ImageIcon imagenDelPrograma = new ImageIcon(url);
        setIconImage(imagenDelPrograma.getImage());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        boton_Baja = new javax.swing.JToggleButton();
        boton_Alta = new javax.swing.JToggleButton();
        boton_Salir = new javax.swing.JToggleButton();
        boton_Modificar = new javax.swing.JToggleButton();
        boton_Buscar = new javax.swing.JToggleButton();
        panel_Vista_Principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Empleados");
        setBackground(new java.awt.Color(0, 51, 51));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel1.setText("Menu de opciones");

        boton_Baja.setBackground(new java.awt.Color(204, 204, 204));
        boton_Baja.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boton_Baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Baja.png"))); // NOI18N
        boton_Baja.setText("Baja de Empleado");
        boton_Baja.setMaximumSize(new java.awt.Dimension(213, 73));
        boton_Baja.setMinimumSize(new java.awt.Dimension(213, 73));
        boton_Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_BajaActionPerformed(evt);
            }
        });

        boton_Alta.setBackground(new java.awt.Color(204, 204, 204));
        boton_Alta.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boton_Alta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Alta.png"))); // NOI18N
        boton_Alta.setText("Alta de Empleado");
        boton_Alta.setMaximumSize(new java.awt.Dimension(213, 73));
        boton_Alta.setMinimumSize(new java.awt.Dimension(213, 73));
        boton_Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AltaActionPerformed(evt);
            }
        });

        boton_Salir.setBackground(new java.awt.Color(204, 204, 204));
        boton_Salir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boton_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salir.png"))); // NOI18N
        boton_Salir.setText("Salir del programa");
        boton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_SalirActionPerformed(evt);
            }
        });

        boton_Modificar.setBackground(new java.awt.Color(204, 204, 204));
        boton_Modificar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boton_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar.png"))); // NOI18N
        boton_Modificar.setText("Modificar Datos");
        boton_Modificar.setMaximumSize(new java.awt.Dimension(213, 73));
        boton_Modificar.setMinimumSize(new java.awt.Dimension(213, 73));
        boton_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ModificarActionPerformed(evt);
            }
        });

        boton_Buscar.setBackground(new java.awt.Color(204, 204, 204));
        boton_Buscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        boton_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        boton_Buscar.setText("Buscar Empleado");
        boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_Alta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_Baja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_Alta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(boton_Baja, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(boton_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(boton_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(boton_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panel_Vista_Principal.setBackground(new java.awt.Color(0, 153, 102));
        panel_Vista_Principal.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Vista_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Vista_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ModificarActionPerformed
        if(boton_Modificar.isSelected())
        {
            panel_Vista_Principal.add(panelModificacion, "modificacion");
            vista.show(panel_Vista_Principal, "modificacion");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Baja.setEnabled(false);
            boton_Buscar.setEnabled(false);
            boton_Alta.setEnabled(false);
            boton_Modificar.setBackground(Color.WHITE);
        }
        else
        {
            panel_Vista_Principal.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Baja.setEnabled(true);
            boton_Buscar.setEnabled(true);
            boton_Alta.setEnabled(true);
            boton_Modificar.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_boton_ModificarActionPerformed

    private void boton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_boton_SalirActionPerformed

    private void boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_BuscarActionPerformed
        if(boton_Buscar.isSelected())
        {
            panel_Vista_Principal.add(panelBuscar,"buscar");
            vista.show(panel_Vista_Principal, "buscar");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Baja.setEnabled(false);
            boton_Alta.setEnabled(false);
            boton_Modificar.setEnabled(false);
            boton_Buscar.setBackground(Color.WHITE);
        }
        else
        {
            panel_Vista_Principal.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Baja.setEnabled(true);
            boton_Alta.setEnabled(true);
            boton_Modificar.setEnabled(true);
            boton_Buscar.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_boton_BuscarActionPerformed

    private void boton_AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AltaActionPerformed
        if(boton_Alta.isSelected())
        {
            panel_Vista_Principal.add(panel,"alta");
            vista.show(panel_Vista_Principal, "alta");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Baja.setEnabled(false);
            boton_Buscar.setEnabled(false);
            boton_Modificar.setEnabled(false);
            boton_Alta.setBackground(Color.WHITE);
        }
        else
        {
            panel_Vista_Principal.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Baja.setEnabled(true);
            boton_Buscar.setEnabled(true);
            boton_Modificar.setEnabled(true);
            boton_Alta.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_boton_AltaActionPerformed

    private void boton_BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_BajaActionPerformed
        if(boton_Baja.isSelected())
        {
            panel_Vista_Principal.add(panelBaja,"baja");
            vista.show(panel_Vista_Principal, "baja");
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Alta.setEnabled(false);
            boton_Modificar.setEnabled(false);
            boton_Buscar.setEnabled(false);
            boton_Baja.setBackground(Color.WHITE);
        }
        else
        {
            panel_Vista_Principal.removeAll();
            SwingUtilities.updateComponentTreeUI(this);
            this.repaint();
            boton_Alta.setEnabled(true);
            boton_Modificar.setEnabled(true);
            boton_Buscar.setEnabled(true);
            boton_Baja.setBackground(new Color(204,204,204));
        }
    }//GEN-LAST:event_boton_BajaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton boton_Alta;
    private javax.swing.JToggleButton boton_Baja;
    private javax.swing.JToggleButton boton_Buscar;
    private javax.swing.JToggleButton boton_Modificar;
    private javax.swing.JToggleButton boton_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel_Vista_Principal;
    // End of variables declaration//GEN-END:variables
}
