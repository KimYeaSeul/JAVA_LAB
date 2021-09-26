package cooperation;

public class Subway {
	
	int lineNumber;
	int passengerCount;
	int money;
	
	// 생성
	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	// 승차 메소드
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void showSubwayInfo() {
		System.out.println(lineNumber+"번 지의 승객은" + passengerCount+" 명 이고 수입은 " + money +"입니다.");
	}
}
