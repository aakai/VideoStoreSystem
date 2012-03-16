import java.math.BigDecimal;


public class CashPayment extends Payment {

  private double amountTendered;

  public CashPayment() {
    super();
  }

  public CashPayment(double amount) {
    super(amount);
  }

  public double getAmountTendered() {
    return amountTendered;
  }

  public void setAmountTendered(double amountTendered) {
    this.amountTendered = amountTendered;
  }

  public double calcChange() {
    return (amountTendered - super.getAmount());
  }
}