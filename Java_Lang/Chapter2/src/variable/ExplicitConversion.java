package variable;

public class ExplicitConversion {

	public static void main(String[] args) {
		
		// 1 : 명시적 형 변환 
		
		int i = 1000;
		byte bNum = (byte)i; // -24 : 데이터의 유실 발생 byte = -128~127
		System.out.println(bNum);
		
		double dNum1 = 1.2;
		float fNum = 0.9F;
		
		// 2 : Truncate 발생..
		
		int iNum1 = (int)dNum1 + (int)fNum; // 1 + 0
		int iNum2 = (int)(dNum1 + fNum); // 1.2 + 0.9
		
		System.out.println(iNum1); // 1
		System.out.println(iNum2); // 2
	}

}
