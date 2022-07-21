package test;

public class GoldCustomer extends Customer{

	double salesRatio = 0;
	
	public GoldCustomer(String name, int id) {
		super(name, id);

		grade = "Gold";
		bonusRatio = 0.02;
		salesRatio = 0.1;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}

	
}
