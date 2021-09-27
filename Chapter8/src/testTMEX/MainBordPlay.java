package testTMEX;

public class MainBordPlay {

	public static void main(String[] args) {
		
		Player player = new Player();
		player.play(1);
	
		PlayerLevel aLevel = new AdvancedLevel();
		player.upgradeLevel(aLevel);
		player.showLevel();
		player.play(2);
		
		PlayerLevel sLevel = new SuperLevel();
		player.upgradeLevel(sLevel);
		player.showLevel();
		player.play(3);
	}

}
