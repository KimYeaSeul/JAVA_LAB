package array;

public class Test {
 // A-Z까지 배열에 저장하고 이를 다시 출력하는 프로그램 만들기
	public static void main(String[] args) {
		
		char ch='A';
		char[] eng = new char[26];
		
		for(int i = 0; i<eng.length; i++) {
			eng[i] = ch++;
			System.out.println(eng[i]);		
		}
		
		
	}
}