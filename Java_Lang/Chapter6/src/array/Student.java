package array;

import java.util.ArrayList;

public class Student {
	
	public int studentID;
	public String name;
	ArrayList<Subject> subject;
	
	
	public Student(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
		
		// 과목생성
		subject = new ArrayList<Subject>();
	}
	
	public void addSubject(String className, int score) {
		Subject sub = new Subject(className, score);
		subject.add(sub); 
	}
	public void showStudentInfo() {
		int total = 0;
		
		for( Subject s : subject) {
			total+= s.getScore();
			System.out.println(name+ s.getClassName()+ s.getScore());
		}
		System.out.println(name+ total);
	}
	
}
