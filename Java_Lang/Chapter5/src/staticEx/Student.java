package staticEx;

public class Student {
	
	// static 변수
	private static int serialNum = 1000;
	
	public int studentID;
	public String studentName; // 문자열 표현 java class = char array
	public String address;
	
	public Student(String name) {
		studentName = name;
		serialNum++;
		studentID = serialNum;
	}
	
	public Student(int id, String name) { // overloading
		studentID=id;
		studentName = name;
		address = "주소없음";
		serialNum++;
		studentID = serialNum;
	}
	
	public void showStudentInfo() {
		System.out.println(studentName + ","+ address);
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	// static method = class method
	public static int getSerialNum() {
//		int i = 0; // 지역변수, stack Mem
//		studentName = "aaa"; // static 변수, data Mem, 인스턴스변수 사용 불가, 인스턴스가 생성되어야 생기는 변
		return serialNum;
	}
	
	public static void setSeralNum(int serialNum) {
		Student.serialNum = serialNum;
	}
}

