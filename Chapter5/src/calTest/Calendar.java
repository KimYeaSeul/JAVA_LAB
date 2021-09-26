package calTest;

public class Calendar {

	// 정보은닉 - 날짜의 유효성을 검증하는 프로그램 구현
	// MyDate 클래스
	//  - day, month, year 변수는 private 로 선언
	//  - 각 변수의 getter, setter를 public으로 구현
	//  - MyDate(int day, int month, int year) 생성자를 만듦
	//  - public boolean isValid() 메서드를 만들어 날짜가 유효한지 확인
	//  - MyDateTest 클래스에서 생성한 MyDate 날짜가 유효한지 확인
	public static void main(String[] args) {
		
		MyDate myDate = new MyDate(1, 9, 1994);
		myDate.getDate();
		
		MyDate myDate2 = new MyDate(0, 13, 1994);
		myDate2.getDate();
	}	
}
