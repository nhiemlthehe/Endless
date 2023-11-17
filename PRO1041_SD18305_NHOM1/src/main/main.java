package main;

import controller.CustomLabel;
import controller.MenuPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import view.DoiTraHang;
import view.GiaoDich;
import view.HoaDon;
import view.KhachHang;
import view.KhuyenMai;
import view.NhaCungCap;
import view.NhanVien;
import view.NhapHang;
import view.SanPham;
import view.TaiKhoan;
import view.ThongKe;
import view.ThuocTinh;
import view.TrangChu;

/**
 *
 * @author Ly Tinh Nhiem
 */
public class main extends javax.swing.JFrame {

    int location = 0;

    public main() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setTabSelect(location);
        addMenuPanel();
        
    }

    public void addMenuPanel() {
        pnlMenu.setLayout(new AbsoluteLayout());
        int k = 0;
        for (int i = 0; i < 13; i++) {
            MenuPanel menutab = new MenuPanel(i, location);
            int finalI = i;
            menutab.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    location = finalI;
                    setTabSelect(finalI);
                }
            });

            pnlMenu.add(menutab, new AbsoluteConstraints(0, k));
            k += 55;
        }
    }

    public void changeTab(JPanel pnl) {
        GiaoDien.removeAll();
        GiaoDien.setLayout(new AbsoluteLayout());
        AbsoluteConstraints constraints = new AbsoluteConstraints(0, 0);
        GiaoDien.add(pnl, constraints);
    }

    public void setTabSelect(int location) {
        switch (location) {
            case 0:
                changeTab(new TrangChu());
                break;
            case 1:
                changeTab(new GiaoDich());
                break;
            case 2:
                changeTab(new HoaDon());
                break;
            case 3:
                changeTab(new DoiTraHang());
                break;
            case 4:
                changeTab(new NhanVien());
                break;
            case 5:
                changeTab(new NhaCungCap());
                break;
            case 6:
                changeTab(new KhachHang());
                break;
            case 7:
                changeTab(new SanPham());
                break;
            case 8:
                changeTab(new ThuocTinh());
                break;
            case 9:
                changeTab(new NhapHang());
                break;
            case 10:
                changeTab(new KhuyenMai());
                break;
            case 11:
                changeTab(new ThongKe());
                break;
            case 12:
                changeTab(new TaiKhoan());
                break;
            case 13:
                changeTab(new TaiKhoan());
                break;
            default:
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        GiaoDien = new javax.swing.JPanel();
        logo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAnhDaiDien = new controller.WhiteLabel();
        myButton1 = new controller.BlackButton();
        pnlMenu = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(1550, 830));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GiaoDien.setMaximumSize(new java.awt.Dimension(1280, 730));
        GiaoDien.setMinimumSize(new java.awt.Dimension(1280, 730));
        GiaoDien.setPreferredSize(new java.awt.Dimension(1280, 730));

        javax.swing.GroupLayout GiaoDienLayout = new javax.swing.GroupLayout(GiaoDien);
        GiaoDien.setLayout(GiaoDienLayout);
        GiaoDienLayout.setHorizontalGroup(
            GiaoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        GiaoDienLayout.setVerticalGroup(
            GiaoDienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        getContentPane().add(GiaoDien, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 1300, 730));

        logo.setBackground(new java.awt.Color(0, 0, 0));
        logo.setMaximumSize(new java.awt.Dimension(250, 810));
        logo.setMinimumSize(new java.awt.Dimension(250, 810));
        logo.setPreferredSize(new java.awt.Dimension(250, 810));
        logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logocokhung.png"))); // NOI18N
        jLabel4.setText("jLabel1");
        logo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 80));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Bức phá giới hạn");
        logo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ENDLESS");
        logo.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 140, -1));

        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setMaximumSize(new java.awt.Dimension(1530, 80));
        jPanel3.setMinimumSize(new java.awt.Dimension(1530, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(1530, 80));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 20, 130, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Role : ");
        jLabel3.setToolTipText("");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 40, 130, -1));

        lblAnhDaiDien.setText(" ");
        lblAnhDaiDien.setRadius(40);
        jPanel3.add(lblAnhDaiDien, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, 40, 40));

        myButton1.setBackground(new java.awt.Color(23, 23, 23));
        myButton1.setForeground(new java.awt.Color(255, 255, 255));
        myButton1.setText(" ");
        myButton1.setPreferredSize(new java.awt.Dimension(100, 60));
        myButton1.setRadius(60);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 220, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 80));

        pnlMenu.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 250, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        location = 12;
        setTabSelect(location);
    }//GEN-LAST:event_myButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GiaoDien;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private controller.WhiteLabel lblAnhDaiDien;
    private javax.swing.JPanel logo;
    private controller.BlackButton myButton1;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
