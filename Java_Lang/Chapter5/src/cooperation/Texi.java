package cooperation;

public class Texi {

	int texiNumber;
	int charge;
	
	public Texi(int texiNumber) {
		this.texiNumber = texiNumber;
	}
	
	public void take(int charge) {
		this.charge += charge;		
	}
	
	public void showTexiInfo() {
		System.out.println(texiNumber+"번 택시 요금은 " + charge+ "원 입니다.");
	}
}
