

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class BookingCalendar extends javax.swing.JFrame {

    /**
     * Creates new form BookingCalendar
     */
    public BookingCalendar() {
        initComponents();
    }
    
     private void saveNotes() {
        String notes = jTextArea1.getText();
        String title = titleTx.getText();
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("INSERT INTO notes (title, text, date) VALUES (?, ?, CURRENT_TIMESTAMP)");

        pst.setString(1, title);
        pst.setString(2,notes);
        int rowCount = pst.executeUpdate();
        if (rowCount > 0) {
            // Insertion successful
            JOptionPane.showMessageDialog(this, "Saved successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Failed!");
        }
    } catch (Exception e) {
        e.printStackTrace();
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

        bookCal = new com.toedter.calendar.JCalendar();
        jLabel7 = new javax.swing.JLabel();
        notesLb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        titleTx = new rojerusan.RSMetroTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(bookCal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 400, 220));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 20, 20));

        notesLb.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        notesLb.setText("Make Notes");
        getContentPane().add(notesLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 120, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMargin(new java.awt.Insets(0, 0, 0, 9));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 390, 150));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, 30));

        titleTx.setBackground(new java.awt.Color(242, 242, 242));
        titleTx.setForeground(new java.awt.Color(0, 0, 0));
        titleTx.setBorderColor(new java.awt.Color(0, 204, 204));
        titleTx.setBotonColor(new java.awt.Color(0, 204, 204));
        titleTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titleTx.setPlaceholder("title");
        titleTx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTxActionPerformed(evt);
            }
        });
        getContentPane().add(titleTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 140, 40));

        setSize(new java.awt.Dimension(400, 474));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        saveNotes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void titleTxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleTxActionPerformed

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
            java.util.logging.Logger.getLogger(BookingCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingCalendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar bookCal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel notesLb;
    private rojerusan.RSMetroTextPlaceHolder titleTx;
    // End of variables declaration//GEN-END:variables
}
