package cardTest;

public class CardCompany {

	private static CardCompany instance = new CardCompany(); // 자기자신의 타입을 가진 변수
	
	private CardCompany() {} ; // 내부에서 쓸수 있는 생성자
	
	// 외부에서 가져다 쓰기 위해서 static 으로 선언
	public static CardCompany getInstance() {
		if(instance == null) instance = new CardCompany();
		return instance;
	}
	
	public static void setInstance(CardCompany instance) {
		CardCompany.instance = instance;
	}

	public Card createCard() {
		Card card = new Card();
		return card;
	}

	
	
}
