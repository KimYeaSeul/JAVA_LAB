package thisEx;

public class Person {

	String name;
	int age;
	
	// 생성자에서 다른 생성자를 호출 
	public Person() { // 인스턴스 값 초기화
		this("이름없음", 1);
	}
	
	//자신의 메모리를 가
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.println(name + ","+ age);
	}
	
	// 인스턴스 자신의 주소를 반
	public Person getSelf() {
		return this;
	}
}
