package array.test;

public class Book {
	
	public String bookName;
	public String author;
	
	public Book() {	}

	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	public String getbookName() {
		return bookName;
	}
	
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
