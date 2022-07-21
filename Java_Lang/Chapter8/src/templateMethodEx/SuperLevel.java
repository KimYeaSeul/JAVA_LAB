package templateMethodEx;

public class SuperLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("Fastest run");
	}

	@Override
	public void jump() {
		System.out.println("Highest Jump");
	}

	@Override
	public void turn() {
		System.out.println("Turnning");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("****** SuperLevel ******");
	}

}
