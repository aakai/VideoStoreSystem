import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class RentControl{
	private Date currentDate;
	private Date returnDate;//Date that the user should return item

        Statement stmt;
    
        public RentControl(Date current) throws SQLException{
		this.currentDate = current;
                returnDate = new Utility().addDays(current, 3);
	}
        
        public void connect() throws ClassNotFoundException, SQLException{
             new Utility().connect();
            stmt = new Utility().con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        }

	
	public Rental rent(MemberAccount member, Employee employee, Item copy, int charge, Date rentalDate, 
                Date returnDate) throws SQLException{
		//Notify the system that one item copy is no longer in stock and the no of copies in stock is one less
		//add Item to Member's list of items he/she is currently in possesion of.
		Rental r = new Rental(0, copy,  employee, member, charge, rentalDate, returnDate);
	 	
	        String newRentalInformation = null;
	          try {
                      connect();

	              newRentalInformation = "('"+Integer.toString(r.getRentalId())+"', '"+ r.getEmployee().toString()+ "', '"+r.getMember().toString()
	                      +"', '"+ Double.toString(r.getCharge())+ "', '" + r.getRentalDate().toString() + "', '" + r.getReturnDate().toString() + ")";

	              int rs = stmt.executeUpdate("INSERT INTO rental ('rentalID', 'copy', 'Employee', 'member', 'charge', 'rentalDate'," 
	            		  + " 'returnDate')"+ " VALUES" + newRentalInformation, Statement.RETURN_GENERATED_KEYS);
	              ResultSet results = stmt.getGeneratedKeys();
	              if ( results.next() ) {
	                  // Retrieve the auto generated key(s).
	                      r.setRentalId( results.getInt(1));
	              }
                      results = stmt.executeQuery("SELECT currentItems FROM members WHERE id = '"+ Integer.toString(r.getMember().getMemberID())+"'");
                      while(results.next()){
                          System.out.println(results.getString("currentItems"));
                          results.updateString("currentItems", results.getString("curremtItems")+ ", "+ r.getItem().getTitle());
                          results.updateRow();
                      }        

                      ResultSet gameQuery = stmt.executeQuery("SELECT noOfCopies FROM games WHERE id = "+Integer.toString(r.getItem().getProductID())
                              +" AND title = "+r.getItem().getTitle());
                      ResultSet videoQuery = stmt.executeQuery("SELECT noOfCopies FROM games WHERE id = "+Integer.toString(r.getItem().getProductID())
                              +" AND title = "+r.getItem().getTitle());

                      while(gameQuery.next()){
                          System.out.println(gameQuery.getInt("noOfCopies"));
                          gameQuery.updateInt("noOfCopies", gameQuery.getInt("noOfCopies") - 1);
                          gameQuery.updateRow();
                          
                      }
                      
                      while(videoQuery.next()){
                          System.out.println(videoQuery.getInt("noOfCopies"));
                          videoQuery.updateInt("noOfCopies", videoQuery.getInt("noOfCopies") - 1);
                          videoQuery.updateRow();
                      }   
                      new Utility().con.close();
	          } //end try

	          catch(ClassNotFoundException e) {
	              e.printStackTrace();
	          }

	          catch(SQLException e) {
	              e.printStackTrace();
	          }
                  returnDate = new Utility().addDays(currentDate, 3);
                  r.setReturnDate(returnDate);
                  System.out.println(r.toString());
                  return r;

	}
}