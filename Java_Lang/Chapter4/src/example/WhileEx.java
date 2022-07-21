package example;

import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		
		/*
		int num = 1;
		int sum = 0;
		
		// 1 : while Ex
		
		while( num <= 10) {
			sum += num;
			num++;			
		}
		
		// 2 : do-while Ex
		
		do {
			sum += num;
			num++;
		}while(num<=10);
		
		
		System.out.println(sum);
		System.out.println(num);
		*/
		
		Scanner scanner = new Scanner(System.in);
		int input;
		int sum = 0;
		
		// 1 : while
		
//		input = scanner.nextInt();
//		while(input != 0) {
//			sum += input;
//			input = scanner.nextInt();
//		}
		
		// 2 : do-while
		
		do {
			input = scanner.nextInt();
			sum += input;
		}while(input != 0);
		
		System.out.println(sum);
	}
}
