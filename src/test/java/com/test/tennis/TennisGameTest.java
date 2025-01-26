package com.test.tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TennisGameTest {
	
	private TennisGame game;

	@BeforeEach
	public void setUp() {
		Player playerA = new Player();
		Player playerB = new Player();
		game = new TennisGame(playerA, playerB);
	}
	
	@Test
	public void testPlayerAWinsFirstBall() {
	game.updateScore("A");
	assertEquals("Player A: 15 / Player B: 0", game.printScore());
	}

	@Test
	public void testPlayerBWinsFirstBall() {
	game.updateScore("B");
	assertEquals("Player A: 0 / Player B: 15", game.printScore());
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
	
	@Test
	public void testPlayerBWin() {
		game.updateScore("AAABBBBB");
		assertThat(game.getWinner()).isEqualTo("Player B wins the game");
	}

}
