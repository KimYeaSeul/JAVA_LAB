package abstractex;

public abstract class Computer {
	
	public abstract void display();
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("Power on");
	}
	
	public void turnOff() {
		System.out.println("Power off");
	}

}
