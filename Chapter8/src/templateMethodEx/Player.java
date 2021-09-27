package templateMethodEx;

public class Player {

	// player 가 있고 이 플레이어가 게임을 함. 
	// 게임에서 플레이어가 가지는 레벨에 따라 run(), jump(), turn() 세가지 기능을 할 수 있음
	// 각 레벨에 따라 기능 가능 여부
	//  - 초보자 : 천천히 달립니다(run())
	//  - 중급자 : 빠르게 달리고, 점프를 할수 있습니다.(run(), jump())
	//  - 고급자 : 엄청 빠르게 달리고, 점프, 한바퀴 돌 수 있음 (run(), jump(), turn())
	// 플레이어는  go() 명령어를 받으면 세가지 기능을 수행합니다.
	// 이 중 할 수 없는 것은 할 수 없다는 메시지를 보냅니다.
	
	// 이거슨 객체지향코딩이 아니여~~ 플레이어레벨로 통일하자규
//	BeginnerLevel blevel;
//	AdvancedLevel alevel;
//	SuperLevel slevel;
	
	private PlayerLevel level;
	
	// first level
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	public PlayerLevel getLevel() {
		return level;
	}
	
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
}