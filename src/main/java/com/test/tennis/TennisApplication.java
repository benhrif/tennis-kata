package com.test.tennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TennisApplication.class, args);
		
		TennisGame game = new TennisGame(new Player(), new Player(), new ScoreCalculator(), new ScoreDisplay());
		
		game.launch(args[0]);   
		//game.launch("ABAAA");   
	}

}
