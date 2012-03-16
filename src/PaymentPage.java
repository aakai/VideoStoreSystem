import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Payment.java
 * Created on Nov 25, 2011, 10:01:21 PM
 */
/**
 * @author anearcan
 */
public class PaymentPage extends javax.swing.JFrame {
    private static DefaultListModel listModel = new DefaultListModel();
    private Payment payment;
    private Item [] scannedItems;
    private MemberAccount member;
    private MembershipControl control;
    private Employee employee;
    private int balance = 0;//current balance for new rentals
    private Date today = new java.util.Date();
    
    /** Creates new form Payment */
    public PaymentPage() {
        initComponents();
        scannedItemsList = new JList(listModel);
    }

    PaymentPage(Employee employee) {
        initComponents();
        this.employee = employee;
        scannedItemsList = new JList(listModel);
    }

    public PaymentPage(Employee employee, MemberAccount member, Item [] items) {
        initComponents();
        scannedItems = items;
        this.employee = employee;
        this.member = member;
        scannedItemsList = new JList(listModel);   
        memberID.setText(Integer.toString(member.getMemberID()));
        accountBalance.setText(Double.toString(member.getTotalCharge()));
        //Populate JList
        for(int i = 0; i<items.length; i++){
            listModel.addElement((String)items[i].getTitle());
        }

        for(int i = 0; i<items.length; i++){
            balance+=items[i].getRentalPrice();
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        totalRentalCost = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scannedItemsList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        memberID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        accountBalance = new javax.swing.JLabel();
        paymentMethodcomboBox = new javax.swing.JComboBox();
        accountBalance1 = new javax.swing.JLabel();
        payRentalButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pay");

        jLabel2.setText("Total");

        totalRentalCost.setText("$51.00");

        scannedItemsList.setModel(listModel);
        scannedItemsList.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                scannedItemsListInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(scannedItemsList);

        jLabel1.setText("Scanned Items");

        jLabel3.setText("MemberID");

        memberID.setText("0000005");

        jLabel4.setText("Account Balance");

        accountBalance.setText("$0.00");

        paymentMethodcomboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Credit Card", "Debit Card" }));
        paymentMethodcomboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodcomboBoxActionPerformed(evt);
            }
        });

        accountBalance1.setText("Payment Method");

        payRentalButton.setText("Pay");
        payRentalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payRentalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(memberID))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(accountBalance1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paymentMethodcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalRentalCost)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                            .addComponent(accountBalance))))
                .addGap(150, 150, 150))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(payRentalButton)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(memberID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(accountBalance))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalRentalCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountBalance1)
                    .addComponent(paymentMethodcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(payRentalButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void scannedItemsListInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_scannedItemsListInputMethodTextChanged
// TODO add your handling code here:
}//GEN-LAST:event_scannedItemsListInputMethodTextChanged

private void paymentMethodcomboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodcomboBoxActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_paymentMethodcomboBoxActionPerformed

private void payRentalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payRentalButtonActionPerformed
    payment = new Payment(balance, employee, member,  today);
    try {
        control.pay(payment);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(PaymentPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    new PrinterInterface().printReceipt(payment);
    new CustomDate().returnToMainMenu(employee);
    this.setVisible(false);

}//GEN-LAST:event_payRentalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PaymentPage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountBalance;
    private javax.swing.JLabel accountBalance1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel memberID;
    private javax.swing.JButton payRentalButton;
    private javax.swing.JComboBox paymentMethodcomboBox;
    private javax.swing.JList scannedItemsList;
    private javax.swing.JLabel totalRentalCost;
    // End of variables declaration//GEN-END:variables
}
