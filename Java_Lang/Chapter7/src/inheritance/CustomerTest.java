package inheritance;

public class CustomerTest {

	public static void main(String[] args) {
		
		
		 Cutsomer customerLee = new Cutsomer("이순신", 10010);
//		 customerLee.setCustomerName("이순신");
//		 customerLee.setCustomerID(10010);
		 customerLee.bonusPoint = 1000;
		 System.out.println(customerLee.showCustomerInfo());
		 
		
		
		VIPCustomer customerKim = new VIPCustomer("김유신", 10020);
//		customerKim.setCustomerName("김유신");
//		customerKim.setCustomerID(10020);
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());
		
		customerLee = customerKim; //하위클래스의 타입은 상위클래스로 자동 형 변환이 된다. (=업캐스팅) 역은 성립 안함.
	}
}
