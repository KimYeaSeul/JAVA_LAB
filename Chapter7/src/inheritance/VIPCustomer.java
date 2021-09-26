package inheritance;

public class VIPCustomer extends Cutsomer {
	
	
	double salesRatio;
	private int agentID;
	
	/*
	public VIPCustomer() {
		customerGrade = "VIP"; // private 변수 접근 불가, protected로 수정
		bonusRatio= 0.05;
		salesRatio= 0.1;
		System.out.println("VIPCustomer() 생성자 호출");
	}
	*/
	// 상위클래스 생성자에 매개변수가 있는경우
	public VIPCustomer(String customerName, int customerID) {
		super(customerName, customerID);
		customerGrade = "VIP";
		bonusRatio= 0.05;
		salesRatio= 0.1;
		System.out.println("VIPCustomer() 생성자 호출");
	}
	
	// overriding, 재구현

	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}
	
}
