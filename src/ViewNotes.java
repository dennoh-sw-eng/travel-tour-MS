import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class ViewNotes extends javax.swing.JFrame {

    /**
     * Creates new form ViewNotes
     */
    public ViewNotes() {
        initComponents();
        displayNotes();
       
        
    }

    public void displayNotes(){
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT title, text, date FROM notes";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        // Clear existing text in the JTextArea
        jTextArea1.setText("");

        // Append each note with its creation date to the JTextArea
        while (rs.next()) {
            String title = rs.getString("title");
            String text = rs.getString("text");
            String date = rs.getString("date");

            // Append the note title, text, and creation date to the JTextArea
            jTextArea1.append("Title: " + title + "\n");
            jTextArea1.append("Text: " + text + "\n\n");
            jTextArea1.append("Created At: " + date + "\n\n");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void deleteNotes() {
        String title = deleteTx.getText();
        
    try {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM notes WHERE title = ?"; 
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, title);
        
        int rowCount = pst.executeUpdate();
        
        if (rowCount > 0) {
            JOptionPane.showMessageDialog(this, "Deleted Succassfully");
        } else {
            JOptionPane.showMessageDialog(this, "failed!");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        deleteTx = new rojerusan.RSMetroTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMargin(new java.awt.Insets(0, 0, 0, 9));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 440, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        jLabel1.setText("Previous Notes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 170, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 20, 20));

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        deleteTx.setBackground(new java.awt.Color(242, 242, 242));
        deleteTx.setForeground(new java.awt.Color(0, 0, 0));
        deleteTx.setBorderColor(new java.awt.Color(0, 204, 204));
        deleteTx.setBotonColor(new java.awt.Color(0, 204, 204));
        deleteTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteTx.setPlaceholder("enter title of note to delete");
        deleteTx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTxActionPerformed(evt);
            }
        });
        getContentPane().add(deleteTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 190, 40));

        setSize(new java.awt.Dimension(448, 303));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        deleteNotes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deleteTxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTxActionPerformed
        deleteNotes();
    }//GEN-LAST:event_deleteTxActionPerformed

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
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMetroTextPlaceHolder deleteTx;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
