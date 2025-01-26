package com.test.tennis;

public class Player implements Score {
	
	private int score = 0;
	private PlayerState state = PlayerState.IN_GAME;

	@Override
	public void addPoint() {
		if (state == PlayerState.ADVANTAGE) {
			state = PlayerState.WINNER;
		} else if (score < 30) {
			score += 15;
		} else if (score == 30) {
			score = 40;
		} else if (score == 40) {
			state = PlayerState.WINNER;
	}
	}

	@Override
	public String getScore() {
		if (state == PlayerState.ADVANTAGE) {
			return "Advantage";
		} else if (score == 40) {
			return "40";
		}
			return String.valueOf(score);
	}

	public PlayerState getState() {
		return state;
	}

	public void setAdvantage() {
		state = PlayerState.ADVANTAGE;
	}

	public void resetAdvantage() {
		if (state == PlayerState.ADVANTAGE) {
			state = PlayerState.IN_GAME;
		}
	}


	public void reset() {
		score = 0;
		state = PlayerState.IN_GAME;
	}

}
