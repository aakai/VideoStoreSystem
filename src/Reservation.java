
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
class Reservation {

    private int reservationId;
    private Date pickUpDate; // pick the item that you reserved
    private Date reservationDate; // date reservation was made
    private Item item;
    private MemberAccount earliestMember;
    private boolean isReserved = true;

	
	
    public Reservation(int id, Date pickUp, Date reservationDate) {
			
		this.reservationId = id;
		pickUpDate = pickUp;
		this.reservationDate = reservationDate;

}

    public void setPickUpDate(Date pickUpDate) {
            this.pickUpDate = pickUpDate;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }


    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public boolean getReservationStatus() {
        return isReserved;
    }

    public void changeReservationStatus() {
        if(isReserved == false){
			isReserved = true;
		}else{
			isReserved = false;
		}			
    }


	public Item getItem() {
		return item;
	}

	public void setEarliestMember(MemberAccount member) {
		earliestMember = member;
	}


	public ArrayList<MemberAccount> getWaitingList() {
		return item.membersReserving;
	}


	public MemberAccount getEarliestMemeber() {
		return earliestMember;
	}
   
}
