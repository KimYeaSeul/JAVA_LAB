package coffeeTest;

public class MorningCoffee {
	// 객체 간 협력 - 출근길 커피 사기
	// 김씨는 아침 출근길 4,000원을 내고 별다방에서 아메리카노를 마심
	// 이씨는 4,500원을 내고 콩다방에서 라떼를 마심
	
	public static void main(String[] args) {
		
		Person kim = new Person("kim", 25000);
		Person lee = new Person("lee", 30000);
		
		StarCoffee starCoffee = new StarCoffee();
		BeanCoffee beancoffee = new BeanCoffee();
		
		kim.buyStarAmeri(starCoffee);
		kim.buyBeanAmeri(beancoffee);
		
		lee.buyStarLatte(starCoffee);
		lee.buyBeanLatte(beancoffee);
		
		kim.getInfo();
		lee.getInfo();
		
	}
	
}
