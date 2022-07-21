package cooperation;

public class Student {

	String studentName;
	int grade;
	int money;
	
	// 초기화 하기 위한 생성
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	// 객체협업
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}
	
	public void takeSubway(Subway subway) { // 어떤 지하철을탈지 매개변수로 지정하고.. 이미 지하철은.. 생성되어 있따..
		subway.take(1200);
		this.money -= 1200;
	}
	
	public void takeTexi(Texi texi, int charge) {
		texi.take(charge);
		this.money -= charge;
	}
	
	public void showInfo() {
		System.out.println(studentName + "님의 남은 돈은 " + money+ "원 입니다.");
	}
}
