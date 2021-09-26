package example;

import java.util.Scanner;

public class LastTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		/*
		// Q1 : 연산자와 두 수를 변수로 선언한 후 사칙연산이 수행 되는 프로그램을 만들어 보세요
		//      if-else, switch-case 두 방식 모두 구현
		
		
		System.out.println("Insert Operator : ");
		char op = scanner.next().charAt(0);
		int num1 = 10;
		int num2 = 5;
		int val = 0;
		
		
		// if-else
		if(op == '+') { val = num1 + num2; }
		else if(op == '-') { val = num1 - num2; }
		else if(op == '*') { val = num1 * num2; }
		else if(op == '/') { val = num1 / num2; }
		else { System.out.println("Not OP"); }
		
		
		// switch-case 
		switch(op) {
			case '+':
				val = num1 + num2;
				break;
			case '-':
				val = num1 - num2;
				break;
			case '*':
				val = num1 * num2;
				break;
			case '/':
				val = num1 / num2;
				break;
		}
		System.out.println(""+num1+op+num2+"="+val);
		*/
		
		// Q2 : 다이아몬드를 출력해 보세요 1-3-5-7-5-3-1
		
		System.out.println("홀수 값 입력하세요 : ");
		int lineCount = scanner.nextInt();
		int spaceCount = lineCount/2+1;
		int starCount = 1;
		
		for(int i=0; i<=lineCount; i++){
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			for(int j = 0; j<starCount; j++) {
				System.out.print('*');
			}
			
			if(i<lineCount/2) {
				spaceCount -= 1;
				starCount +=2;
			}
			else {
				spaceCount += 1;
				starCount -= 2;
			}
			System.out.println();
		}
		
	}
}
