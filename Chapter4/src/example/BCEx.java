package example;

public class BCEx {
	
	public static void main(String[] args) {
		
		// Break-Countinue Practics
	
		// 1 : break
		/*
		int sum = 0;
		int num = 1;
		for( num = 1; ; num++) {
			sum += num;
			if(sum >=100) break; // 조건이 맞으면 수행문을 빠져나
			// System.out.println(num);
		}
		
		System.out.println(sum);
		System.out.println(num);
		*/
		
		// 2 : continue
		/*
		int num;
		for(num = 1; num <= 100; num++) {
			if(num%3 !=0) continue; // 조건이 맞으면 더이상 수행하지 않고올라감
			System.out.println(num);
		}
		*/
		
		// 3 : break-continue GuGuDan
		// Condition1 : 짝수 단만 출력
		// Condition2 : 단보다 곱하는 수가 작거나 같을 때까지만 출력
		
		int dan;
		int count;
		
		for(dan = 2; dan<=9; dan++) {
			if(dan%2 != 0) continue;
			System.out.println(dan + "단");
			count = 1;
			for(count = 1; count<=9; count++) {
				if(dan < count) break;
				System.out.println(dan +" X "+ count +" = "+ count*dan);
			}
			System.out.println();
		}
	}
}
