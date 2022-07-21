package templateMethod;

public abstract class Car {

	public abstract void drive();
	public abstract void stop();
	
	public void startCar() {
		System.out.println("Power On");
	}
	
	public void turnOff() {
		System.out.println("Power Off");
	}
	
	// 구현의 확장이 가능한 메서드
	public void washCar() {}
	
	// template method pattern
	// 이 흐름은 변하면 안됨. final 로 고정
	final public void run() {
		startCar();
		drive();
		stop();
		turnOff();
		washCar();
	}
}
