package tryTest;

import java.util.ArrayList;

public class CarTest {

	// Car 추상 클래스를 상속받는 소나타,아반뗴, 그랜져, 제네시스 클래스가 있습니다.
	// 각 차는 주행하기 위해 다음 메서드의 순서로 움직입니다. start()-drive()-stop()-turnoff()
	// run 메서드를 템플릿 메서드로 구현하고 CarTest클래스를 참고하여 프래그램을 완성하세요
	public static void main(String[] args) {
		ArrayList<Car> carList = new ArrayList<Car>();
		carList.add(new Sonata());
		carList.add(new Grandeur());
		carList.add(new Avante());
		carList.add(new Genesis());
		for(Car car : carList) {
			car.run();
			System.out.println("=============");
		}
		
	}

}
