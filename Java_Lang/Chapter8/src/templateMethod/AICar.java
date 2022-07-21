package templateMethod;

public class AICar extends Car {

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Outo Drive Car");
		System.out.println("Turn direction self");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stop self");
	}
	
	@Override
	public void washCar() {
		System.out.println("Outo cleaan");
	}

}
