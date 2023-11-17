/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Hi There
 */
public class ChuyenSever extends javax.swing.JFrame {

    /**
     * Creates new form ChuyenSever
     */
    public ChuyenSever() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblQuayLai = new javax.swing.JLabel();
        txtSever = new javax.swing.JTextField();
        btnChuyenDoi = new controller.BlackButton();
        jLabel7 = new javax.swing.JLabel();
        txtDatabase = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 220, 197));
        jPanel1.setMaximumSize(new java.awt.Dimension(1460, 740));
        jPanel1.setMinimumSize(new java.awt.Dimension(1460, 740));
        jPanel1.setPreferredSize(new java.awt.Dimension(1460, 740));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hinh (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 530, 470));

        jPanel2.setBackground(new java.awt.Color(254, 230, 214));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setText("Chuyển Sever");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Sever:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 101, -1));

        lblQuayLai.setText("Quay lại đăng nhập");
        jPanel2.add(lblQuayLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 110, -1));
        jPanel2.add(txtSever, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 260, 40));

        btnChuyenDoi.setBackground(new java.awt.Color(242, 80, 25));
        btnChuyenDoi.setForeground(new java.awt.Color(255, 255, 255));
        btnChuyenDoi.setText("Chuyển đổi");
        btnChuyenDoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChuyenDoi.setPreferredSize(new java.awt.Dimension(200, 50));
        btnChuyenDoi.setRadius(50);
        btnChuyenDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDoiActionPerformed(evt);
            }
        });
        jPanel2.add(btnChuyenDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Database:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 80, -1));
        jPanel2.add(txtDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 260, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 210, 390, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChuyenDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChuyenDoiActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ChuyenSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChuyenSever().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private controller.BlackButton btnChuyenDoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblQuayLai;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JTextField txtSever;
    // End of variables declaration//GEN-END:variables
}