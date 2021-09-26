package test;


public class Customer {

	String name;
	String grade;
	int id;
	int bonusPoint=0;
	double bonusRatio=0;
	
	public Customer() {
		initCustomer();
	}
	
	public Customer(String name, int id) {
		this.name = name;
		this.id = id;
		
		initCustomer();
	}
	
	private void initCustomer() {
		grade = "Silver";
		bonusRatio = 0.01;
	}
	
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	public String getCustomerName() {
		return name;
	}
	
	public String showCustomerInfo() {
		return "이름 : "+ name + " 등급 : " + grade + " 포인트 : "+ bonusPoint;
	}
	
}
