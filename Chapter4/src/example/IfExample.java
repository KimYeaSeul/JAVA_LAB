package example;

import java.util.Scanner;

public class IfExample {
	
		public static void main(String[] args) {
			
			// 1 : if
			
			char gender = 'M';
			
			if ( gender == 'F') {
				System.out.println("여성입니다.");
			} else if( gender == 'M') {
				System.out.println("남성입니다.");
			} else {
				System.out.println("중성입니다.");
			}
			
			// 2 : if
			
			Scanner scanner = new Scanner(System.in);
			
			int age = scanner.nextInt();
			
			int charge = 0;
			
			if( age < 8 ) { charge = 1000;}
			else if ( age < 14 ) { charge = 1500;}
			else if ( age < 20 ) { charge = 2000;}
			else  { charge = 3000;}
			
			System.out.println("나이 : " + age);
			System.out.println("요금 : " + charge);
			
			// 3 : if 

			System.out.println("Question 3");
			
			int score = scanner.nextInt();
			char credit=0;
			
			if( score < 60 ) { credit = 'F'; }
			else if ( score < 70 ) { credit = 'D'; }
			else if ( score < 80 ) { credit = 'C'; }
			else if ( score < 90 ) { credit = 'B';}
			else if ( score < 100 ) { credit = 'A'; }
			else { System.out.println("It is worng score"); }
			
			System.out.println("점수 : " +score);
			System.out.println("학점 : " +credit);
			
			// 4 : if => 3항연산자			
			
		}

}
