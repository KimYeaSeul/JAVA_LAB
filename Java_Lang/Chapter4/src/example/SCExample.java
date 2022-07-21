package example;

import java.util.Scanner;

public class SCExample {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// switch-case
		/*
		scanner = new Scanner(System.in);
		
		System.out.println("Insert Rank : ");
		int rank = scanner.nextInt();
		char medalColor;
		
		switch(rank) {
			case 1:medalColor = 'G';
				System.out.println("금메달");
				break;
			case 2:medalColor = 'S';
				System.out.println("메달");
				break;
			case 3:medalColor = 'B';
				System.out.println("메달");
				break;
			default : medalColor = 'A';
		}
		
		System.out.println(rank + "등은 " + medalColor + "메달입니다.");
		*/
		// Question
		
		System.out.println("Insert Month : ");
		int mon = scanner.nextInt();
		int day;
		
		switch(mon) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day = 31;
				break;
			case 4: case 6: case 9: case 11:
				day = 30;
				break;
			case 2: 
				day = 28;
				break;
			default:
				System.out.println("Error");
				day = 0;
		}
		
		System.out.println(mon + "월은 "+day+"일 입니다.");
		
		
	}
}
