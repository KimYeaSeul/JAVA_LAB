package test;

public class VIPCustomer extends Customer{


	double salesRatio = 0;
	int agentNum;

	public VIPCustomer(String name, int id, int agentNum) {
		super(name, id);
		this.agentNum = agentNum;

		grade = "VIP";
		bonusRatio = 0.1;
		salesRatio = 0.2;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * salesRatio);
	}
	
	@Override
	public String showCustomerInfo() {
		return "이름 : "+ name + " 등급 : " + grade + " 포인트 : "+ bonusPoint + " 고객상담번호 "+ agentNum;
	}

}