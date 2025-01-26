package com.test.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TennisApplication.class, args);
		
		Player playerA = new Player();
		Player playerB = new Player();
		TennisGame game = new TennisGame(playerA, playerB);
		
		game.lunch(args[0]);       
	}

}
