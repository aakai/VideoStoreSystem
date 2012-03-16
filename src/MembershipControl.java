import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;



class MembershipControl{
	Employee employee; //Employee performing the membership related functionality
	private MemberAccount member;
        private Date today = new Date();
        private String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
        private String dbClass = "com.mysql.jdbc.Driver";
        private Connection con;
        private Statement stmt;
        
        
	MembershipControl(Employee user){
		employee = user;
 
        }
        
	MembershipControl(Employee user, MemberAccount m){
		employee = user;
                member = m;
        }	
        
	//Connect to database
        public void connect() throws ClassNotFoundException, SQLException{
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }

        
        //Renew Membership after suspension or after expiration. Expiry date is returned.
	public MemberAccount renew(MemberAccount member, Date now) throws ClassNotFoundException, SQLException{
		//check that all overdue payments have been made.
		if(member.getTotalCharge() >  0){
			System.out.println("To renew membership, account balance must be paid in full.");
                }else if((member.getStatus()=="Suspended") && now.before(member.getMembershipExpiryDate())){
			System.out.println("This member has been suspended. Member's account may be renewed "
                                + "when expiration date on account has been reached");                        
		}else{
                    member.setMembershipExpiryDate(new CustomDate().addDays(now, 365));
                    member.setStatus("Active");
                    connect();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM  members WHERE memberID = " +Integer.toString(member.getMemberID()));
                    while(rs.next()){
                         rs.updateString("Status", "Active");
                         rs.updateDate("ExpiryDate", (java.sql.Date)member.getMembershipExpiryDate());
                         rs.updateRow();
                    }
                }
                return member;
	}
	
	 public MemberAccount createAccount(String firstName, String lastName, String streetAddress, String addressCity,
            String addressProvince, String email, int phoneNo){
            int memberID = 0;
            String newMemberInformation = null;

            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setAddress(streetAddress);
            member.setCity(addressCity);
            member.setProvince(addressProvince);
            member.setEmail(email);
            member.setPhoneNumber(phoneNo);
            String fullAddress = member.getAddress()+", "+ member.getCity()+", "+ member.getProvince();
            try {
                connect();
                newMemberInformation = "('"+member.getEmail()+"', '"+ member.getFirstName()+ "', '"+member.getLastName()
                        +"', '" + fullAddress+ "', "+Integer.toString(member.getPhoneNumber())+")";

                ResultSet checkExistence = stmt.executeQuery("SELECT email FROM members WHERE email = " + member.getEmail()); 
                
                if(checkExistence.next()){
                    System.out.println(checkExistence.getString("email")+ " already exists. This member already has an account");
                }else{
                    //Member does not exist in our database, and is eligible to create new account
                    int rs = stmt.executeUpdate("INSERT INTO members ('email', 'FirstName', 'LastName', 'Address', 'PhoneNumber')"
                            + " VALUES" + newMemberInformation, Statement.RETURN_GENERATED_KEYS);
                    ResultSet results = stmt.getGeneratedKeys();
                    if (results.next()) {
                        // Retrieve the auto generated key(s).
                            memberID = results.getInt(1);
                            results.updateString("Status", "Active");
                            results.updateDate("ExpiryDate", (java.sql.Date)CustomDate.addDays(today, 365));
                            results.updateRow();
                    }
                    member.setMemberID(memberID);
                    member.setStatus("Active");
                    member.setMembershipExpiryDate(new CustomDate().addDays(today,365));
                }
                con.close();
            } //end try
            catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
            return member;
	}
	
	//Suspend privileges
	public void suspend(MemberAccount member) throws ClassNotFoundException, SQLException{
            	connect();
                member.setStatus("Suspended");
                ResultSet rs = stmt.executeQuery("SELECT * FROM members WHERE memberID = "
                        +Integer.toString(member.getMemberID()));
                while(rs.next()){
                    rs.updateString("Status", "Suspended");
                }
        }
        
	public void pay(Payment p) throws ClassNotFoundException, SQLException{
		connect();
                ResultSet rs = stmt.executeQuery("SELECT * FROM members WHERE memberID = "
                         + Integer.toString(p.getAccount().getMemberID()));
                while(rs.next()){
                    rs.updateDouble("Balance", (rs.getDouble("Balance")- p.getAmount()));
                    member.setTotalCharge(rs.getDouble("Balance")- p.getAmount());
                    rs.updateRow();
                } 
	
	}
	
	//add overdue charge to member account for item(s) that are yet to be returned past the return date 
	public double addOverDue(MemberAccount member, Rental r) throws ClassNotFoundException, SQLException{
		
		double charge = r.getCharge();
		double overdueCharge = 30.00;
                if(r.getDueDate().before(today)){
                    member.setTotalCharge(member.getTotalCharge() + overdueCharge);
                    connect();
                    ResultSet rs= stmt.executeQuery("SELECT * FROM members WHERE memberID = "+ Integer.toString(member.getMemberID()));
                    while(rs.next()){
                        rs.updateDouble("Balance", member.getTotalCharge());
                        rs.updateRow();
                    }
                }
		
		return charge;
	
	}
}