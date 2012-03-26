
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author anearcan
 */
public class PurchasePayment extends javax.swing.JFrame {
    private static Employee employee;
    private static Game[] games;
    private static Video[] videos;
    private static ItemControl control;
    private static DefaultListModel listModel = new DefaultListModel();
    private static int gameCount = 0;
    private static int vidCount= 0;
    private static int total = 0;
    private Payment purchasePayment = null;
    /** Creates new form PurchasePayment */

    public PurchasePayment() {
      
        initComponents();
        scannedItemList = new JList(listModel); 
        totalCost.setText(Integer.toString(total));
    }

    PurchasePayment(Employee employee) {
        initComponents();
        this.employee = employee;
        scannedItemList = new JList(listModel);
        totalCost.setText(Integer.toString(total));
    }

    
    PurchasePayment(Employee employee, Item item) {
        initComponents();
        this.employee = employee;
        games[0] = (Game) item;
        videos[0]= (Video) item;
        scannedItemList = new JList(listModel);
        listModel.addElement(item.getTitle());
        total += item.getPurchasePrice();
        totalCost.setText(Integer.toString(total));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        scannedItemList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalCost = new javax.swing.JLabel();
        paymentMethodcomboBox = new javax.swing.JComboBox();
        paymentMethodLabel = new javax.swing.JLabel();
        purchasePayButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purchase Item");

        scannedItemList.setModel(listModel);
        scannedItemList.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                scannedItemListInputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(scannedItemList);

        jLabel1.setText("Scanned Items");

        jLabel2.setText("Total");

        totalCost.setText("Amount");

        paymentMethodcomboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Credit Card" }));
        paymentMethodcomboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodcomboBoxActionPerformed(evt);
            }
        });

        paymentMethodLabel.setText("Payment Method");

        purchasePayButton.setText("Pay");
        purchasePayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasePayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(purchasePayButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(paymentMethodLabel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(paymentMethodcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalCost))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(totalCost))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentMethodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentMethodcomboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(purchasePayButton)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void scannedItemListInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_scannedItemListInputMethodTextChanged
// TODO add your handling code here:
}//GEN-LAST:event_scannedItemListInputMethodTextChanged

private void paymentMethodcomboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodcomboBoxActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_paymentMethodcomboBoxActionPerformed

private void purchasePayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasePayButtonActionPerformed

    //Purchase function called for each game in the list
        for(int i= 0; i< gameCount; i++){
            control.purchaseGame(games[i]);
        }
    //Purchase function called for each game in the list        
        for(int i = 0; i<vidCount;i++){
            control.purchaseVid(videos[i]);
        }
        
        if((String)paymentMethodcomboBox.getSelectedItem() == "Cash"){
            purchasePayment = new CashPayment(Double.parseDouble(totalCost.getText()));
        }else{
            purchasePayment = new CreditCardPayment(Double.parseDouble(totalCost.getText()));
        
        }
        
        new PrinterInterface().printReceipt(purchasePayment);
        if(employee.IsAdmin()){
            try {
                new AdminLoginSuccess(employee).setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PurchasePayment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PurchasePayment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                new LoginSuccessful().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PurchasePayment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(PurchasePayment.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.setVisible(false);
}//GEN-LAST:event_purchasePayButtonActionPerformed
    //Scans item and add item to list of scanned items.
public static void addItemsToList() {
        String id = "-1";
        JFrame frame = new JFrame(); 
        do{
            id = (String)JOptionPane.showInputDialog(frame, "Scan Item(enter 0 to stop)","Rent",JOptionPane.PLAIN_MESSAGE);                
            
            String queryGames = "SELECT id, title, purchasePrice FROM games where id = "+ id;
            String queryMovies = "SELECT id, title, purchasePrice FROM movies where id = " + id;
           
            try {
                listModel.addElement((String)id);
                Utility.connect();
                Statement gameStmt = Utility.con.createStatement();
                Statement movieStmt = Utility.con.createStatement();
                
                
                ResultSet rsGame = gameStmt.executeQuery(queryGames);
                while (rsGame.next()) {
                     //title  and the price are displayed on the list pane
                     listModel.addElement((String)rsGame.getString("title") + "   $"
                             + Integer.toString(rsGame.getInt("purchasePrice")));

                     System.out.println(Integer.toString(rsGame.getInt("noOfCopies")));                     
                     //Update total Cost
                     total += rsGame.getInt("purchasePrice");
                     totalCost.setText(Integer.toString(total));
                     //Select the new item and make it visible.
                     scannedItemList.setSelectedIndex(gameCount);
                     scannedItemList.ensureIndexIsVisible(gameCount);
                     //add to list of games
                     games[gameCount] = new Game(rsGame.getInt("id"), rsGame.getString("title"), rsGame.getInt("rentalPrice"), rsGame.getInt("purchasePrice"));
                     gameCount++;
                }

                ResultSet rsMovies = movieStmt.executeQuery(queryMovies);
                while(rsMovies.next()){
                     //title  and the price are displayed on the list pane
                     listModel.addElement((String)rsMovies.getString("Title") + "   $"
                             + Integer.toString(rsMovies.getInt("purchasePrice")));
                       
                     System.out.println(Integer.toString(rsMovies.getInt("noOfCopies")));
                                          //Update total cost
                     total += rsMovies.getInt("purchasePrice");
                     totalCost.setText(Integer.toString(total));
                      //Select the new item and make it visible.                     
                     scannedItemList.setSelectedIndex(vidCount);
                     scannedItemList.ensureIndexIsVisible(vidCount);
                     //add to list of videos
                     videos[vidCount] = new Video(rsMovies.getInt("id"), rsMovies.getString("Title"), rsMovies.getString("Actors").split(", "),
                              rsMovies.getString("Director"), rsMovies.getString("Rating"), 
                             rsMovies.getString("Runtime"), rsMovies.getString("Category"), 
                             rsMovies.getString("Medium"), rsMovies.getInt("noOfCopies"),
                             rsMovies.getInt("rentalPrice"), rsMovies.getInt("purchasePrice"));
                     vidCount++;
                }       

                Utility.con.close();
            } //end try
            catch(ClassNotFoundException e) {
                e.printStackTrace();
            }

            catch(SQLException e) {
                e.printStackTrace();
            }
        }while(id != "0");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(PurchasePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchasePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchasePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchasePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PurchasePayment().setVisible(true);
            }
        });
        PurchasePayment.addItemsToList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paymentMethodLabel;
    private javax.swing.JComboBox paymentMethodcomboBox;
    private javax.swing.JButton purchasePayButton;
    private static javax.swing.JList scannedItemList;
    private static javax.swing.JLabel totalCost;
    // End of variables declaration//GEN-END:variables
}
