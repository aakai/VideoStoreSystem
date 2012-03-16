

public class CreditCardPayment extends Payment {
	
	 private String cardNumber;
	 private boolean authorized;
  public CreditCardPayment() {
  }

  public CreditCardPayment(double amount) {
    super(amount);
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public boolean authorize() {
    return authorized; 
  }

 
}

