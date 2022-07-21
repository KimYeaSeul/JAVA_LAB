package oop;

public class OrderTest {

	long orderId;
	String userId;
	String orderDate;
	String userName;
	String itemNum;
	String userAdd;

	public void showOrderInfo() {
		System.out.println("주문 번호 : " + orderId);
		System.out.println("주문자 아이디 : " + userId);
		System.out.println("주문 날짜 : " + orderDate);
		System.out.println("주문자 이름 : " + userName);
		System.out.println("주문 상품 번호 : " + itemNum);
		System.out.println("배송 주소 : " + userAdd);
	}
	
}
