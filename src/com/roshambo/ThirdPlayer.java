package com.roshambo;

public class ThirdPlayer extends Player{
	
	
	
	
	public Roshambo generateRoshambo(String userInput) {
		if(userInput.equalsIgnoreCase("rock")) {
			return Roshambo.Rock;
		} else if(userInput.equalsIgnoreCase("paper")) {
			return Roshambo.Paper;
		} else if(userInput.equalsIgnoreCase("scissors")) {
			return Roshambo.Scissors;
		}
		
		
		return null;
	}

	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		return null;
	}

}
