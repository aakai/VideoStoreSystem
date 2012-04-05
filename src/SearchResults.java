import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
import javax.swing.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Searchresults.java
 *
 * Created on Nov 27, 2011, 9:07:43 AM
 */
/**
 *
 * @author anearcan
 */
public class SearchResults extends javax.swing.JFrame {

    /** Creates new form SearchResults */
    private boolean vidSearch;
    private boolean gameSearch;
    private boolean actorKey;
    private boolean directorKey;
    private boolean titleKey;
    private boolean genreKey;
    private boolean consoleKey;
    private boolean developerKey;
    private boolean publisherKey;
    private String dBurl = "jdbc:mysql://localhost:3306/sourceit_vss";
    private String keyword;
    private ArrayList<String> criteria = new ArrayList<String>();
    private DefaultListModel listModel = new DefaultListModel();
    private Employee employee;

    public SearchResults(){
        initComponents();
        searchResults = new JList(listModel);
        employee = null;
    }

    public SearchResults(Employee employee) {
        initComponents();
        this.employee = employee;
         searchResults = new JList(listModel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        resultScrollPane = new javax.swing.JScrollPane();
        searchResults = new javax.swing.JList();
        find = new javax.swing.JLabel();
        searchKeyword = new javax.swing.JTextField();
        searchTitleCheck = new javax.swing.JCheckBox();
        searchGenreCheck = new javax.swing.JCheckBox();
        searchActorCheck = new javax.swing.JCheckBox();
        searchDirectorCheck = new javax.swing.JCheckBox();
        searchConsoleCheck = new javax.swing.JCheckBox();
        searchButton = new javax.swing.JButton();
        developerCheck = new javax.swing.JCheckBox();
        publisherCheck = new javax.swing.JCheckBox();
        itemType = new javax.swing.JComboBox();
        selectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Results");

        jLabel1.setText("Search Results");

        searchResults.setModel(listModel        );
        searchResults.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                searchResultsComponentAdded(evt);
            }
        });
        resultScrollPane.setViewportView(searchResults);

        find.setText("Find:");

        searchKeyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeywordActionPerformed(evt);
            }
        });

        searchTitleCheck.setText("Title");
        searchTitleCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTitleCheckActionPerformed(evt);
            }
        });

        searchGenreCheck.setText("Genre");
        searchGenreCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGenreCheckActionPerformed(evt);
            }
        });

        searchActorCheck.setText("Actor");
        searchActorCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActorCheckActionPerformed(evt);
            }
        });

        searchDirectorCheck.setText("Director");
        searchDirectorCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDirectorCheckActionPerformed(evt);
            }
        });

        searchConsoleCheck.setText("Console");
        searchConsoleCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchConsoleCheckActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        developerCheck.setText("Developer");
        developerCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                developerCheckActionPerformed(evt);
            }
        });

        publisherCheck.setText("Publisher");
        publisherCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherCheckActionPerformed(evt);
            }
        });

        itemType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Video", "Game" }));

        selectButton.setText("Select Item");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(find)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectButton)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTitleCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchGenreCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchActorCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchDirectorCheck))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(searchConsoleCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(developerCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(publisherCheck))
                    .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(find)
                    .addComponent(searchKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTitleCheck)
                    .addComponent(searchGenreCheck)
                    .addComponent(searchActorCheck)
                    .addComponent(searchDirectorCheck)
                    .addComponent(itemType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchConsoleCheck)
                    .addComponent(developerCheck)
                    .addComponent(publisherCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(selectButton)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void searchDirectorCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDirectorCheckActionPerformed
// TODO add your handling code here:
    directorKey = true;
    criteria.add("Director");
}//GEN-LAST:event_searchDirectorCheckActionPerformed

private void searchKeywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeywordActionPerformed
// TODO add your handling code here:
    keyword = searchKeyword.getText();
}//GEN-LAST:event_searchKeywordActionPerformed

private void searchActorCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActorCheckActionPerformed
// TODO add your handling code here:
    actorKey = true;
    criteria.add("Actors");
}//GEN-LAST:event_searchActorCheckActionPerformed

private void searchResultsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_searchResultsComponentAdded
// TODO add your handling code here:
}//GEN-LAST:event_searchResultsComponentAdded

private void searchGenreCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGenreCheckActionPerformed
// TODO add your handling code here:
    genreKey = true;
    if((String)itemType.getSelectedItem() == "Video"){
        criteria.add("Category");
    }else{
        criteria.add("category");
    }
}//GEN-LAST:event_searchGenreCheckActionPerformed

private void searchTitleCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTitleCheckActionPerformed
// TODO add your handling code here:
    titleKey = true;
    if((String)itemType.getSelectedItem() == "Video"){
        criteria.add("Title");
    }else{
        criteria.add("title");
    }
}//GEN-LAST:event_searchTitleCheckActionPerformed

private void searchConsoleCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchConsoleCheckActionPerformed
// TODO add your handling code here:
    consoleKey = true;
    criteria.add("system");
}//GEN-LAST:event_searchConsoleCheckActionPerformed

