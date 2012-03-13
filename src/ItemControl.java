import java.sql.*;
import java.util.ArrayList;
import javax.sql.*;

/*
 * This is used to control all 
 */
class ItemControl{
    private Game game;
    private Video video;    

	public ItemControl(){

        }
	
	public void purchaseVid(Video video){
               video.noOfCopies--;
        }

	public void purchaseGame(Game game){
               game.noOfCopies--;
        }
        
        public void returnVideo(Video video){
            video.noOfCopies++;
        }

        public void returnGame(Video video){
            game.noOfCopies++;
        }
        
        public void addVideo(String title, int noOfCopies, int rentPrice, int purchasePrice, String description, String[] actors, 
                String duration, String genre, String ratingScore, String type){
          //addto database
           video = new Video(title, noOfCopies, rentPrice, purchasePrice, description, actors, duration, genre, ratingScore, type);
           
           String dbtime;
           String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
           String dbClass = "com.mysql.jdbc.Driver";
           String insertString = null;
           int productID;
           try {

            Class.forName(dbClass);
            Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
            Statement stmt = con.createStatement();
            
            insertString = "('"+video.getTitle()+"', '"+video.getActorsString()+"', '"+video.getDirector()+"', '"+video.getRating()
                    + "', '"+video.getRuntime()+"', '"+video.getCategory()
                    +"', '" + video.getMedium()+ "', "+video.getNoOfCopies()+ ", "
                    +video.getRentPrice()+","+video.getPurchasePrice()+")";
            
            int rs = stmt.executeUpdate("INSERT INTO movies ('Title', 'Actors', 'Director', 'Rating', 'Runtime',"
                    + " 'Category', 'Medium', 'noOfCopies', 'rentalPrice', 'purchasePrice')"
                    + " VALUES" + insertString, Statement.RETURN_GENERATED_KEYS);
            ResultSet results = stmt.getGeneratedKeys();
            if ( results.next() ) {
                // Retrieve the auto generated key(s).
                    productID = results.getInt(1);
            }
            video.setproductID(productID);
            
            con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }

   
        }

        public void addGame(String title, double rentPrice, double purchasePrice, String description, ArrayList<String> console, 
                String genre, String developer, String publisher){
          //add to database
           game = new Game(title, rentPrice, purchasePrice, description, console, genre, developer, publisher);  
           String dbtime;
           String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
           String dbClass = "com.mysql.jdbc.Driver";

           String newGameInformation = null;
           int productID = 0;
            try {

                Class.forName(dbClass);
                Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
                Statement stmt = con.createStatement();

                newGameInformation = "('"+game.getTitle()+"', '"+ game.getRating()+ "', '"+game.getCategory()
                        +"', '" + game.getDeveloper()+"', '"+ game.getPublisher()+ "', '"+game.getConsole()
                        +"', "+game.getNoOfCopies()+", "+game.getRentalPrice()+", "+game.getPurchasePrice()+")";

                int rs = stmt.executeUpdate("INSERT INTO games ('title', 'rating', 'category', 'developer', 'publisher', 'system',"
                        + "'noOfCopies','rentalPrice','purchasePrice')"
                        + " VALUES" + newGameInformation, Statement.RETURN_GENERATED_KEYS);
                ResultSet results = stmt.getGeneratedKeys();
                if ( results.next() ) {
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
        
        public void removeVideo(Video video){
            //remove from database
            
        }
        
        public void removeGame(Game game){
            //remove from database
            
        }
       
}