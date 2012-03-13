
import java.util.Date;



public class RentControl{
	private Employee employee;
	private Date currentDate;
	private Date receiptDate;//Date that the user at home would receive his/her item
	
//When system is used in store by an employee
	RentControl(Employee user, Date current){
		employee = user;
		currentDate = current;
		receiptDate = currentDate;
	}

//When system is used by the user online	
	RentControl(Date current){
		currentDate = current;
		receiptDate = currentDate+ 2;//The item is to have been delivered within 2 days of makin rental request.
	}
	
	Date rent(MemberAccount member, Item copy){
		//Notify the system that one item copy is no longer in stock and the no of copies in stock is one less.
		copy.removeCopyfromshelf();
		
		//add Item to Member's list of items he/she is currently in possesion of.
		member.addRentedItemToCurrentItemList(copy);
		
		// Record that this employee took care of the defined member's request, in the case of any enquiries in the future
		employee.recordTransaction(member, copy);
		
		return (currentDate + 3);// return date is after 3 days from current date.
	}
}