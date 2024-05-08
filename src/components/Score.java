package components;

public class Score {

	private final int SCORE1 = 100; // 젤리 1 점수
	private final int SCORE2 = 1000; // 젤리 2 점수
	private final int SCORE3 = 5000; // 젤리 3 점수
	private int finalScore = 0; // 게임 끝나면 출력될 점수

	public int getFinalScore() {
		return finalScore;
	}

	public void touchAcorn1() { // 젤리 1 먹으면 호출
		finalScore = finalScore + SCORE1;
	}

	public void touchAcorn2() {// 젤리 2 먹으면 호출
		finalScore = finalScore + SCORE1;
	}

	public void touchAcorn3() {// 젤리 3 먹으면 호출
		finalScore = finalScore + SCORE1;
	}

}
