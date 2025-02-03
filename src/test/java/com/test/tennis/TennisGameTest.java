package com.test.tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TennisGameTest {
	
	private TennisGame game;
	
	@Autowired
	private ScoreDisplay scoreDisplay;

	@BeforeEach
	public void setUp() {
		Player playerA = new Player();
		Player playerB = new Player();
		game = new TennisGame(playerA, playerB, new ScoreCalculator(), new ScoreDisplay());
		scoreDisplay = new ScoreDisplay();
		
	}
	
	@Test
	public void testPlayerAWinsFirstBall() {
	game.updateScore("A");
	assertEquals("Player A: 15 / Player B: 0", scoreDisplay.printScore(game));
	}

	@Test
	public void testPlayerBWinsFirstBall() {
	game.updateScore("B");
	assertEquals("Player A: 0 / Player B: 15", scoreDisplay.printScore(game));
	}

	@Test
	public void testAdvantagePlayerA() {
		game.updateScore("AAABBBA");
		assertThat(game.getPlayerA().getState()).isEqualTo(PlayerState.ADVANTAGE);
	}
	
	@Test
	public void testAdvantagePlayerB() {
		game.updateScore("AAABBBB");
		assertThat(game.getPlayerB().getState()).isEqualTo(PlayerState.ADVANTAGE);
	}

	@Test
	public void testIsDeuce() {
		game.updateScore("AAABBB");
		assertThat(game.isDeuce()).isTrue();
	}


}
