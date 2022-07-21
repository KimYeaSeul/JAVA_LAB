package polymorphism;

public class GoldCustomer extends Cutsomer{
	
	double salesRatio;

	public GoldCustomer(String customerName, int customerID) {
		super(customerName, customerID);
		customerGrade = "GOld";
		bonusRatio = 0.02;
		salesRatio = 0.1;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}


}
