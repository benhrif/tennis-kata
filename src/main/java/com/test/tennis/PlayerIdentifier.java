package com.test.tennis;

public enum PlayerIdentifier {
    A {
        @Override
        public void process(TennisGame game) {  
        	
        	if(game.isDeuce() && game.getPlayerA().getState() != PlayerState.ADVANTAGE) {
        		game.getPlayerA().setState(PlayerState.ADVANTAGE);
        		game.getPlayerB().resetAdvantage();
        	}
        	else {
            		game.getScoreCalculator().addPoint(game.getPlayerA());
            }
        	
         }
    },
    B {
        @Override
        public void process(TennisGame game) {
        	
        	if(game.isDeuce() && game.getPlayerB().getState() != PlayerState.ADVANTAGE) {
        		game.getPlayerB().setState(PlayerState.ADVANTAGE);
        		game.getPlayerA().resetAdvantage();
        	}
        	else {
            		game.getScoreCalculator().addPoint(game.getPlayerB());
            }
        	
             }
    };

    public abstract void process(TennisGame game);
}