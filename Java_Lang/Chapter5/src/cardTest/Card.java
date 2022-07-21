package cardTest;

public class Card {

	private static int serialNum = 10000;
	public int cardNum=0;
	
	public Card() {
		cardNum = serialNum;
		serialNum++;
	}
	
	public int getCardNumber() {
		return cardNum;
	}
	
	public void setCardNumber(int cardNum) {
		this.cardNum = cardNum;
	}
	
}
