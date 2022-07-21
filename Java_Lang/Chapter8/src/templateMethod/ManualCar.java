package templateMethod;

public class ManualCar extends Car {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Drive Human");
		System.out.println("Turn direction Human");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stop on by Human");
	}
}
