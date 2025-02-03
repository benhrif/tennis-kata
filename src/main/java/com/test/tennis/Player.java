package com.test.tennis;

import org.springframework.stereotype.Component;

@Component
public class Player {
    private PlayerState state;
    private String score;
 

    public Player() {
    	reset();
	}

	public String getScore() {
        return score;
    }
    
	public void setScore(String score) {
		this.score = score;
	}

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void resetAdvantage() {
        if (state == PlayerState.ADVANTAGE) {
            state = PlayerState.IN_GAME;
        }
    }

    public void reset() {
        score = "0";
        state = PlayerState.IN_GAME;
    }
}