package com.test.tennis;

import org.springframework.stereotype.Component;

@Component
public class ScoreDisplay{

    void displayScore(TennisGame game) {
    	if (game.finishedGame()) {
    		displayWinner(game);
            game.resetGame();
        }
    	else {
    		System.out.println(printScore(game));
    	}
    }

    public void displayWinner(TennisGame game) {
    	if(game.getPlayerA().getState() == PlayerState.WINNER) System.out.println( "Player A wins the game");
    	else System.out.println ("Player B wins the game");
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
    
}