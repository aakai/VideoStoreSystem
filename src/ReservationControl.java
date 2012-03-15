import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class ReservationControl{
	private Reservation r;
	
	ReservationControl(){
            r = null;
	}
	
        public Reservation makeReservation(Item item, MemberAccount member, int reservationID, Date pickUpDate, Date reservationDate ){


            r = new Reservation(reservationID, pickUpDate, reservationDate, item, member);
           
            String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
            String dbClass = "com.mysql.jdbc.Driver";

	    if(item.getNoOfCopies() > 0){
			System.out.println("There is a copy of this item available. No need to make a reservation. YOU MAY RENT NOW.");
			
	    }else{
		
                String newReservationInformation = null;
                try {
                      Class.forName(dbClass);
                      Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
                      Statement stmt = con.createStatement();

                      newReservationInformation = "('"+Integer.toString(r.getReservationId())+"', '"+ r.getPickUpDate().toString()+ "', '"+r.getReservationDate().toString()
                              +"', '" + r.getItem().getProductID()+"', '"+ member.getMemberID()+")";

                      int rs = stmt.executeUpdate("INSERT INTO reservation ('reservationID', 'pickUpDate', 'reservationDate', 'itemID', 'member')"
                              + " VALUES" + newReservationInformation, Statement.RETURN_GENERATED_KEYS);
                      ResultSet results = stmt.getGeneratedKeys();
                      if ( results.next() ) {
                          // Retrieve the auto generated key(s).
                              reservationID = results.getInt(1);
                      }
                      r.setReservationId(reservationID);

                      con.close();
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
	
	
	public void cancelReservation(Item item, MemberAccount member, int reservationID, Date pickUpDate, Date reservationDate){
		 r = new Reservation(reservationID, pickUpDate, reservationDate,item ,member);

                 String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
                 String dbClass = "com.mysql.jdbc.Driver";

                 try {

                      Class.forName(dbClass);
                      Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
                      Statement stmt = con.createStatement();
                      int delete = stmt.executeUpdate("DELETE FROM reservation WHERE reservationID = " + r.getReservationId());
                      if (delete == 1) {
                          // Retrieve the auto generated key(s).
                          System.out.println("Delete complete");
                      } else{
                          System.out.println("Row is not deleted.");
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