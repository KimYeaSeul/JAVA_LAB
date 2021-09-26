package staticEx;

public class StudentIDTest {

	public static void main(String[] args) {
		Student studentLee = new Student("Lee");
		System.out.println(Student.getSerialNum()); //1001, 클래스이름으로 참조하기 떄문에 단독 사용 가능, 보통 private로 사용
		
		Student studentKim = new Student("Kim"); 
		System.out.println(Student.getSerialNum()); // 1002
		System.out.println(Student.getSerialNum()); // 1002 인스턴스가 2개 생성되어따는
		
		System.out.println(studentKim.getStudentID());
		System.out.println(studentLee.getStudentID());
		
	}
}
