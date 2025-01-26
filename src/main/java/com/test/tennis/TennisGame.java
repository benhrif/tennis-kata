package com.test.tennis;

public class TennisGame implements Game {
	
	private Player playerA;
	private Player playerB;
	private boolean isDeuce = false;
	
	public TennisGame(Player playerA, Player playerB) { 
		
		this.playerA = playerA;        
		this.playerB = playerB;    
	
	}
	
	public void lunch(String input) {
		
		InputValidator.validate(input);
		
		updateScore(input);
	}

	@Override
	public void updateScore(String input) {
		
		
		for (char c : input.toCharArray()) {
			if (c == 'A') {
				processPoint(playerA, playerB);
			}else if (c == 'B') {
				processPoint(playerB, playerA);
			}
			if (playerA.getState() == PlayerState.WINNER || playerB.getState() == PlayerState.WINNER) {
				System.out.println(getWinner());
				resetGame();
				break;
			}
			System.out.println(printScore());
		}
	}

	private void processPoint(Player scoringPlayer, Player opponentPlayer) {
		
	if (isDeuce) {
		if (scoringPlayer.getState() == PlayerState.ADVANTAGE) {
			scoringPlayer.addPoint();
		} else {
			scoringPlayer.setAdvantage();
			opponentPlayer.resetAdvantage();
		}
	}else {
		scoringPlayer.addPoint();
			if (playerA.getScore().equals("40") && playerB.getScore().equals("40")) {
				isDeuce = true;
			}
		}
	}

	@Override
	public String printScore() {
		if (isDeuce) {
				if (playerA.getState() == PlayerState.ADVANTAGE) {
					System.out.println("Advantage Player A");
				} else if (playerB.getState() == PlayerState.ADVANTAGE) {
					return "Advantage Player B";
				} else {
					return "Deuce";
				}
		} else {
			
				return "Player A: " + playerA.getScore() + " / Player B: " + playerB.getScore();
		}
		return "";
	}

	public String getWinner() {
		return playerA.getState() == PlayerState.WINNER ? "Player A wins the game" : "Player B wins the game";
	}

	private void resetGame() {
		playerA.reset();
		playerB.reset();
		isDeuce = false;
	}
	
	public boolean isDeuce() {
		return isDeuce;
	}

	public Player getPlayerA() {
		return playerA;
	}

	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}

	public Player getPlayerB() {
		return playerB;
	}

	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}

}
