package com.roshambo;

import java.util.Random;

public class RandomPlayer extends Player{
	Random rand = new Random();
	private int randNum;
	
	@Override
	public Roshambo generateRoshambo() {
		randNum = rand.nextInt(3);
		
		if(randNum == 0) {
			return Roshambo.Rock;
		} else if(randNum == 1) {
			return Roshambo.Paper;
		} else if(randNum == 2) {
			return Roshambo.Scissors;
		}
		return null;
	}

	
}
