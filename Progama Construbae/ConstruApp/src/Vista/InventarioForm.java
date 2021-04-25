/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conexion;
import Controlador.InventarioDAO;
import Controlador.ProyectoDAO;
import Modelo.Inventario;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Seba-PC
 */
public class InventarioForm extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Inventario inv = new Inventario();
    InventarioDAO idao = new InventarioDAO();
    ProyectoDAO pdao = new ProyectoDAO();

    int r;
    PreparedStatement ps;
    ResultSet rs;
    Connection con = Conexion.getCon();
    Usuario u = new Usuario();

    public InventarioForm() {
        initComponents();
        listarProducto();
        pdao.listarProyecto(jComboBox1);
    }

    void listarProducto() {
        modelo = (DefaultTableModel) jTable1.getModel();
        List<Inventario> lista = idao.listarInventario();
        Object[] object = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNombre();
            object[1] = lista.get(i).getCaracteristica();
            object[2] = lista.get(i).getCantidad();
            modelo.addRow(object);
        }
        jTable1.setModel(modelo);

    }

    void removeRows() {
        int rowsToRemove = modelo.getRowCount();
        for (int i = rowsToRemove - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    void buscarMaterial(String valor) {
        try {
            removeRows();
            String[] registros = new String[3];
            modelo = (DefaultTableModel) jTable1.getModel();

            String sql = "select * from Inventario WHERE CONCAT (nombre,'',caracteristica) LIKE '%" + valor + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString(2);
                registros[1] = rs.getString(3);
                registros[2] = rs.getString(4);
                modelo.addRow(registros);
            }

            jTable1.setModel(modelo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTxtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTxtDescontar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setClosable(true);
        setTitle("Inventario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setText("Inventario Actual");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Caracteristica", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel1.setText("Buscar");

        jTxtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtBuscarActionPerformed(evt);
            }
        });
        jTxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtBuscarKeyReleased(evt);
            }
        });

        jLabel2.setText("Utilizar Material en:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Descontar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad:");

        jTxtDescontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDescontarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setText("Eliminar material del inventario:");

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTxtDescontar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jTxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTxtDescontar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTxtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtBuscarActionPerformed
        buscarMaterial("");
    }//GEN-LAST:event_jTxtBuscarActionPerformed

    private void jTxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtBuscarKeyReleased
        buscarMaterial(jTxtBuscar.getText());
    }//GEN-LAST:event_jTxtBuscarKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modelo = (DefaultTableModel) jTable1.getModel();
        int fila=0;
        int cont=0;
        try {
             fila = jTable1.getSelectedRow();
            int cantMaterial = Integer.valueOf(jTable1.getValueAt(fila, 2).toString());
            int cantDescontar = Integer.valueOf(jTxtDescontar.getText());
             cont = cantMaterial - cantDescontar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Seleccione un material");
        }

        if (fila == -1 || cont < 0) {
            JOptionPane.showMessageDialog(this, "Error falta material o no selecciono una fila");
        } else {

            String nom = jTable1.getValueAt(fila, 0).toString();
            String carac = jTable1.getValueAt(fila, 1).toString();
            int idGasto = idao.getIdGasto(nom, carac);
            int idInv = idao.getIdInv(nom, carac);
            String cantDesc = jTxtDescontar.getText();
            int cant = (int) jTable1.getValueAt(fila, 2);
            int cantTotal = cant - Integer.valueOf(cantDesc);
            idao.actualizar(nom, carac, cantTotal, idGasto, idInv);
            idao.descontar(jComboBox1.getSelectedItem().toString(), nom, carac, Integer.valueOf(cantDesc), idInv, idGasto);

            JOptionPane.showMessageDialog(this, "Inventario Actualizado con Exito");
            LimpiarTabla();
            listarProducto();

        }
    }//GEN-LAST:event_jButton2ActionPerformed
    void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    private void jTxtDescontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDescontarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDescontarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        modelo = (DefaultTableModel) jTable1.getModel();
        
        String nom = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);
        String desc = (String) modelo.getValueAt(jTable1.getSelectedRow(), 1);
        
        int respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar el material: " + nom + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            idao.delete(nom, desc);
            removeRows();
            listarProducto();
        }else{
            System.out.println("no acepto");
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        removeRows();
        listarProducto();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtBuscar;
    private javax.swing.JTextField jTxtDescontar;
    // End of variables declaration//GEN-END:variables
}
