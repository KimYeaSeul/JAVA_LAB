package array;

public class Subject {
	
	private String className;
	private int score;
	
	public Subject(String className, int score) {
		this.className = className;
		this.score = score;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
