package templateMethodEx;

public class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("Fast run");
	}

	@Override
	public void jump() {
		System.out.println("High Jump");
	}

	@Override
	public void turn() {
		System.out.println("X turn X");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("****** AdvancedLevel ******");
	}

}
