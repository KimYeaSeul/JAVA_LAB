package oop;

public class Student {
	
	public int studentID;
	public String studentName; // 문자열 표현 java class = char array
	public String address;
	
	
	public void showStudentInfo() {
		System.out.println(studentName + ","+ address);
	}
	
	public String getStudentName() {
		return studentName;
	}
}

