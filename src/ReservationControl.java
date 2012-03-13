

public class ReservationControl{
	private Employee employee; //Employee using the system at the counter
	
	ReservationControl(Employee user){
		employee = user;
	}
	
	Reservation makeReservation(Item item, MemberAccount member){
		if(item.getNoOfCopies() > 0){
			System.out.println("There is a copy of this item available. No need to make a reservation. YOU MAY RENT NOW.");
			return null;
		}
		
		return member.reserve(item);// member reserving defined item and the reservation details are returned.
	}
	
	int cancelReservation(MemberAccount member, Reservation reservation){
			
		return reservation.remove(member);
	}
	
	
	
}