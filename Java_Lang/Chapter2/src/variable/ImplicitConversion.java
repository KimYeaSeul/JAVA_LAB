package variable;

public class ImplicitConversion {

	public static void main(String[] args) {
		
		// 1: 묵시적 형 변환 byte (1byte) => int(4byte) 
		
		byte bNum = 10;
		int iNum = bNum;
		
		System.out.println(bNum);
		System.out.println(iNum);
		
		// 2: 정수를 실수에 대임 실수형이 표현범위가 넓어서 문제 없음
		
		int iNum2 = 20;
		float fNum = iNum2;

		System.out.println(fNum);
		
		// 3: 형변환 계산
		
		double dNum;
		dNum = fNum + iNum; 
		// int형 iNum이 fNum과 계산하기 위해서 float 형으로 변환
		// 그 후 dNum에 대입하기 위해서 float에서 double형으로 계산 결과값 변환
		
		System.out.println(dNum);
		
	}

}
