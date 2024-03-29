import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.*;
        

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UpdateAccount.java
 *
 * Created on Nov 27, 2011, 10:16:46 PM
 */
/**
 *
 * @author anearcan
 */
public class UpdateAccount extends javax.swing.JFrame {
    private MemberAccount member;
    private Employee employee;
    private ResultSet rs;
    
    /** Creates new form UpdateAccount */
    public UpdateAccount() throws ClassNotFoundException, SQLException {
        initComponents();
        Utility.connect();  
        
        /*
        String s = (String)JOptionPane.showInputDialog(this,"Scan Membership Card\n","Confirm Membership",
                JOptionPane.PLAIN_MESSAGE, null, null,null);
        memberID.setText(s);
         
        rs = new Utility().stmt.executeQuery("SELECT * FROM members WHERE MemberID = " + s);
         
         while(rs.next()){
             memberFirstName.setText(rs.getString("FirstName"));
             memberLastName.setText(rs.getString("LastName"));
             newAddress.setText(rs.getString("Address"));
             email.setText(rs.getString("email"));
             phoneNumber.setText(Integer.toString(rs.getInt("PhoneNumber")));
             
         }
         member = new MemberAccount(Integer.parseInt(s), memberFirstName.getText(), memberLastName.getText(),
                 email.getText(), Integer.parseInt(phoneNumber.getText()));*/
    }

    UpdateAccount(Employee employee) throws ClassNotFoundException, SQLException {
        initComponents();
        this.employee = employee;
        String s = (String)JOptionPane.showInputDialog(this,"Scan Membership Card\n","Confirm Membership",
                JOptionPane.PLAIN_MESSAGE, null, null,null);
        memberID.setText(s);
        
        new Utility().connect();  
         
        rs = new Utility().stmt.executeQuery("SELECT * FROM members WHERE MemberID = " + s);
         
         while(rs.next()){
             memberFirstName.setText(rs.getString("FirstName"));
             memberLastName.setText(rs.getString("LastName"));
             newAddress.setText(rs.getString("Address"));
             email.setText(rs.getString("email"));
             phoneNumber.setText(Integer.toString(rs.getInt("PhoneNumber")));             
         }
         member = new MemberAccount(Integer.parseInt(s), memberFirstName.getText(), memberLastName.getText(),
                 email.getText(), Integer.parseInt(phoneNumber.getText()));
         
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        streetAddress = new javax.swing.JLabel();
        memberID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        memberFirstName = new javax.swing.JTextField();
        memberLastName = new javax.swing.JTextField();
        newAddress = new javax.swing.JTextField();
        memberCity = new javax.swing.JTextField();
        memberProvince = new javax.swing.JComboBox();
        email = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("MemberID");

        jLabel9.setText("Phone number");

        jLabel6.setText("Province");

        jLabel2.setText("Last Name:");

        jLabel3.setText("Street Address:");

        jLabel4.setText("City:");

        jLabel1.setText("First Name:");

        jLabel5.setText("E-mail:");

        memberProvince.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ON", "QC", "MB", "NS", "NB", "PE", "BC", "SK. NL", "AB" }));

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memberProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(memberCity, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(memberID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newAddress))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memberFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memberLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(memberID, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(memberFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(memberLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(newAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(memberCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(memberProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
// TODO add your handling code here:
  
     member.setFirstName(memberFirstName.getText());
     member.setLastName(memberLastName.getText());
     member.setAddress(newAddress.getText());
     member.setCity(memberCity.getText());
     member.setProvince((String)memberProvince.getSelectedItem());
     member.setEmail(email.getText());
     member.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
        try {
            //insert code to update database.
            while(rs.next()){
              rs.updateString("FirstName", memberFirstName.getText());
              rs.updateString("LastName", memberLastName.getText());
              rs.updateString("email", email.getText());
              rs.updateString("Address",newAddress.getText());
              rs.updateInt("PhoneNumber",Integer.parseInt(phoneNumber.getText()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Utility.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Utility.returnToMainMenu(employee);
            this.setVisible(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new UpdateAccount().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField memberCity;
    private javax.swing.JTextField memberFirstName;
    private javax.swing.JLabel memberID;
    private javax.swing.JTextField memberLastName;
    private javax.swing.JComboBox memberProvince;
    private javax.swing.JTextField newAddress;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JLabel streetAddress;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
