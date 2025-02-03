package com.test.tennis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class TennisGame implements Game {
    
    private static final String DEUCECUTTOF = "40";
    private Player playerA;
    private Player playerB;
    private ScoreCalculator scoreCalculator;
    private ScoreDisplay scoreDisplay;
    private boolean isDeuce = false;
   
    
    @Autowired
    public TennisGame(Player playerA, Player playerB, ScoreCalculator scoreCalculator, ScoreDisplay scoreDisplay) { 
        this.playerA = playerA;        
        this.playerB = playerB;  
        this.scoreCalculator=scoreCalculator;        
        this.scoreDisplay = scoreDisplay;
    }
    
    public void launch(String input) {
        InputValidator.validate(input);
        updateScore(input);
    }

    @Override
    public void updateScore(String input) {
        for (char scoringPlayer : input.toCharArray()) {
        	
            PlayerIdentifier playerIdentifier = PlayerIdentifier.valueOf(String.valueOf(scoringPlayer));
            playerIdentifier.process(this);
            
        	if (checkDeuce()) {
                setDeuce(true);
            }
            
            scoreDisplay.displayScore(this);
        }
    }

    boolean checkDeuce() {
        return playerA.getScore().equals(DEUCECUTTOF) && playerB.getScore().equals(DEUCECUTTOF);
    }

    void resetGame() {
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

    public Player getPlayerB() {
        return playerB;
    }

	public void setDeuce(boolean deuce) {
	
		this.isDeuce = deuce;
		
	}

	public ScoreCalculator getScoreCalculator() {
		return scoreCalculator;
	}
}