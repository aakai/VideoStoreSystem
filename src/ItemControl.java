import java.sql.*;
import java.util.ArrayList;
import javax.sql.*;

/*
 * This is used to control all 
 */
class ItemControl{
    private Game game;
    private Video video;    
    public Utility utility;

    
    public ItemControl() throws SQLException{
        utility = new Utility();
    }
   
    public void purchaseVid(Video video){

           try {
             utility.connect();
             
            ResultSet rs = utility.stmt.executeQuery("SELECT * FROM movies WHERE id = "+ Integer.toString(video.getProductID()));
            
            while(rs.next()) {
                // Retrieve the auto generated key(s).
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")- 1));
                    rs.updateRow();
                    System.out.println("# of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    video.setNoOfCopies(rs.getInt("noOfCopies"));
            }
            
            utility.con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void purchaseGame(Game game){
           try {
             utility.connect();
             
            ResultSet rs = utility.stmt.executeQuery("SELECT * FROM games WHERE id = "+ Integer.toString(game.getProductID()));
            
            while(rs.next()) {
                // Retrieve the auto generated key(s).
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")- 1));
                    rs.updateRow();
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    game.setNoOfCopies(rs.getInt("noOfCopies"));
            }
            
            utility.con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnVideo(Video video, MemberAccount member){
             try {
             utility.connect();
             
            ResultSet rs = utility.stmt.executeQuery("SELECT * FROM movies WHERE id = "+ Integer.toString(video.getProductID()));
            
            while(rs.next()) {
                // Retrieve the auto generated key(s).
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")+ 1));
                    rs.updateRow();
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    video.setNoOfCopies(rs.getInt("noOfCopies"));
            }
    
             ResultSet results = utility.stmt.executeQuery("SELECT * FROM members WHERE id = "+ Integer.toString(member.getMemberID()));
              while(results.next()){
                  System.out.println(results.getString("pastItems"));
                  results.updateString("pastItems", results.getString("pastItems")+ ", "+ video.getTitle());
                  results.updateRow();
              }        

            utility.con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
  }

    public void returnGame(Game game, MemberAccount member){
                String currentItems[] = new String[50];
                String currentItemsString = null;
                try {
                    utility.connect();

                    ResultSet rs = utility.stmt.executeQuery("SELECT * FROM games WHERE id = "+ Integer.toString(game.getProductID()));

                    while(rs.next()) {
                        // Retrieve the auto generated key(s).
                            System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                            rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")- 1));
                            rs.updateRow();
                            System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                            game.setNoOfCopies(rs.getInt("noOfCopies"));
                            game.setDateReturned(new java.util.Date());

                 }
                 ResultSet results = utility.stmt.executeQuery("SELECT * FROM members WHERE id = "+ Integer.toString(member.getMemberID()));
                 while(results.next()){
                      System.out.println(results.getString("pastItems"));
                      results.updateString("pastItems", results.getString("pastItems")+ ", "+ game.getTitle());
                      results.updateRow();
                      System.out.println(results.getString("currentItems"));
                      currentItems = results.getString("currentItems").split(", ");
                      for(int i=0; i<currentItems.length;i++){
                         if(currentItems[i].equals(game.getTitle())){
                             currentItems[i] = "";
                             for(int j=i;j<currentItems.length;j++){
                                 currentItems[j] = currentItems[i+1];
                             }
                         }
                      }
                      for(int i= 0; i<currentItems.length;i++){
                          currentItemsString +=currentItems[i];
                      }
                      results.updateString("currentItems", currentItemsString);
                      results.updateRow();
                  }        


                utility.con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
  }

    public void addVideo(String title, int noOfCopies, int rentPrice, int purchasePrice, String description, String[] actors, 
            String duration, String category, String rating, String medium, String director){
      //add to database
       video = new Video(0, title, actors, director, rating, duration, category, medium, noOfCopies, rentPrice, purchasePrice);
       String insertString = null;
       int productID = 0;
       try {
        utility.connect();
        insertString = "('"+video.getTitle()+"', '"+video.getActors()+"', '"+video.getDirector()+"', '"+video.getRating()
                + "', '"+video.getRunTime()+"', '"+video.getCategory()
                +"', '" + video.getMedium()+ "', "+video.getNoOfCopies()+ ", "
                +video.getRentalPrice()+","+video.getPurchasePrice()+")";

        int rs = utility.stmt.executeUpdate("INSERT INTO movies ('Title', 'Actors', 'Director', 'Rating', 'Runtime',"
                + " 'Category', 'Medium', 'noOfCopies', 'rentalPrice', 'purchasePrice')"
                + " VALUES" + insertString, Statement.RETURN_GENERATED_KEYS);
        ResultSet results = utility.stmt.getGeneratedKeys();
        if ( results.next() ) {
            // Retrieve the auto generated key(s).
                productID = results.getInt(1);
        }
        video.setProductID(productID);
        utility.con.close();
    } //end try

    catch(ClassNotFoundException e) {
        e.printStackTrace();
    }

    catch(SQLException e) {
        e.printStackTrace();
    }
}

    public void addGame(String title, int rentPrice, int purchasePrice, String description, ArrayList<String> console, 
            String developer, String publisher, String rating, String category){
      //add to database
       game = new Game(title, rentPrice, purchasePrice, description, rating, console, category, developer, publisher);  

       String newGameInformation = null;
       int productID = 0;
        try {

            utility.connect();
            newGameInformation = "('"+game.getTitle()+"', '"+ game.getRating()+ "', '"+game.getCategory()
                    +"', '" + game.getDeveloper()+"', '"+ game.getPublisher()+ "', '"+Integer.toString(game.getProductID())
                    +"', "+Integer.toString(game.getNoOfCopies())+", "+Integer.toString(game.getRentalPrice())+", "
                    +Integer.toString(game.getPurchasePrice())+")";

            int rs = utility.stmt.executeUpdate("INSERT INTO games ('title', 'rating', 'category', 'developer', 'publisher', 'system',"
                    + "'noOfCopies','rentalPrice','purchasePrice')"
                    + " VALUES" + newGameInformation, Statement.RETURN_GENERATED_KEYS);
            ResultSet results = utility.stmt.getGeneratedKeys();
            if (results.next()) {
                // Retrieve the auto generated key(s).
                    productID = results.getInt(1);
            }
            game.setProductID(productID);
            utility.con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeVideo(int productID){
        //remove from database


         try {
              utility.connect();
              int rs = utility.stmt.executeUpdate("DELETE FROM movies WHERE id = " + Integer.toString(productID));

              if (rs == 1 ) {
                  // Retrieve the auto generated key(s).
                  System.out.println("Video Deleted!");
              }else{
                  System.out.println("ERROR with video removal from database");
              }
              utility.con.close();
      } //end try
        catch(ClassNotFoundException e) {
          e.printStackTrace();
      }

      catch(SQLException e) {
          e.printStackTrace();
      }        	 
    }

    public void removeGame(int productID){
      
           try { 
               utility.connect();
               
              int rs = utility.stmt.executeUpdate("DELETE FROM games WHERE id = " +  productID);
              if (rs == 1 ) {
                  // Retrieve the auto generated key(s).
                  System.out.println("Game Deleted!");
              }else{
                  System.out.println("ERROR with game removal from database");
              }

               utility.con.close();
           } //end try

           catch(ClassNotFoundException e) {
               e.printStackTrace();
           }

           catch(SQLException e) {
               e.printStackTrace();
           }

    }

}