import java.util.ArrayList;
import java.util.Date;


public class Rental {
	
	private int RentalId;
	private Item item;
	private Employee employee;
	private MemberAccount member;
	private int charge;
	private Date RentalDate;
	private Date DueDate;
	private Date ReturnDate;
	private ArrayList<String> Status;
	
	
	
	
	public Rental(int rentalId, Item item, Employee employee,
			MemberAccount member, int charge, Date rentalDate, Date dueDate,
			Date returnDate, ArrayList<String> status) {
		
		RentalId = rentalId;
		this.item = item;
		this.employee = employee;
		this.member = member;
		this.charge = charge;
		RentalDate = rentalDate;
		DueDate = dueDate;
		ReturnDate = returnDate;
		Status = status;
	}

	public void setRentalId(int rentalId) {
		RentalId = rentalId;
	}
	public int getRentalId() {
		return RentalId;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Item getItem() {
		return item;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setMember(MemberAccount member) {
		this.member = member;
	}
	public MemberAccount getMember() {
		return member;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getCharge() {
		return charge;
	}
	public void setRentalDate(Date rentalDate) {
		RentalDate = rentalDate;
	}
	public Date getRentalDate() {
		return RentalDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setReturnDate(Date returnDate) {
		ReturnDate = returnDate;
	}
	public Date getReturnDate() {
		return ReturnDate;
	}
	public void setStatus(ArrayList<String> status) {
		Status = status;
	}
	public ArrayList<String> getStatus() {
		return Status;
	}

}