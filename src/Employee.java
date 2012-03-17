
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import javax.swing.*;

public class Employee {
    /*******************
     * PROPERTIES
     *******************/

    private int id;
    private String password;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String province;
    private int phoneNumber;
    private String email;
    private String status ;    
    private int numberOfRecords;
    private Reservation[] r;
    private Date today = new Date();
    private Payment p;
    private double totalAmount;
    private boolean isAdmin;

    private ArrayList<MemberAccount> AccountMembers;

    /*******************
     * CONSTRUCTOR(S)
     *******************/

    public Employee(Game[] vg, Video[] m, int id, String address, int phone, String email) {
        this.address = address;
        this.phoneNumber = phone;
        this.id = id;
        this.email = email;
        AccountMembers = new ArrayList<MemberAccount>();
		isAdmin = false;
    }
	
    public Employee(int employeeId,  String pass){
        id = employeeId;
        password = pass;
    }
    /*******************
     * AccountMember add
     *******************/
  
  
    
	////////////////////////////////////setters and getters/////////////////////////
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

     public boolean IsAdmin() {
         return isAdmin;
    }
     public void setIsAdmin(boolean admin){
         isAdmin = admin;
     }

}
