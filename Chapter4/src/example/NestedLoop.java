package example;

import java.util.Scanner;

public class NestedLoop {

	public static void main(String[] args) {

		// 구구단
		
		int dan;
		int count;
		
		// For 
		/*
		 * for( dan = 2; dan <=9; dan++) {
			System.out.println(dan + "단");
			
			for( count = 1; count <= 9; count++) {
				System.out.println(dan +" X "+ count +" = "+ count*dan);
			}
			System.out.println();
		}
		*/
		
		// while 문
		dan=2; 
		
		while(dan <=9) {
			System.out.println(dan + "단");
			count=1;
			while(count<=9) {
				System.out.println(dan +" X "+ count +" = "+ count*dan);
				count++;
			}
			dan++;
			System.out.println();
		}
	}

}
