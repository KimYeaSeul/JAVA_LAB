package templateMethod;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car aiCar = new AICar();
		aiCar.run();
		System.out.println("=============");
		Car manualCar = new ManualCar();
		manualCar.run();
	}

}
