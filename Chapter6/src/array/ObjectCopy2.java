package array;

public class ObjectCopy2 {

	public static void main(String[] args) {

		Book[] library = new Book[5];
		Book[] copyLibrary = new Book[5];
		
		library[0] = new Book("태백산맥1", "조정래");
		library[1] = new Book("태백산맥2", "조정래");
		library[2] = new Book("태백산맥3", "조정래");
		library[3] = new Book("태백산맥4", "조정래");
		library[4] = new Book("태백산맥5", "조정래");
		
//		System.arraycopy(library, 0, copyLibrary, 0, 5); // 얕은 복사
		// 깊은 복사를 위해 객체를 만들고 일일이 대입
		copyLibrary[0] = new Book();
		copyLibrary[1] = new Book();
		copyLibrary[2] = new Book();
		copyLibrary[3] = new Book();
		copyLibrary[4] = new Book();
		
		for(int i=0; i<library.length; i++) {
			copyLibrary[i].setTitle(library[i].getTitle());
			copyLibrary[i].setAuthor(library[i].getAuthor());
		}
		
		//copyLibrary 에 영향 없음요
		library[0].setTitle("나무");
		library[0].setAuthor("박완서");
		
		// 향상된 for문
		for( Book book : library) {
			book.showBookInfo();
		}
		
		System.out.println("========");
		
		for(Book book : copyLibrary) {
			book.showBookInfo();
		}
		
	}

}
