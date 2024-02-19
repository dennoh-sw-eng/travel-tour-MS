
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class ClientProfile extends javax.swing.JFrame {

    class ImageIconRenderer extends DefaultTableCellRenderer {
    private int width;
    private int height;
    private ImageIcon defaultIcon;

    public ImageIconRenderer(int width, int height, ImageIcon defaultIcon) {
        this.width = width;
        this.height = height;
        this.defaultIcon = defaultIcon;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof ImageIcon) {
            ImageIcon originalIcon = (ImageIcon) value;
            Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            label.setIcon(scaledIcon);
            label.setText(""); // Clear text
        } else if (value == null && defaultIcon != null) {
            Image scaledImage = defaultIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            label.setIcon(scaledIcon);
            label.setText(""); // Clear text
        }
        return label;
    }
}




    /**
     * Creates new form ClientProfile
     */
    public ClientProfile() {
        initComponents();
        populateTable();
       
        
        
        // Adjust lenght and width of column and row
        clientTbl.setRowHeight(80);
        clientTbl.getColumnModel().getColumn(1).setPreferredWidth(40);
        
        int profileColumnIndex = 1; // profile column is at index 1
        int desiredWidth = 50; //  width for image
        int desiredHeight = 50; // height for image
        ImageIcon defaultIcon = new ImageIcon("src/icons/default.png");
        clientTbl.getColumnModel().getColumn(profileColumnIndex).setCellRenderer(new ImageIconRenderer(desiredWidth, desiredHeight, defaultIcon));
        
         }
    public String getPhoneNumber() {
    String phoneNumber = jTextField1.getText().trim(); // Trim any leading or trailing whitespace
    return phoneNumber;
}

public boolean PhoneFound() {
    boolean isAvailable = false;
    String phoneNumberStr = getPhoneNumber();
    
    try {
        int phoneNumber = Integer.parseInt(phoneNumberStr);
        Connection con = DBConnection.getConnection();
        String sql = "SELECT COUNT(*) AS count FROM booking WHERE phone_number = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, phoneNumber);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            if (count > 0) {
                isAvailable = true;
            }
        }
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return isAvailable;
}

public void populateTable() {
    DefaultTableModel model = (DefaultTableModel) clientTbl.getModel();
    model.setRowCount(0); // Clear existing rows

    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT client_id, profile_image, phone_number, number_of_slots FROM booking";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("client_id");
            byte[] imageData = rs.getBytes("profile_image");
            ImageIcon imageIcon = null; // Default to null initially

            // Check if imageData is not null
            if (imageData != null && imageData.length > 0) {
                imageIcon = new ImageIcon(imageData); // Convert bytes to ImageIcon
            } else {
               imageIcon = new ImageIcon("src/icons/default.png");
            }
            // Other columns
            String phoneNumber = rs.getString("phone_number");
            int totalBookings = rs.getInt("number_of_slots");

            // Add a row to the table
            model.addRow(new Object[]{id, imageIcon, phoneNumber, totalBookings});
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
        clientTbl = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new rojerusan.RSMetroTextPlaceHolder();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clientTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "profile", "Phone Number", "Total Bookings"
            }
        ));
        jScrollPane1.setViewportView(clientTbl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 670, 340));

        jButton1.setText("Choose file");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 110, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel1.setText("Client Profile Data");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 20));

        jTextField1.setBackground(new java.awt.Color(255, 204, 0));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorderColor(new java.awt.Color(0, 204, 204));
        jTextField1.setBotonColor(new java.awt.Color(0, 204, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setPlaceholder("Enter phone number");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 150, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel2.setText("Add Client Profile");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel13.setText("X");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 20, 20));

        setSize(new java.awt.Dimension(683, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField1.getText().equals("") && PhoneFound()) {
        FileChooser file = new FileChooser(jTextField1.getText()); // Pass the phone number
        file.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "phone Number not found");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(ClientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable clientTbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMetroTextPlaceHolder jTextField1;
    // End of variables declaration//GEN-END:variables
}
