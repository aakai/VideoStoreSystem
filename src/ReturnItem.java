import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
        
/**
 *
 * @author anearcan
 */
public class ReturnItem extends javax.swing.JFrame {

    private Item returnedItem;
    private Employee employee;
    private static MemberAccount member;
    private static DefaultListModel listModel;
    public static ItemControl control;
    public static JFrame frame = new JFrame();
    private static int count = 0;
    /** Creates new form ReturnItem */
    public ReturnItem() throws SQLException {
        listModel = new DefaultListModel();
        employee = null;
        member = null;
        returnedItem = null;
        control = new ItemControl();
        initComponents();
    }

    ReturnItem(Employee employee) throws SQLException {
        listModel = new DefaultListModel();
        this.employee = employee;
        member = null;
        returnedItem = null;
        control = new ItemControl();
        
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
        unreturnedItems = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        memberID = new javax.swing.JLabel();
        Done = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Return Item");

        jScrollPane1.setToolTipText("");

        unreturnedItems.setModel(listModel);
        jScrollPane1.setViewportView(unreturnedItems);

        jLabel1.setText("Items In Possession");
        jLabel1.setToolTipText("");

        jLabel7.setText("MemberID");
        jLabel7.setToolTipText("");

        memberID.setToolTipText("");

        Done.setText("Done");
        Done.setToolTipText("");
        Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(memberID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Done)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(memberID, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Done)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  //Scans item and add item to list of scanned items.
    public static void addItemsToList(){
        String id = null;
        
        do{
            id = (String)JOptionPane.showInputDialog(frame, "Scan Item(enter 0 to stop)","Return",JOptionPane.PLAIN_MESSAGE);                
            
            String queryGames = "SELECT * FROM games where id = "+ id;
            String queryMovies = "SELECT * FROM movies where id = " + id;
           
            try {
                new Utility().connect();
                PreparedStatement gameStmt = new Utility().con.prepareStatement(queryGames);
                PreparedStatement movieStmt = new Utility().con.prepareStatement(queryMovies);
                
                
                ResultSet rsGame = gameStmt.executeQuery();
                while (rsGame.next()) {
                    
                     listModel.addElement(rsGame.getString("title"));
                     //Select the new item and make it visible.
                    unreturnedItems.setSelectedIndex(count);
                    unreturnedItems.ensureIndexIsVisible(count);
 
                }

                ResultSet rsMovies = movieStmt.executeQuery();
                while(rsMovies.next()){
                     listModel.addElement(rsMovies.getString("Title") + " $" + rsMovies.getInt("rentalPrice"));
                     //Select the new item and make it visible.                     
                    unreturnedItems.setSelectedIndex(count);
                    unreturnedItems.ensureIndexIsVisible(count);
                }
                count++;
                
                Utility.con.close();
            } //end try

            catch(ClassNotFoundException e) {
                e.printStackTrace();
            }

            catch(SQLException e) {
                e.printStackTrace();
            }
        }while(!id.equalsIgnoreCase("0"));
    }

private void DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_DoneActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReturnItem().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ReturnItem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        String s = (String)JOptionPane.showInputDialog(frame,"Scan Membership Card\n","Confirm Membership",
                JOptionPane.PLAIN_MESSAGE, null, null,null);
   
        try {
            memberID.setText(s);
            ResultSet rs = new Utility().stmt.executeQuery("SELECT * FROM members WHERE MemberID = " + Integer.parseInt(s));
            while(rs.next()){
                member = new MemberAccount(Integer.parseInt(s), rs.getString("FirstName"), rs.getString("LastName"),
                                rs.getString("email"), (int)rs.getLong("PhoneNumber"));
                member.setAddress(rs.getString("Address"));
                member.setStatus(rs.getString("Status"));
                member.setTotalCharge(rs.getFloat("accountBalance"));            
            }
       } catch (SQLException ex) {
            Logger.getLogger(AdminLoginSuccess.class.getName()).log(Level.SEVERE, null, ex);
       }

        addItemsToList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel memberID;
    private static javax.swing.JList unreturnedItems;
    // End of variables declaration//GEN-END:variables

}
