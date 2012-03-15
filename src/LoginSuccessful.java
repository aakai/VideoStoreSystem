import javax.swing.*;
import java.sql.*;      
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginSuccessful.java
 *
 * Created on Nov 25, 2011, 9:30:29 AM
 */
/**
 *
 * @author anearcan
 */
public class LoginSuccessful extends javax.swing.JFrame {
    private Employee employee;
    private MemberAccount member;
    private final SearchResults search;
    private final CreateAccount createAcc;
    private final UpdateAccount updateAcc;
    private final MakeReservation reserve;
    private final PaymentPage payment;
    private final PurchasePayment purchasePay;
    private final RentItemMemberInfo rent;
    private final ReturnItem returnIt;
    private final CancelReservation cancelReserve;
    String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
     Connection con;
     Statement stmt;
     PreparedStatement pStmt;
     
    public void connectToDatabase() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
        Statement stmt = con.createStatement();
    }
    /** Creates new form LoginSuccessful */
    public LoginSuccessful() {
        initComponents();
        cancelReserve = new CancelReservation(this.employee, null);
        search = new SearchResults(this.employee);
        createAcc = new CreateAccount(this.employee);
        updateAcc = new UpdateAccount(this.employee);
        reserve = new MakeReservation(this.employee);
        payment = new PaymentPage(this.employee);
        purchasePay= new PurchasePayment(this.employee);
        rent = new RentItemMemberInfo(this.employee, null);
        returnIt = new ReturnItem(this.employee);

    }

    LoginSuccessful(Employee employee) {
        initComponents();
        this.employee = employee;
        cancelReserve = new CancelReservation(this.employee,null);
        search = new SearchResults(this.employee);
        createAcc = new CreateAccount(this.employee);
        updateAcc = new UpdateAccount(this.employee);
        reserve = new MakeReservation(this.employee);
        payment = new PaymentPage(this.employee);
        purchasePay= new PurchasePayment(this.employee);
        rent = new RentItemMemberInfo(this.employee, null);
        returnIt = new ReturnItem(this.employee);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rentItem = new javax.swing.JButton();
        purchase = new javax.swing.JButton();
        createAccount = new javax.swing.JButton();
        makeReservation = new javax.swing.JButton();
        cancelReservation = new javax.swing.JButton();
        editAccountInfo = new javax.swing.JButton();
        returnItem = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Successful Login");

        rentItem.setText("Rent Item");
        rentItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentItemActionPerformed(evt);
            }
        });

        purchase.setText("Purchase Item");
        purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseActionPerformed(evt);
            }
        });

        createAccount.setText("Create Account");
        createAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountActionPerformed(evt);
            }
        });

        makeReservation.setText("Make Reservation");
        makeReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeReservationActionPerformed(evt);
            }
        });

        cancelReservation.setText("Cancel Reservation");
        cancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationActionPerformed(evt);
            }
        });

        editAccountInfo.setText("Update Account");
        editAccountInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountInfoActionPerformed(evt);
            }
        });

        returnItem.setText("Return Item");
        returnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnItemActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createAccount)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(editAccountInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(makeReservation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rentItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(returnItem)
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cancelReservation)
                            .addComponent(purchase))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentItem)
                    .addComponent(purchase)
                    .addComponent(returnItem))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelReservation)
                    .addComponent(makeReservation))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAccount)
                    .addComponent(editAccountInfo)
                    .addComponent(searchButton))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
    purchasePay.setVisible(true);

}//GEN-LAST:event_purchaseActionPerformed

private void editAccountInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountInfoActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
    updateAcc.setVisible(true);

}//GEN-LAST:event_editAccountInfoActionPerformed

private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
    search.setVisible(true);
        
}//GEN-LAST:event_searchButtonActionPerformed

private void rentItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentItemActionPerformed
// TODO add your handling code here:
    String s = (String)JOptionPane.showInputDialog(this,"Scan Membership Card\n","Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE, null, null,null);

    //If a string was returned, say so.
    if ((s != null) && (s.length() > 0)) {
        //check validity
        return;
    }

    this.setVisible(false);
    rent.setVisible(true);

}//GEN-LAST:event_rentItemActionPerformed

private void returnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnItemActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
    returnIt.setVisible(true);

}//GEN-LAST:event_returnItemActionPerformed

private void makeReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReservationActionPerformed
// TODO add your handling code here:
    Reservation [] reservations = new Reservation[10];
    String s = (String)JOptionPane.showInputDialog(this,"Scan Membership Card\n","Confirm Membership",
                JOptionPane.PLAIN_MESSAGE, null, null,null);
    
    String queryMember = "SELECT MemberID, FirstName, LastName, email, PhoneNumber, reservations  FROM members WHERE id = " + Integer.parseInt(s);
    try {
            connectToDatabase();
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminLoginSuccess.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
            Logger.getLogger(AdminLoginSuccess.class.getName()).log(Level.SEVERE, null, ex);
    }
    String reservationString = null;
    
    try {
            ResultSet rs = stmt.executeQuery(queryMember);

            while (rs.next()) {
                member = new MemberAccount(rs.getInt("MemberID"),rs.getString("FirstName"), rs.getString("LastName"), 
                        rs.getString("email"),rs.getInt("PhoneNumber"));
                reservationString = rs.getString("reservations");
                
            } //end while
            for(int i = 0; i<reservationString.split(", ").length; i++){
                reservations[i].setReservationId(Integer.parseInt(reservationString.split(", ")[i]));
            }
            member.setReservations(reservations);
            
            con.close();
        } //end try
        
        catch(SQLException e) {e.printStackTrace();}
    
    new MakeReservation(this.employee, member);
    this.setVisible(false);

}//GEN-LAST:event_makeReservationActionPerformed

private void cancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservationActionPerformed
// TODO add your handling code here:
    Reservation [] reservations = new Reservation[10];
    String s = (String)JOptionPane.showInputDialog(this,"Scan Membership Card\n","Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE, null, null,null);
    String reservationString = null;
    
    //If a string was returned, say so.
    if ((s != null) && (s.length() > 0)) {
        //check validity
        return;
    }
    String queryMember = "SELECT MemberID, FirstName, LastName, email, PhoneNumber, reservations  FROM members WHERE id = " + Integer.parseInt(s);

    try {
            ResultSet rs = stmt.executeQuery(queryMember);

            while (rs.next()) {
                member = new MemberAccount(rs.getInt("MemberID"),rs.getString("FirstName"), rs.getString("LastName"), 
                        rs.getString("email"),rs.getInt("PhoneNumber"));
                reservationString = rs.getString("reservations");
                
            } //end while
            for(int i = 0; i<reservationString.split(", ").length; i++){
                reservations[i].setReservationId(Integer.parseInt(reservationString.split(", ")[i]));
            }
            member.setReservations(reservations);
            
                
            con.close();
        } //end try

        catch(SQLException e) {
            e.printStackTrace();
        }

    this.setVisible(false);
    cancelReserve.setMember(member);
    cancelReserve.setVisible(true);

}//GEN-LAST:event_cancelReservationActionPerformed

private void createAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountActionPerformed
// TODO add your handling code here:
    this.setVisible(false);
    createAcc.setVisible(true);

}//GEN-LAST:event_createAccountActionPerformed

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
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSuccessful.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginSuccessful().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelReservation;
    private javax.swing.JButton createAccount;
    private javax.swing.JButton editAccountInfo;
    private javax.swing.JButton makeReservation;
    private javax.swing.JButton purchase;
    private javax.swing.JButton rentItem;
    private javax.swing.JButton returnItem;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
