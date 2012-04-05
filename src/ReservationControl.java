import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class ReservationControl{
	private Reservation r;    
        private String dbUrl = "jdbc:mysql://localhost:3306/sourceit_vss";
        private String dbClass = "com.mysql.jdbc.Driver";
	
	ReservationControl(){
            r = null;
	}
	
        public Reservation makeReservation(Item item, MemberAccount member, int reservationID, Date pickUpDate, Date reservationDate, String type){
            r = new Reservation(reservationID, pickUpDate, reservationDate, item, member);
            r.setType(type);
	    if(item.getNoOfCopies() > 0){
			System.out.println("There is a copy of this item available. No need to make a reservation. YOU MAY RENT NOW.");
			
	    }else{
		
                String newReservationInformation = null;
                try {
                      new Utility().connect();
                      newReservationInformation = "('"+ r.getReservationDate().toString()+ "', '"+r.getPickUpDate().toString()
                              +"', '"+ Integer.toString(member.getMemberID())+"', '"+Integer.toString(r.getItem().getProductID())
                              +"', '"+ r.getType()+"')";

                      int rs = new Utility().stmt.executeUpdate("INSERT INTO reservations ('reservationDate', 'pickUpDate',  'MemberID', 'itemNo', 'itemType')"
                              + " VALUES" + newReservationInformation, Statement.RETURN_GENERATED_KEYS);
                      ResultSet results = new Utility().stmt.getGeneratedKeys();
                      if (results.next()) {
                          // Retrieve the auto generated key(s).
                          results.updateInt("id", results.getInt(0));    
                          reservationID = results.getInt(0);
                              
                      }
                      r.setReservationId(reservationID);

                      new Utility().con.close();
                  } //end try

                  catch(ClassNotFoundException e) {
                      e.printStackTrace();
                  }

                  catch(SQLException e) {
                      e.printStackTrace();
                  }
          }
          return r;
       }
	
	
	public void cancelReservation(MemberAccount member, int reservationID){
//		 r = new Reservation(reservationID, pickUpDate, reservationDate,item ,member);
                 try {
                      new Utility().connect();
                    //  Statement stmt = Utility.con.createStatement();
                      int delete = new Utility().stmt.executeUpdate("DELETE FROM reservation WHERE reservationID = " + r.getReservationId());
                      if (delete == 1) {
                          // Retrieve the auto generated key(s).
                          System.out.println("Delete complete");
                      } else{
                          System.out.println("Row is not deleted.");
                       }

                      new Utility().con.close();
                  } //end try

                  catch(ClassNotFoundException e) {
                      e.printStackTrace();
                  }

                  catch(SQLException e) {
                      e.printStackTrace();
                  }
            }
}