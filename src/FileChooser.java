import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.nio.file.Files;
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class FileChooser extends javax.swing.JFrame {

    private final String phoneNumber; // Store the phone number

     public FileChooser(String phoneNumber) {
        // Initialize phoneNumber field, use empty string if null
        this.phoneNumber = (phoneNumber != null) ? phoneNumber : "";
        initComponents1(); // Initialize components
    }
    /**
     * Creates new form FileChooser
     */
     // Default constructor
    public FileChooser() {
        this.phoneNumber = ""; // Initialize phoneNumber to empty string
        initComponents1(); // Initialize components
    }
    
    
    private void initComponents1() {
    jFileChooser1 = new javax.swing.JFileChooser();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setUndecorated(true);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    getContentPane().add(jFileChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 580, 360));

    setSize(new java.awt.Dimension(590, 364));
    setLocationRelativeTo(null);

    // Add action listener to the file chooser's open button
    jFileChooser1.addActionListener(e -> {
        if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            // User selected a file
            File file = jFileChooser1.getSelectedFile();
            // Insert the image into the database
            insertImageIntoDatabase(file);
        } else if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION)) {
            this.dispose();
        }
    });

    // Add file filter for image files
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
    jFileChooser1.setFileFilter(filter);
}


    private void insertImageIntoDatabase(File file) {
        try {
            // Read the image file as bytes
            byte[] imageBytes = Files.readAllBytes(file.toPath());

            // Get the phone number from the ClientProfile
            ClientProfile clientProfile = new ClientProfile();
            String phoneNumber = this.phoneNumber.trim(); // Trim any leading or trailing whitespace

            // Check if the phone number is not empty before parsing
            if (!phoneNumber.isEmpty()) {
                try {
                    int phoneNumber1 = Integer.parseInt(phoneNumber);

                    // Insert the image bytes into the database
                    Connection con = DBConnection.getConnection();
                    String sql = "UPDATE booking SET profile_image = ? WHERE phone_number = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setBytes(1, imageBytes);
                    pst.setInt(2, phoneNumber1);
                    int rowCount = pst.executeUpdate();

                    if (rowCount > 0) {
                        JOptionPane.showMessageDialog(this, "Image inserted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to insert image.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid phone number format.");
                }
            } else {
                // Handle the case where the phone number is empty
                JOptionPane.showMessageDialog(this, "Phone number is empty.");
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

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jFileChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 580, 360));

        setSize(new java.awt.Dimension(590, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileChooser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
