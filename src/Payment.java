import java.math.BigDecimal;
import java.util.Date;


/** an abstract class representing a payment of some kind */

abstract public class Payment {
	
	private Employee employee;
	private MemberAccount account;
	private Item [] paidItems;
	private double amount;
	private Date paymentDate;
	private int index;
	private boolean isPaid;
  
	
	public Payment() { }

	public Payment(double amount) {
            this.amount = amount;
          }

        public double getAmount() {
            return amount;
         }
	
	public Date getPaymentDate(){
		return paymentDate;
	}
	
	public int getItemIndex(){
		return index;
	}
	
	public void setPaidTrue() {
		isPaid = true;
  }
  
	public boolean getIsPaid(){
		return isPaid;
	}


	public Employee getEmployee() {
		return employee;
	}


	public MemberAccount getAccount() {
		return account;
	}

	public void setPaidItems(Item [] paidItems) {
		this.paidItems = paidItems;
	}

	public Item [] getPaidItems() {
		return paidItems;
	}

  
}