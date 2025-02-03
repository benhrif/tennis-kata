package com.test.tennis;

import org.springframework.stereotype.Component;

@Component
public class ScoreCalculator {

    private int score = 0;

    public void addPoint(Player player) {
    	score = Integer.valueOf(player.getScore());
        PlayerState state = player.getState();
        if (state == PlayerState.ADVANTAGE) {
            player.setState(PlayerState.WINNER);
        } else if (score < 30) {
            score += 15;
        } else if (score == 30) {
            score = 40;
        } else if (score == 40) {
            player.setState(PlayerState.WINNER);
        }
        player.setScore(String.valueOf(score));
    }
}