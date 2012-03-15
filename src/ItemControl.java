import java.sql.*;
import java.util.ArrayList;
import javax.sql.*;

/*
 * This is used to control all 
 */
class ItemControl{
    private Game game;
    private Video video;    
    String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
    String dbClass = "com.mysql.jdbc.Driver";
    Connection con;
    Statement stmt;
    public ItemControl(){

    }
    public void connect() throws ClassNotFoundException, SQLException{
        Class.forName(dbClass);
        con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    
    }

    public void purchaseVid(Video video){

           try {
             connect();
             
            ResultSet rs = stmt.executeQuery("SELECT noOfCopies FROM movies WHERE id = "+ Integer.toString(video.getProductID()));
            
            while(rs.next()) {
                // Retrieve the auto generated key(s).
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")- 1));
                    rs.updateRow();
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    video.setNoOfCopies(rs.getInt("noOfCopies"));
            }
            
            con.close();
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
             connect();
             
            ResultSet rs = stmt.executeQuery("SELECT noOfCopies FROM games WHERE id = "+ Integer.toString(game.getProductID()));
            
            while(rs.next()) {
                // Retrieve the auto generated key(s).
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")- 1));
                    rs.updateRow();
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    game.setNoOfCopies(rs.getInt("noOfCopies"));
            }
            
            con.close();
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
             connect();
             
            ResultSet rs = stmt.executeQuery("SELECT noOfCopies FROM movies WHERE id = "+ Integer.toString(video.getProductID()));
            
            while(rs.next()) {
                // Retrieve the auto generated key(s).
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")+ 1));
                    rs.updateRow();
                    System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                    video.setNoOfCopies(rs.getInt("noOfCopies"));
            }
    
             ResultSet results = stmt.executeQuery("SELECT pastItems FROM members WHERE id = "+ Integer.toString(member.getMemberID()));
              while(results.next()){
                  System.out.println(results.getString("pastItems"));
                  results.updateString("pastItems", results.getString("pastItems")+ ", "+ video.getTitle());
                  results.updateRow();
              }        

            con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
  }

    public void returnGame(Game game, MemberAccount member){
             try {
                 connect();

                ResultSet rs = stmt.executeQuery("SELECT noOfCopies FROM games WHERE id = "+ Integer.toString(game.getProductID()));

                while(rs.next()) {
                    // Retrieve the auto generated key(s).
                        System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                        rs.updateInt("noOfCopies", (rs.getInt("noOfCopies")- 1));
                        rs.updateRow();
                        System.out.println("#of copies = "+ Integer.toString(rs.getInt("noOfCopies")));
                        game.setNoOfCopies(rs.getInt("noOfCopies"));
             }
             ResultSet results = stmt.executeQuery("SELECT pastItems FROM members WHERE id = "+ Integer.toString(member.getMemberID()));
              while(results.next()){
                  System.out.println(results.getString("pastItems"));
                  results.updateString("pastItems", results.getString("pastItems")+ ", "+ game.getTitle());
                  results.updateRow();
              }        

                
            con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }
  }

    public void addVideo(String title, int noOfCopies, int rentPrice, int purchasePrice, String description, String[] actors, 
            String duration, String genre, String rating, String medium, String director, String category, int productID){
      //addto database
       video = new Video(productID, title, actors, director, rating, duration, category, medium, noOfCopies, rentPrice, purchasePrice);


       String insertString = null;

       try {
         connect();
        insertString = "('"+video.getTitle()+"', '"+video.getActors()+"', '"+video.getDirector()+"', '"+video.getRating()
                + "', '"+video.getRunTime()+"', '"+video.getCategory()
                +"', '" + video.getMedium()+ "', "+video.getNoOfCopies()+ ", "
                +video.getRentalPrice()+","+video.getPurchasePrice()+")";

        int rs = stmt.executeUpdate("INSERT INTO movies ('Title', 'Actors', 'Director', 'Rating', 'Runtime',"
                + " 'Category', 'Medium', 'noOfCopies', 'rentalPrice', 'purchasePrice')"
                + " VALUES" + insertString, Statement.RETURN_GENERATED_KEYS);
        ResultSet results = stmt.getGeneratedKeys();
        if ( results.next() ) {
            // Retrieve the auto generated key(s).
                productID = results.getInt(1);
        }
        video.setProductID(productID);

        con.close();
    } //end try

    catch(ClassNotFoundException e) {
        e.printStackTrace();
    }

    catch(SQLException e) {
        e.printStackTrace();
    }
}

    public void addGame(String title, int rentPrice, int purchasePrice, String description, ArrayList<String> console, 
            String genre, String developer, String publisher, String rating, String category){
      //add to database
       game = new Game(title, rentPrice, purchasePrice, description, rating, console, category, developer, publisher);  

       String newGameInformation = null;
       int productID = 0;
        try {

            connect();
            newGameInformation = "('"+game.getTitle()+"', '"+ game.getRating()+ "', '"+game.getCategory()
                    +"', '" + game.getDeveloper()+"', '"+ game.getPublisher()+ "', '"+Integer.toString(game.getProductID())
                    +"', "+Integer.toString(game.getNoOfCopies())+", "+Integer.toString(game.getRentalPrice())+", "
                    +Integer.toString(game.getPurchasePrice())+")";

            int rs = stmt.executeUpdate("INSERT INTO games ('title', 'rating', 'category', 'developer', 'publisher', 'system',"
                    + "'noOfCopies','rentalPrice','purchasePrice')"
                    + " VALUES" + newGameInformation, Statement.RETURN_GENERATED_KEYS);
            ResultSet results = stmt.getGeneratedKeys();
            if (results.next()) {
                // Retrieve the auto generated key(s).
                    productID = results.getInt(1);
            }
            game.setProductID(productID);

            con.close();
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
              connect();
              int rs = stmt.executeUpdate("DELETE FROM movies WHERE id = " + Integer.toString(productID));

              if (rs == 1 ) {
                  // Retrieve the auto generated key(s).
                  System.out.println("Video Deleted!");
              }else{
                  System.out.println("ERROR with video removal from database");
              }
              con.close();
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
               connect();
               
              int rs = stmt.executeUpdate("DELETE FROM games WHERE id = " +  productID);
              if (rs == 1 ) {
                  // Retrieve the auto generated key(s).
                  System.out.println("Game Deleted!");
              }else{
                  System.out.println("ERROR with game removal from database");
              }

               con.close();
           } //end try

           catch(ClassNotFoundException e) {
               e.printStackTrace();
           }

           catch(SQLException e) {
               e.printStackTrace();
           }

    }

}