private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
// TODO add your handling code here:
    ResultSet rs;
    keyword = searchKeyword.getText();
    
    try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection (dBurl, "root","");
            Statement stmt = con.createStatement();
           
            String type = (String)itemType.getSelectedItem();
            System.out.print(type + "\n");
            
            String query = generateQuery(type);
            System.out.print(query +"\n");
            rs = stmt.executeQuery(query);
            while(rs.next()){
                if(type == "Game"){
                    String result = rs.getString("title");
                    listModel.addElement((String)result);
                    System.out.print(result);
                }else{
                    String result = rs.getString("Title");
                    listModel.addElement((String)result);
                    System.out.print(result);
                }
            }
      }
        catch (SQLException ex) {
            Logger.getLogger(SearchResults.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchResults.class.getName()).log(Level.SEVERE, null, ex);
        }    
    
}//GEN-LAST:event_searchButtonActionPerformed

private void publisherCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherCheckActionPerformed
// TODO add your handling code here:
    publisherKey = true;
    criteria.add("publisher");
}//GEN-LAST:event_publisherCheckActionPerformed

private void developerCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_developerCheckActionPerformed
// TODO add your handling code here:
    developerKey = true;
    criteria.add("developer");
}//GEN-LAST:event_developerCheckActionPerformed

private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
    ResultSet rs;
    Video selectedVideo = new Video();
    
 
    try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection (dBurl, "root", "");
            
            String selectedTitle = listModel.getElementAt(searchResults.getSelectedIndex()+ 1).toString();
            System.out.println(selectedTitle + "\n");

            String type = (String)itemType.getSelectedItem();
            if(type == "Video"){
                rs = new Utility().stmt.executeQuery("SELECT * FROM movies WHERE Title = '" + selectedTitle+ "'");
                while(rs.next()){
                 
                   selectedVideo.setTitle(selectedTitle);
                   selectedVideo.setProductID(rs.getInt("id"));
                   selectedVideo.setActor(rs.getString("Actors").split(", "));
                   selectedVideo.setGenre(rs.getString("Category"));
                   selectedVideo.setDirector(rs.getString("Director"));
                   selectedVideo.setFormat(rs.getString("Medium"));
                   selectedVideo.setRating(rs.getString("Rating"));
                   selectedVideo.setRentalPrice(rs.getInt("rentalPrice"));
                   selectedVideo.setPurchasePrice(rs.getInt("purchasePrice"));
                   selectedVideo.setRunTime(rs.getString("Runtime"));
                   selectedVideo.setNoOfCopies(rs.getInt("noOfCopies"));
                    
                }
                new VideoInfo(employee, selectedVideo).setVisible(true);
                this.setVisible(false);
             }else{
                Game selectedGame = null;
                rs = new Utility().stmt.executeQuery("SELECT * FROM games WHERE title = '" + selectedTitle +"'");
                while(rs.next()){
                    selectedGame = new Game(rs.getInt("id"), selectedTitle, rs.getInt("rentalPrice"), rs.getInt("purchasePrice"), "...",
                            rs.getString("Rating"),new ArrayList(Arrays.asList(rs.getString("system").split(", "))), rs.getString("category"), 
                            rs.getString("developer"), rs.getString("publisher"));
                                
                }
                new GameInfo(employee, selectedGame).setVisible(true);
                this.setVisible(false);
             }
        }
        catch (SQLException ex) {
            Logger.getLogger(SearchResults.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchResults.class.getName()).log(Level.SEVERE, null, ex);
        }    
}//GEN-LAST:event_selectButtonActionPerformed

private String generateQuery(String item_type) {
    String query = null;
    keyword = searchKeyword.getText();
    if( "Video".equals(item_type) ){
	query = "SELECT Title FROM movies ";
	Iterator<String> itr = criteria.iterator();
	int i = 0;
        while (itr.hasNext()) {
		String property = itr.next();
		if (i ==0){
			query += " WHERE " + property + " LIKE '" + keyword + "%'";
                }else{
                    query += " OR " + property + " LIKE '" + keyword + "%'";
                }
                i++;
	}
    }else if("Game".equals(item_type)){
	query = "SELECT `title` FROM `games` ";
	Iterator<String> itr = criteria.iterator();
	int i = 0;
        while (itr.hasNext()) {
		String property = itr.next();
		if (i ==0){
			query += " WHERE `" + property + "` LIKE '" + keyword + "%'";
                }else{
                        query += " OR `" + property + "` LIKE '" + keyword + "%'";
                }
                i++;
	}
        
    }    
	return query;
}	

//The search results would be output with a button for each option.
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
   
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SearchResults().setVisible(true);
            }
        });
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox developerCheck;
    private javax.swing.JLabel find;
    private javax.swing.JComboBox itemType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox publisherCheck;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JCheckBox searchActorCheck;
    private javax.swing.JButton searchButton;
    private javax.swing.JCheckBox searchConsoleCheck;
    private javax.swing.JCheckBox searchDirectorCheck;
    private javax.swing.JCheckBox searchGenreCheck;
    private javax.swing.JTextField searchKeyword;
    private javax.swing.JList searchResults;
    private javax.swing.JCheckBox searchTitleCheck;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
