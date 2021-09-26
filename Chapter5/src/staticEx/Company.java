package staticEx;

public class Company {

	private static Company instance = new Company();
	private Company() {}
	
	// 밖에서 접근하기 위여 static 사
	public static Company getInstance() {
		if( instance == null ) instance = new Company();
		return instance;
	}
	public static void setInstance(Company instance) {
		Company.instance = instance;
	}
	
}
