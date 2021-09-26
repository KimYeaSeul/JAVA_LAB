package array.test;

import java.util.ArrayList;

public class Student {

	public int studentId;
	public String name;
	ArrayList<Book> book;
	public int index=0;

	public Student(int studentId, String name) {
		this.studentId = studentId;
		this.name = name;
		
		book = new ArrayList<Book>();
		
	}
	
	public void addBook(String bookName, String author) {
		Book book1 = new Book(bookName, author);
		book.add(book1);
		index++;
	}
	
	public void showStudentInfo() {
		System.out.print(name + " 학생이 읽은 책은 ");
		for(Book b : book) {
			System.out.print(b.getbookName()+" ");
		}
		System.out.println("입니다. 총 " +index+"권");
	}
	
	

}
