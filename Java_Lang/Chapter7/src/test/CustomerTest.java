package test;

import java.util.ArrayList;

public class CustomerTest {

	// 고객은 현재 5명입니다. VIP 1명, Gold 2명, Silver 2 일 떄, 
	// 각 고객이 만원짜리 제품을 구매한 경우 지불한 금액과 적립된 보너스 포인트를 출력해보세요
	// ArrayList를 활용하여 구현
	
	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
	
		 Customer customerLee = new Customer("이순신", 10010); // 100
		 Customer customerShin = new Customer("신사임당", 10020);
		 Customer customerHong = new GoldCustomer("홍길동", 10030); // 200
		 Customer customerYul = new GoldCustomer("이율곡", 10040);
		 Customer customerKim = new VIPCustomer("김유신", 10050, 12345); // 500
		 
		 customerList.add(customerLee);
		 customerList.add(customerShin);
		 customerList.add(customerHong);
		 customerList.add(customerYul);
		 customerList.add(customerKim);
		 
		 System.out.println("====== 고객 정보 출력 ======");
		 
		for( Customer customer : customerList) {			
			System.out.println(customer.showCustomerInfo());
		}
		 
		System.out.println("====== 할인율과 보너스 포인트 계산 ======");
		
		int price = 10000;
		for (Customer customer : customerList) {
			int cost = customer.calcPrice(price);
			System.out.println(customer.getCustomerName() + "님이 " + cost + "원 지불하셨습니다.");
			System.out.println(customer.getCustomerName() + "님의 현재 보너스 포인트는 " + customer.bonusPoint + "점 입니다.");
		}
	}
}
