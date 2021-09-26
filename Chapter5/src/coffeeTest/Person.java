package coffeeTest;

public class Person {

	String name;
	int money;
	
	public Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void buyStarAmeri(StarCoffee starCoffee) {
		int price = starCoffee.sellAmeri();
		this.money -= price;
		System.out.println(name+"님, 스타벅스에서 아메리카노 구입하셔쓰비나.");
	}
	
	public void buyStarLatte(StarCoffee starCoffee) {
		int price = starCoffee.sellLatte();
		this.money -= price;
		System.out.println(name+"님, 스타벅스에서 라떼 구입하셔쓰비나.");
	}
	
	public void buyBeanAmeri(BeanCoffee beanCoffee) {
		int price = beanCoffee.sellAmeri();
		this.money -= price;
		System.out.println(name+"님, 커피빈에서 아메리 구입하셔쓰비나.");
	}
	
	public void buyBeanLatte(BeanCoffee beanCoffee) {
		int price = beanCoffee.sellLatte();
		this.money -= price;
		System.out.println(name+"님, 커피빈에서 라떼 구입하셔쓰비나.");
	}
	
	public void getInfo() {
		System.out.println("이름 : "+name+", 가진 돈 : "+money);
	}
}
