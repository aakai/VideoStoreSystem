
import java.sql.*;
import java.util.Date;



class MembershipControl{
	Employee employee; //Employee performing the membership related functionality
        MemberAccount member;
        
	MembershipControl(Employee user){
		employee = user;
                member = new MemberAccount();
        }
	
	//Renew Membership after suspension or after expiration. Expiry date is returned.
	Date renew(MemberAccount member){
		//check that all overdue payments have been made.
		if(member.getBalance() >  0){
			System.out.println("To renew membership, account balance must be paid in full.");
			return null;
		}
		
		return new Date();

	}
	
	MemberAccount createAccount(String firstName, String lastName, String streetAddress, String addressCity,
                String addressProvince, String email, int phoneNo){
            int memberID = 0;
            String dbtime;
            String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
            String dbClass = "com.mysql.jdbc.Driver";
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

                Class.forName(dbClass);
                Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
                Statement stmt = con.createStatement();

                newMemberInformation = "('"+member.getEmail()+"', '"+ member.getFirstName()+ "', '"+member.getLastName()
                        +"', '" + fullAddress+ "', "+Integer.parseInt(member.getPhoneNumber())+")";

                int rs = stmt.executeUpdate("INSERT INTO members ('email', 'FirstName', 'LastName', 'Address', 'PhoneNumber')"
                        + " VALUES" + newMemberInformation, Statement.RETURN_GENERATED_KEYS);
                ResultSet results = stmt.getGeneratedKeys();
                if (results.next()) {
                    // Retrieve the auto generated key(s).
                        memberID = results.getInt(1);
                }
                member.setMemberID(memberID);

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
	void suspend(MemberAccount member, String reason){
	
	}
	
	//pay overdue
	void payOverdue(MemberAccount member){
	
	}
	
	//add overdue charge to member account for item(s) that are yet to be returned past the return date 
	void addOverdue(MemberAccount member){
	
	}
}