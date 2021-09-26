package hiding;

public class MyDate {

	private int day;
	private int month;
	private int year;
	
	// 정보보호 측면, 데이터 핸들링 측면에서 사용
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void showDate() {
		System.out.println(year + "년 " + month + "월 " +day + "일");
	}
}
