
import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kouts
 */
public class Admin_SeePayrolls extends javax.swing.JFrame {

    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db", "root", "pass123");
        } catch (Exception ex) {
            System.out.println("here1");
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    /**
     * Creates new form Admin_SeePayrolls
     */
    public Admin_SeePayrolls() {
        initComponents();
        FillCombo();
    }

    private void FillCombo(){
        PreparedStatement ps;
        PreparedStatement ps1;
        ResultSet rs;
        ResultSet rs1;
        String newspaper_name = "";
        
        String query = "select newsp_name from works inner join administrative on administrative.email = works.employee_name where employee_name = ?";
        String query1 = "select employee_name from works where newsp_name = ? ";
       try{
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db?serverTimezone=UTC","root", "pass123"); 
            
            ps = Admin_SeePayrolls.getConnection().prepareStatement(query);
            
            ps.setString(1, LoginFrame.email);
            
            rs = ps.executeQuery();
                      
            if (rs.next())
            {
                newspaper_name = rs.getString("newsp_name");
                ps1 = Admin_SeePayrolls.getConnection().prepareStatement(query1);
                ps1.setString(1, newspaper_name);
                rs1 = ps1.executeQuery();

                while(rs1.next()){
                   String name = rs1.getString("employee_name");
                   jComboBox1.addItem(name);
                }
            }
       }catch(Exception e){JOptionPane.showMessageDialog (null, e);} 
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Starting Month:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("End Month:");

        jButton1.setText("All Employees");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel3.setText("Employee email:");

        jButton2.setText("Specific Employee");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jYearChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMonthChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jYearChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        int d1m;
        int d2m;
        int d1y;
        int d2y;
      
        try {
                      
            d1m = (jMonthChooser1.getMonth()+1);
            d2m = (jMonthChooser2.getMonth()+1);
            
            d1y = (jYearChooser1.getYear());
            d2y = (jYearChooser2.getYear());
            
            //long diff = 12*(d2y.getYear() - d1y.getYear()) + (d1m.getMonth()-d2m.getMonth());
            
            int diff = 12*(d2y-d1y) + (d2m-d1m); // difference in months
            
            // System.out.println(d1y);
            //  System.out.println(diff);
            
            if (diff>0){
                PreparedStatement ps1;
                    ResultSet rs1;
                    // System.out.println("helLo");
                    String query1 = "select sum(salary) from employee;";
                    Float result;
                    
                    try {
                        ps1 = Admin_SeePayrolls.getConnection().prepareStatement(query1);
                        rs1 = ps1.executeQuery();
                        
                        
                        if(rs1.next())
                        {
                            result = rs1.getFloat(1);                            
                            result = result*diff;
                            System.out.println(result);
                            
                            JOptionPane.showMessageDialog(null, "The total salary is "+result);
                        }else{JOptionPane.showMessageDialog(null, "ERROR");}
                    }
                    catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("here1");
                        }
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Give a right dateframe");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int d1m;
        int d2m;
        int d1y;
        int d2y;
      
        String email = (String)jComboBox1.getSelectedItem();
        
        try {
                      
            d1m = (jMonthChooser1.getMonth()+1);
            d2m = (jMonthChooser2.getMonth()+1);
            
            d1y = (jYearChooser1.getYear());
            d2y = (jYearChooser2.getYear());
            
            //long diff = 12*(d2y.getYear() - d1y.getYear()) + (d1m.getMonth()-d2m.getMonth());
            
            int diff = 12*(d2y-d1y) + (d2m-d1m); // difference in months
            
            // System.out.println(d1y);
            //  System.out.println(diff);
            
            if (diff>0){
                PreparedStatement ps1;
                ResultSet rs1;
                PreparedStatement ps2;
                ResultSet rs2;
                   
                    String query1 = "select sum(salary) from employee;";
                    String query2 = "select sum(salary) from employee where email=?";
                    Float result;
                    
                    try {
                        ps1 = Admin_SeePayrolls.getConnection().prepareStatement(query1);
                        ps2 = Admin_SeePayrolls.getConnection().prepareStatement(query2);
                        
                        ps2.setString(1, email);
                        
                        rs1 = ps1.executeQuery();
                        rs2 = ps2.executeQuery();
                        
                        if(rs1.next() && rs2.next())
                        {
                            result = rs2.getFloat(1);                            
                            result = result*diff;
                            System.out.println(result);
                            
                            JOptionPane.showMessageDialog(null, "The total salary is "+result);
                        }else{JOptionPane.showMessageDialog(null, "ERROR");}
                    }
                    catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                            System.out.println("here1");
                        }
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Give a right dateframe");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(Admin_SeePayrolls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_SeePayrolls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_SeePayrolls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_SeePayrolls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_SeePayrolls().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    // End of variables declaration//GEN-END:variables
}
