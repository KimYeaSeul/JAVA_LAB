package testTMEX;

public class BeginnerLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("beginner run");
	}

	@Override
	public void jump() {
		System.out.println("beginner jump");
		
	}

	@Override
	public void turn() {
		System.out.println("beginner turn");
		
	}
	
	@Override
	public void showLevel() {
		System.out.println("***** beginner *****");
	}

}
