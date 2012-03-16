import java.math.BigDecimal;
import java.util.Date;


public class Payment {
	
	private Employee employee;
	private MemberAccount account;
	private Item [] paidItems;
	private double amount;
	private Date paymentDate;
	private int index;
	private boolean isPaid;
  
	
	public Payment() { 
            amount = 0;
        }

	public Payment(double amount) {
            this.amount = amount;
          }

        public Payment(double amount, Employee employee, MemberAccount member, Date date) {
            this.amount = amount;
            this.employee= employee;
            this.account = member;
            paymentDate = date;
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