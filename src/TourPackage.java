
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class TourPackage extends javax.swing.JFrame {

    /**
     * Creates new form TourPackage
     */
    public TourPackage() {
        initComponents();
        setTable();
    }
    String packageName;
    String location;
    int days;
    int cost;
    int package_Id;
    DefaultTableModel model;

    public void setTable(){
        
        try{
            Connection con = DBConnection.getConnection();
            java.sql.Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tour_package");
            
            while (rs.next()){
            String packageId = rs.getString("package_Id");
            String name = rs.getString("package_Name");
            String location1 = rs.getString ("location");
            String days1 = rs.getString ("N_days");
            String cost1= rs.getString ("cost");
            
            Object[] obj = {packageId, name, location1, days1, cost1};
            model = (DefaultTableModel)packageTbl.getModel();
            model.addRow(obj);
       
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addPackage(){
        boolean isAdded = false;
        package_Id = Integer.parseInt(packageTx.getText());
        packageName = nameTx.getText();
        location = locationTx.getText();
        days = Integer.parseInt(daysTx.getText());
        cost = Integer.parseInt(costTx.getText());
        
        
        
        try{
                Connection con = DBConnection.getConnection();
                String sql = "insert into tour_package values(?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                
                pst.setInt(1, package_Id);
                pst.setString(2, packageName);
                pst.setString(3, location);
                pst.setInt(4, days);
                pst.setInt(5, cost);
                
                
                int rowCount = pst.executeUpdate();
                if (rowCount > 0) {
                    isAdded = true;
                }else {
                    isAdded = false;
                }
        }catch(Exception e){
            e.printStackTrace();
            }
        return isAdded;
    
    }
    
    //method too update  package
    public boolean updatePackage(){
        boolean isUpdated = false;
        package_Id = Integer.parseInt(packageTx.getText());
        packageName = nameTx.getText();
        location = locationTx.getText();
        days = Integer.parseInt(daysTx.getText());
        cost = Integer.parseInt(costTx.getText());
        
        
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update tour_package set package_Name = ?, location = ?, N_days = ?, cost = ? where package_Id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
                
                pst.setString(1, packageName);
                pst.setString(2, location);
                pst.setInt(3, days);
                pst.setInt(4, cost);
                pst.setInt(5, package_Id);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
            }else {
                isUpdated = false;
            }
        
    }catch (Exception e){
        e.printStackTrace();    
    }
    return isUpdated;
    }
    
     //delete method  to remove package
    public boolean removePackage(){
        boolean isDeleted = false;
        package_Id = Integer.parseInt(packageTx.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "delete from tour_package where package_Id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, package_Id);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            }else {
                isDeleted = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isDeleted;   
    }
    
     public void searchMethod(){
        String packagename = searchTx.getText();
        String locationN = searchTx.getText();
        
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM tour_package WHERE package_Name = ? OR location = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, packagename);
            pst.setString(2, locationN);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String drugIds = rs.getString("package_Id");
                String drugNames = rs.getString("package_Name");
                String branchNames = rs.getString("location");
                String categorys = rs.getString("N_days");
                String quantitys = rs.getString("cost");
                
                Object[] obj = {drugIds, drugNames, branchNames, categorys, quantitys};
            model = (DefaultTableModel) packageTbl.getModel();
            model.addRow(obj);           
            }
                     
        }catch (Exception e){
            e.printStackTrace();
    }
        
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) packageTbl.getModel();
        model.setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        packageTbl = new javax.swing.JTable();
        costTx = new rojerusan.RSMetroTextPlaceHolder();
        daysTx = new rojerusan.RSMetroTextPlaceHolder();
        locationTx = new rojerusan.RSMetroTextPlaceHolder();
        packageTx = new rojerusan.RSMetroTextPlaceHolder();
        nameTx = new rojerusan.RSMetroTextPlaceHolder();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchTx = new rojerusan.RSMetroTextPlaceHolder();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 10, 490));

        packageTbl.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        packageTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Package Id", "Name", "Location", "Days", "Cost", "Slots"
            }
        ));
        packageTbl.setGridColor(new java.awt.Color(0, 204, 204));
        packageTbl.setRowHeight(30);
        packageTbl.setShowGrid(true);
        packageTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                packageTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(packageTbl);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 560, 260));

        costTx.setBackground(new java.awt.Color(255, 204, 0));
        costTx.setForeground(new java.awt.Color(0, 0, 0));
        costTx.setBorderColor(new java.awt.Color(0, 204, 204));
        costTx.setBotonColor(new java.awt.Color(0, 204, 204));
        costTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costTx.setPlaceholder("cost amount");
        getContentPane().add(costTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 170, 40));

        daysTx.setBackground(new java.awt.Color(255, 204, 0));
        daysTx.setForeground(new java.awt.Color(0, 0, 0));
        daysTx.setBorderColor(new java.awt.Color(0, 204, 204));
        daysTx.setBotonColor(new java.awt.Color(0, 204, 204));
        daysTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        daysTx.setPlaceholder("days");
        getContentPane().add(daysTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 170, 40));

        locationTx.setBackground(new java.awt.Color(255, 204, 0));
        locationTx.setForeground(new java.awt.Color(0, 0, 0));
        locationTx.setBorderColor(new java.awt.Color(0, 204, 204));
        locationTx.setBotonColor(new java.awt.Color(0, 204, 204));
        locationTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        locationTx.setPlaceholder("location");
        getContentPane().add(locationTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 170, 40));

        packageTx.setBackground(new java.awt.Color(255, 204, 0));
        packageTx.setForeground(new java.awt.Color(0, 0, 0));
        packageTx.setBorderColor(new java.awt.Color(0, 204, 204));
        packageTx.setBotonColor(new java.awt.Color(0, 204, 204));
        packageTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        packageTx.setPlaceholder("package id");
        packageTx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packageTxActionPerformed(evt);
            }
        });
        getContentPane().add(packageTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, 40));

        nameTx.setBackground(new java.awt.Color(255, 204, 0));
        nameTx.setForeground(new java.awt.Color(0, 0, 0));
        nameTx.setBorderColor(new java.awt.Color(0, 204, 204));
        nameTx.setBotonColor(new java.awt.Color(0, 204, 204));
        nameTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameTx.setPlaceholder("package name");
        getContentPane().add(nameTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 170, 40));

        jLabel1.setText("Cost");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 90, -1));

        jLabel2.setText("Package ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 90, -1));

        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 90, -1));

        jLabel4.setText("Location");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, -1));

        jLabel5.setText("Days");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 90, -1));

        searchTx.setBackground(new java.awt.Color(204, 204, 204));
        searchTx.setForeground(new java.awt.Color(0, 0, 0));
        searchTx.setBorderColor(new java.awt.Color(0, 204, 204));
        searchTx.setBotonColor(new java.awt.Color(0, 204, 204));
        searchTx.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchTx.setName(""); // NOI18N
        searchTx.setPlaceholder("                Search name or location");
        searchTx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxActionPerformed(evt);
            }
        });
        getContentPane().add(searchTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 280, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search1.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 40, 40));

        setSize(new java.awt.Dimension(834, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void packageTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packageTblMouseClicked

        int rowNo = packageTbl.getSelectedRow();
        TableModel model = packageTbl.getModel();

        packageTx.setText(model.getValueAt(rowNo, 0).toString());
        nameTx.setText(model.getValueAt(rowNo, 1).toString());
        locationTx.setText(model.getValueAt(rowNo, 2).toString());
        daysTx.setText(model.getValueAt(rowNo, 3).toString());
        costTx.setText(model.getValueAt(rowNo, 4).toString());
        
    }//GEN-LAST:event_packageTblMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (updatePackage()== true){
        JOptionPane.showMessageDialog(this, "Package update Successful");
        clearTable();
        setTable();
        }
        else{
             JOptionPane.showMessageDialog(this, "Update failure!");
                        }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (removePackage()== true){
        JOptionPane.showMessageDialog(this, "One package removed");
        clearTable();
        setTable();
        }
        else{
             JOptionPane.showMessageDialog(this, "Deletion failure!");
                        }
               
    }//GEN-LAST:event_jButton1ActionPerformed

    private void packageTxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packageTxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_packageTxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (addPackage()== true){
        JOptionPane.showMessageDialog(this, "New package added");
        clearTable();
        setTable();
        }
        else{
             JOptionPane.showMessageDialog(this, "addition failure!");
                        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchTxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxActionPerformed
        clearTable();
        searchMethod();
    }//GEN-LAST:event_searchTxActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        clearTable();
        searchMethod();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(TourPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TourPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TourPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TourPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TourPackage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMetroTextPlaceHolder costTx;
    private rojerusan.RSMetroTextPlaceHolder daysTx;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMetroTextPlaceHolder locationTx;
    private rojerusan.RSMetroTextPlaceHolder nameTx;
    private javax.swing.JTable packageTbl;
    private rojerusan.RSMetroTextPlaceHolder packageTx;
    private rojerusan.RSMetroTextPlaceHolder searchTx;
    // End of variables declaration//GEN-END:variables
}