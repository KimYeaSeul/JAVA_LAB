package staticEx;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();
		
		System.out.println(company1);
		System.out.println(company2);
		
//		Calendar calendar = new Calendar(); // singleton pattern 에 의해 생성자 못만듬
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
	}

}
