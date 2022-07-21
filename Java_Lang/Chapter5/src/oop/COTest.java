package oop;

public class COTest {

	public static void main(String[] args) {
	// Class-Object Test
	
	Person man = new Person();
	man.age = 40;
	man.name = "james";
	man.isMarried = true;
	man.numberOfChildern = 3;
	
//	man.showPersonInfo();

	// 쇼핑몰
	OrderTest order = new OrderTest(); // 인스턴스화, 생성자는 클래스 이름과 동일하게
	order.orderId = 20210912001L;
	order.userId = "adgjl3151";
	order.orderDate = "2021년 9월 12일";
	order.userName = "김예슬";
	order.itemNum = "12354dfdo";
	order.userAdd = "서울";
	
	order.showOrderInfo();
	}
}
