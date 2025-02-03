package com.test.tennis;

import org.springframework.stereotype.Component;

@Component
public class ScoreDisplay {

    void displayScore(TennisGame game) {
    	if (finishedGame(game)) {
    		displayWinner(game);
            game.resetGame();
        }
    	else {
    		System.out.println(printScore(game));
    	}
    }

    public void displayWinner(TennisGame game) {
        System.out.println(getWinner(game));
    }
    
    String printScore(TennisGame game) {
        Player playerA = game.getPlayerA();
        Player playerB = game.getPlayerB();
        boolean isDeuce = game.isDeuce();
        
        
        if (isDeuce) {
            if (playerA.getState() == PlayerState.ADVANTAGE) {
                return "Advantage Player A";
            } else if (playerB.getState() == PlayerState.ADVANTAGE) {
                return "Advantage Player B";
            } else {
                return "Deuce";
            }
        } else {
            return "Player A: " + playerA.getScore() + " / Player B: " + playerB.getScore();
        }
    }
    
    private String getWinner(TennisGame game) {
         if(game.getPlayerA().getState() == PlayerState.WINNER) return "Player A wins the game";
         if(game.getPlayerB().getState() == PlayerState.WINNER) return "Player B wins the game";
         return "";
    }
    
    private boolean finishedGame(TennisGame game) {
		return game.getPlayerA().getState() == PlayerState.WINNER || game.getPlayerB().getState() == PlayerState.WINNER;
	}
}