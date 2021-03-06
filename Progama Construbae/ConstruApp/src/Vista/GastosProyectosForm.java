/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GastoDAO;
import Controlador.GastosProyectosDAO;
import Controlador.ProyectoDAO;
import Modelo.Gastoproyecto;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Seba-PC
 */
public class GastosProyectosForm extends javax.swing.JInternalFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    ProyectoDAO pdao = new ProyectoDAO();
    GastosProyectosDAO gdao = new GastosProyectosDAO();
    GastoDAO gastodao = new GastoDAO();

    public GastosProyectosForm() {
        initComponents();
        pdao.listarProyecto(jComboBox1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtIva = new javax.swing.JTextField();
        jTxtNeto = new javax.swing.JTextField();
        jTxtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Gastos de Proyecto");

        jLabel1.setText("Proyectos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Caracteristica", "Cantidad", "Precio Unitario", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Total Neto");

        jLabel4.setText("Sub Total");

        jTxtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIvaActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Iva");

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setText("Eliminar Gasto seleccionado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTxtIva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(jTxtNeto, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarTabla();
        String nomPro = jComboBox1.getSelectedItem().toString();
        listarGastosPorProyecto(nomPro);
        calcularTotales();
    }//GEN-LAST:event_jButton1ActionPerformed

    void calcularTotales(){
        modelo = (DefaultTableModel) jTable1.getModel();
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        int cont = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int value = (int) modelo.getValueAt(i, 4);
            cont = cont + value;
        }
        int neto = (int) (cont/1.19);
        int iva = cont - neto;
        jTxtIva.setText("$ "+formatea.format(iva));
        jTxtNeto.setText("$ "+formatea.format(neto));
        jTxtTotal.setText("$ "+formatea.format(cont));
    }
    
    
    private void jTxtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIvaActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        modelo = (DefaultTableModel) jTable1.getModel();
        
        String nomPro = (String) jComboBox1.getSelectedItem();
        String nom = (String) modelo.getValueAt(jTable1.getSelectedRow(), 0);
        String desc = (String) modelo.getValueAt(jTable1.getSelectedRow(), 1);
        int cant = (int) modelo.getValueAt(jTable1.getSelectedRow(), 2);
        
        int respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar el material: " + nom + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            gdao.delete(nomPro, nom, desc, cant);
            removeRows();
            jButton1ActionPerformed(evt);
        }else{
            System.out.println("no acepto");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    void removeRows() {
        int rowsToRemove = modelo.getRowCount();
        for (int i = rowsToRemove - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    void listarGastosPorProyecto(String nomPro) {
        modelo = (DefaultTableModel) jTable1.getModel();
        List<Gastoproyecto> lista = gdao.listarGastosPorProyecto(nomPro);
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNombre();
            object[1] = lista.get(i).getCaracteristica();
            object[2] = lista.get(i).getCantidad();
            //int precio = gastodao.getPrecio(lista.get(i).getNombre(), lista.get(i).getCaracteristica());
            int precio = lista.get(i).getGastoproyectoPK().getInventarioGastoidGasto();
            object[3] = gastodao.getPrecio(precio);
            int Total = lista.get(i).getCantidad()*gastodao.getPrecio(precio);
            object[4] = Total;
            modelo.addRow(object);
        }
        jTable1.setModel(modelo);

    }
    void limpiarTabla() {
        int rowsToRemove = modelo.getRowCount();
        for (int i = rowsToRemove - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtIva;
    private javax.swing.JTextField jTxtNeto;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
