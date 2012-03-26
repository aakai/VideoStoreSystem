
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
    private String FirstName;
    private String LastName;
    private String address;
    private String postalCode;
    private String city;
    private String province;
    private int phoneNumber;
    private String email;
    private String status ;    
    private Date today = new Date();
    private boolean isAdmin;

    /*******************
     * CONSTRUCTOR(S)
     *******************/

    public Employee(int id, String address, int phone, String email) {
        this.address = address;
        this.phoneNumber = phone;
        this.id = id;
        this.email = email;
        isAdmin = false;
    }

    public Employee(int id, String address, int phone, String email, boolean admin) {
        this.address = address;
        this.phoneNumber = phone;
        this.id = id;
        this.email = email;
        isAdmin = admin;
    }    
    
    public Employee(int id, String address, int phone, String email, boolean admin, String status) {
        this.address = address;
        this.phoneNumber = phone;
        this.id = id;
        this.email = email;
        isAdmin = admin;
        this.status = status;
    }    
    
    public Employee(int employeeId,  String pass){
        id = employeeId;
        password = pass;
    }
    
    public Employee(){
        
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
	
	public void setFirstName(String name) {
		this.FirstName = name;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setLastName(String name) {
		this.LastName = name;
	}

	public String getLastName() {
		return LastName;
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
