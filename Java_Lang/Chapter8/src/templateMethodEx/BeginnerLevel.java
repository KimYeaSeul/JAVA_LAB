package templateMethodEx;

public class BeginnerLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("Slow run");
	}

	@Override
	public void jump() {
		System.out.println("X jump X");
	}

	@Override
	public void turn() {
		System.out.println("X turn X");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("****** BeginnerLevel ******");
	}

}
