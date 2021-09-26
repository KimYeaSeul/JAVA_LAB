package inheritance;

public class OverrideingTest {

	public static void main(String[] args) {

		 Cutsomer customerLee = new Cutsomer("이순신", 10010);
		 customerLee.bonusPoint = 1000;
		
		VIPCustomer customerKim = new VIPCustomer("김유신", 10020);
		customerKim.bonusPoint = 10000;

		int priceLee = customerLee.calcPrice(10000);
		int priceKim = customerKim.calcPrice(10000);
		
		System.out.println(customerLee.showCustomerInfo() + "지불금액은 "+priceLee+"원 입니다.");
		System.out.println(customerKim.showCustomerInfo() + "지불금액은 "+priceKim+"원 입니다.");
		
		Cutsomer customerNo = new VIPCustomer("몰라", 10030);
		customerNo.bonusPoint = 10000;
		// 가상함수(가상메서드) 인스턴스의 메서드가 보임.
		// 메서드의 이름과 메서드 주소를 가진 가상 메서드 테이블에서 호출될 메서드의 주소를 참조함
		System.out.println(customerNo.showCustomerInfo() + "지불금액은 "+customerNo.calcPrice(10000)+"원 입니다.");
		
			
		
	}

}
