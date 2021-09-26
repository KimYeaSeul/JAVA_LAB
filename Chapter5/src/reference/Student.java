package reference;

public class Student {

		// 참조 자료형
	
	int studentID;
	String studentName;
	
	Subject korea; // 참조 자료형 타입 변수 선
	Subject math;
	
	public Student(int id, String name) { // 생성자에서 초기화
		
		studentID = id;
		studentName = name;
		
		korea = new Subject();
		math = new Subject();
		
	}
	
	public void setKoreaSubject(String name, int score) { // 필요한 메서드 추가
		korea.subjectName = name;
		korea.score = score;
	}
	
	public void setMathSubject(String name, int score) {
		math.subjectName = name;
		math.score = score;
	}
	
	public void showStudentScore() {
		int total = korea.score + math.score;
		System.out.println(studentName + "학생의 점은 " + total);
	}
}
