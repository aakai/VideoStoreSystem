
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
class MemberAccount {
    
    /*******************
     * PROPERTIES
     *******************/
    private String name;			// the name 
    private int memberID;			//the ID.
    private double totalCharge;		        // the total amount the AccountMember has been charged throughout
    private Date membershipExpiryDate;
    private String FirstName;
    private String LastName;
    private String address;
    private String province;
    private String PostalCode;
    private String city;
    private long phoneNumber;
    private String email;
    private Item[] currentItems;
    private Item[] pastItems;
    private Reservation[] reservations = new Reservation[10];
    private int reserveCount = 0;
    private String status;//may be {suspended, expired, active}

    /*******************
     * CONSTRUCTOR(S)
     * @param id 
     * @param familyName 
     * @param address 
     * @param zipCode 
     * @param City 
     * @param phone 
     * @param email 
     * @param PostalCode 
     *******************/
    public MemberAccount(String name, int id, String familyName, String address, int zipCode,
            String City, long phone, String email, String PostalCode) {
    	this.setMemberID(id);
        this.setLastName(familyName);
        this.setAddress(address);
        this.setPostalCode(PostalCode);
        this.setCity(City);
        this.setPhone(phone);
        this.setEmail(email);
        this.setFirstName(name);
        this.totalCharge = 0;
    }

    MemberAccount(int id, String firstName, String familyName, String email, long phone) {
        this.memberID = id;
        this.FirstName = firstName;
        LastName = familyName;
        this.email = email;
        this.phoneNumber = phone;
        
    }
 
    MemberAccount(){
        
    }
    
    /*******************
     * Get/set Methods
     *******************/   

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }


    // toString()
        public String toString() {
            String str = "AccountMember Name: " + this.FirstName + " "+ this.LastName;
            str += "\nTotal Charge: " + this.totalCharge;
            str += "\nMember ID" + this.memberID;
            str += "\n Address" + this.address + ", "+this.city +", "+this.province+  ". "+ this.PostalCode;
            str+= "\nPhone Number"+Long.toString(this.phoneNumber);


            return str;
        }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

        public void setProvince(String addressProvince) {
            province = addressProvince;
        }
        
        public String getProvince(){
            return province;
        }

        
	public long getPhone() {
		return phoneNumber;
	}

	public void setPhone(long phone) {
		this.phoneNumber = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMembershipExpiryDate(Date membershipExpiryDate) {
		this.membershipExpiryDate = membershipExpiryDate;
	}

	public Date getMembershipExpiryDate() {
		return membershipExpiryDate;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void addReservations(Reservation reservation) {
		this.reservations[reserveCount] = reservation;
                reserveCount++;
	}

        public void setReservations(Reservation [] reservations){
            this.reservations = reservations;
            reserveCount = reservations.length;
        } 
        
	public Reservation[] getReservations() {
		return reservations;
	}
        
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setCurrentItems(Item [] currentItems) {
		this.currentItems = currentItems;
	}

	public Item [] getCurrentItems() {
		return currentItems;
	}

	public void setPastItems(Item [] pastItems) {
		this.pastItems = pastItems;
	}

	public Item [] getPastItems() {
		return pastItems;
        }
        
        public String getStatus() {
            return status;
        }

        public void setStatus(String string) {
            if((string.equalsIgnoreCase("Active"))||(string.equalsIgnoreCase("Expired"))||
                    (string.equalsIgnoreCase("Suspended"))){
                status = string;
            }else{
                System.err.println("Status entered is invalid. Entry ==>" + string);
            }
        }

 
}
