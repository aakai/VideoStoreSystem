

public class ReservationControl{

    private Employee employee; //Employee using the system at the counter
    private Reservation reservation;
    
    ReservationControl(Employee user){
            employee = user;
    }

    int makeReservation(Item item, MemberAccount member){
            if(item.getNoOfCopies() > 0){
                    System.out.println("There is a copy of this item available. No need to make a reservation. YOU MAY RENT NOW.");
                    return 0;
            }

            return reservation.getReservationId();// member reserving defined item and the reservation details are returned.
    }

    void cancelReservation(MemberAccount member, int reservationID){

            return;
    }

}