package variable;

public class DoubleTest {
	
	public static void main(String[] args) {
		
		// Test1 
		
		double dNum = 3.14; // double literal : 8byte
		float fNum = 3.14f; // Type Casting : 4byte : Add Identifier
		
		System.out.println(dNum);
		System.out.println(fNum);
		
		// Test2 :Floating point(부동소수점) 오류 
		
		double dNum2 = 1;
		
		for(int i=0; i < 10000; i++) {
			dNum2 = dNum2 + 0.1;
		}
		
		System.out.println(dNum2); // Occur error : 1001.000000000159
		
		// Test3 : Boolean Type
		
		boolean isMarried = false;
		
		System.out.println(isMarried);
		
		// 지역 변수 자료형 추론(local variable type inference)
		// 자료형 없이 변수 사용하기 (자바10이상) - 변수에 대입되는 값을 보고 컴파일러가 추론
		
	}

}
