/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tema9;

/**
 *
 * @author alumno
 */
public class EJEMPLO01 extends javax.swing.JPanel {

    /**
     * Creates new form EJEMPLO01
     */
    public EJEMPLO01() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MUSICA = new javax.swing.JButton();
        DEPORTES = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        AFICIONES = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        RESULTADO = new javax.swing.JTextPane();

        MUSICA.setBackground(new java.awt.Color(0, 102, 102));
        MUSICA.setText("MUSICA");
        MUSICA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MUSICAMouseClicked(evt);
            }
        });

        DEPORTES.setBackground(new java.awt.Color(0, 102, 102));
        DEPORTES.setText("DEPORTES");
        DEPORTES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DEPORTESMousePressed(evt);
            }
        });

        RESET.setBackground(new java.awt.Color(0, 102, 102));
        RESET.setText("RESET");

        AFICIONES.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AFICIONES.setText("AFICIONES");
        AFICIONES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AFICIONESActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(RESULTADO);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(MUSICA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DEPORTES)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AFICIONES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RESET)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MUSICA)
                    .addComponent(DEPORTES))
                .addGap(18, 18, 18)
                .addComponent(AFICIONES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(RESET)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AFICIONESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AFICIONESActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AFICIONESActionPerformed

    private void MUSICAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUSICAMouseClicked
        // TODO add your handling code here:
        this.RESULTADO.setText("MUSICA");
    }//GEN-LAST:event_MUSICAMouseClicked

    private void DEPORTESMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DEPORTESMousePressed
        // TODO add your handling code here:
        this.RESULTADO.setText("DEPORTES");
    }//GEN-LAST:event_DEPORTESMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AFICIONES;
    private javax.swing.JButton DEPORTES;
    private javax.swing.JButton MUSICA;
    private javax.swing.JButton RESET;
    private javax.swing.JTextPane RESULTADO;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
