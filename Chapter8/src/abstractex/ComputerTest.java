package abstractex;

public class ComputerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Computer computer = new Computer(); // 추상클래스는 인스턴스화 되지 않슴니다!
		
		Computer computer = new DeskTop();
		computer.display();
		computer.turnOff();
		
		Computer myNote = new MyNoteBook();
		myNote.display();
	}

}
