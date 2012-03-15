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
        String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
        String dbClass = "com.mysql.jdbc.Driver";
	Statement stmt;
        Connection con;
//When system is used in store by an employee
        
    
        RentControl(Date current){
		this.currentDate = currentDate;
                returnDate = new Date();
	}
        public void connect() throws ClassNotFoundException, SQLException{
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            }

	
	public Rental rent(MemberAccount member, Rental r, int rentalID, Employee employee, Item copy, int charge, Date rentalDate, Date returnDate, 
			         Date dueDate, ArrayList<String> status ){
		//Notify the system that one item copy is no longer in stock and the no of copies in stock is one less.
		
		
		//add Item to Member's list of items he/she is currently in possesion of.
		r = new Rental(rentalID, copy,  employee, member, charge, rentalDate, dueDate, returnDate, status );
	 	
	         String newRentalInformation = null;
	          try {
                      connect();

	              newRentalInformation = "('"+Integer.toString(r.getRentalId())+"', '"+ r.getEmployee().toString()+ "', '"+r.getMember().toString()
	                      +"', '" + r.getItem().toString()+"', '"+ Double.toString(r.getCharge())+ "', '" + r.getDueDate().toString()+ "', '" +
	                       r.getReturnDate().toString() + "', '" + r.getRentalDate().toString() + "', '" + r.getStatus().toString() + ")";

	              int rs = stmt.executeUpdate("INSERT INTO rental ('rentalID', 'copy', 'Employee', 'memeber', 'charge', 'rentalDate'," 
	            		  + "'dueDate','returnDate', 'status')"
	                      + " VALUES" + newRentalInformation, Statement.RETURN_GENERATED_KEYS);
	              ResultSet results = stmt.getGeneratedKeys();
	              if ( results.next() ) {
	                  // Retrieve the auto generated key(s).
	                      rentalID = results.getInt(1);
	              }
	              r.setRentalId(rentalID);
                      
                      results = stmt.executeQuery("SELECT currentItems FROM members WHERE id = "+ Integer.toString(r.getMember().getMemberID()));
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
                      con.close();
	          } //end try

	          catch(ClassNotFoundException e) {
	              e.printStackTrace();
	          }

	          catch(SQLException e) {
	              e.printStackTrace();
	          }
                  returnDate = new CustomDate().addDays(currentDate, 3);
                  r.setReturnDate(returnDate);
          return r;
	}
}