package application;

public class Player {
	
	private int score;
	private int totalNumOfAns;
	
	public Player() {
		this.score = 0;
		this.totalNumOfAns = 0;
	}

	public int getScore() {
		return score;
	}

	public void correctAns() {
		this.score++;
	}
	
	public void playerAns() {
		this.totalNumOfAns++;
	}

	public int getCorrectAns() {
		return score;
	}

	public int getWrongAns() {
		return totalNumOfAns - score;
	}
	
	public int getTotal() {
		return totalNumOfAns;
	}

	public String getFrequent() {
		return String.format("%.2f", 60.0/totalNumOfAns);
	}

}
