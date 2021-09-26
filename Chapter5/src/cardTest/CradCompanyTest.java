package cardTest;

public class CradCompanyTest {

	public static void main(String[] args) {

		// 카드회사는 유일한 객체이고 이 회사에서 카드를 발급하면 항상 고유번화 자동으로 생성됨
		// 10001부터 시작하여 카드가 생성될 때 마다 10002, 10003 식으로 증가
		
		CardCompany company  = CardCompany.getInstance(); // singleton pattern
		
		Card myCard = company.createCard();
		Card yourCard = company.createCard();
		
		System.out.println(myCard.getCardNumber());  // 10001
		System.out.println(yourCard.getCardNumber());  // 10002

	}

}
