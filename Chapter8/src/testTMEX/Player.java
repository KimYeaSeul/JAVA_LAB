package testTMEX;

public class Player {
	
	private PlayerLevel player;
	
	public Player() {
		player = new BeginnerLevel();
		player.showLevel();
	}
	
	public void showLevel() {
		player.showLevel();
	}
	
	public PlayerLevel upgradeLevel(PlayerLevel player) {
		// 새로운 레벨로 기존 플레이어를 어떻게 업그레이드 시키죠?
		// Player 형으로 반환!!!??
		return player;
	}
	
	public void play( int count ) {
		player.go(count);
	}
	
}
