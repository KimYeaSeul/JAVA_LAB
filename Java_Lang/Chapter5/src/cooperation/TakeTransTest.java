package cooperation;

public class TakeTransTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student studentJ = new Student("James", 5000);
		Student studentT = new Student("Tomas", 10000);
		Student studentE = new Student("Edward", 45000);
		
		Bus bus100 = new Bus(100);
		Bus bus500 = new Bus(500);
		Subway subwayGreen = new Subway(2);
		Subway subwayBlue = new Subway(4);
		Texi texi = new Texi(5667);
		
		studentJ.takeBus(bus100);
		studentT.takeSubway(subwayBlue);
		studentE.takeTexi(texi, 12400);
		
		studentJ.showInfo();
		studentT.showInfo();
		studentE.showInfo();
		
		bus100.showBusInfo();
		bus500.showBusInfo();
		
		subwayGreen.showSubwayInfo();
		subwayBlue.showSubwayInfo();
		
		texi.showTexiInfo();
	}

}
