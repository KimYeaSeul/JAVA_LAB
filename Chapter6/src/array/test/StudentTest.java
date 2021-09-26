package array.test;

public class StudentTest {

	public static void main(String[] args) {
		
		Student studentLee = new Student(100, "Lee");
		studentLee.addBook("태백산맥1", "조정래");
		studentLee.addBook("태백산맥2", "조정래");
		studentLee.showStudentInfo();
		Student studentKim = new Student(101, "Kim");
		studentKim.addBook("토지1", "박경리");
		studentKim.addBook("토지2", "박경리");
		studentKim.addBook("토지3", "박경리");
		studentKim.showStudentInfo();
		Student studentCho = new Student(102, "Cho");
		studentCho.addBook("해리포터1", "조정래");
		studentCho.addBook("해리포터2", "조정래");
		studentCho.addBook("해리포터3", "조정래");
		studentCho.addBook("해리포터4", "조정래");
		studentCho.addBook("해리포터5", "조정래");
		studentCho.addBook("해리포터6", "조정래");
		studentCho.showStudentInfo();
	}
}
