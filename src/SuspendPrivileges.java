
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SuspendPrivileges.java
 *
 * Created on Nov 27, 2011, 10:28:06 PM
 */
/**
 *
 * @author anearcan
 */
public class SuspendPrivileges extends javax.swing.JFrame {
   public MembershipControl control;
   private MemberAccount member;
   private Employee employee; 
   /** Creates new form SuspendPrivileges */
    public SuspendPrivileges() {
        initComponents();
    }

    public SuspendPrivileges(Employee employee) throws ClassNotFoundException, SQLException {
        initComponents();
        this.employee = employee;
        String s = (String)JOptionPane.showInputDialog(this,"Scan Membership Card\n","Confirm Membership",
                JOptionPane.PLAIN_MESSAGE, null, null,null);
        
        new Utility().connect();  
         
        ResultSet rs = new Utility().stmt.executeQuery("SELECT * FROM members WHERE MemberID = " + s);
         
         while(rs.next()){;             
            member = new MemberAccount(Integer.parseInt(s),rs.getString("FirstName"), rs.getString("LastName"),
                 rs.getString("email"), rs.getLong("PhoneNumber"));
             member.setAddress(rs.getString("Address"));

         }

    }
    
    public SuspendPrivileges(Employee employee, MemberAccount member) {
        initComponents();
        this.employee = employee;
        this.member = member;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        suspensionReason = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        suspendButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Suspending Privileges");

        suspensionReason.setColumns(20);
        suspensionReason.setRows(5);
        jScrollPane1.setViewportView(suspensionReason);

        jLabel1.setText("Reason:");

        suspendButton.setText("Complete Suspension");
        suspendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suspendButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(suspendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void suspendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspendButtonActionPerformed
        try {
            // TODO add your handling code here:
                control.suspend(member,suspensionReason.getText());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SuspendPrivileges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SuspendPrivileges.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_suspendButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SuspendPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuspendPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuspendPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuspendPrivileges.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {new SuspendPrivileges().setVisible(true);}
        });
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton suspendButton;
    private javax.swing.JTextArea suspensionReason;
    // End of variables declaration//GEN-END:variables
}
