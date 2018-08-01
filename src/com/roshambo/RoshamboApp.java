package com.roshambo;

import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RandomPlayer pRandom = new RandomPlayer();
		String userName;
		String userChoice;
		String userInput;
		int newInput;
		Roshambo randChoice;
		String cont = null;
		int winCounter = 0;
		int lossCounter = 0;
		int drawCounter = 0;
		String vP1;
		String vP2;

		System.out.println("Welcome to Rock, Paper, Scissors!");
		userName = Validator.getString(scan, "Please enter your name: ");

		// This do-while will works as continue until user wants to stop
		do {

			randChoice = null; // Clears variable each iteration
			userChoice = Validator.getString(scan, "Would you like to play against player 1 or player 2 (p1/p2)?: ");

			// vs random player
			if (userChoice.equalsIgnoreCase("p1")) {
				userInput = Validator.getString(scan, "(Rock), (Paper), or (Scissors)?: ");
				newInput = translateInput(userInput);
				randChoice = pRandom.generateRoshambo();

				System.out.println(userName + ": " + userInput);
				System.out.println(userChoice + ": " + randChoice);

				// win loss ratio
				vP1 = playRandomPlayer(userName, newInput, randChoice);
				System.out.println(vP1);
				if (vP1.contains("win")) {
					winCounter++;
				} else if (vP1.contains("Sorry")) {
					lossCounter++;
				} else {
					drawCounter++;
				}

				// vs Rock player
			} else if (userChoice.equalsIgnoreCase("p2")) {
				userInput = Validator.getString(scan, "(Rock), (Paper), or (Scissors)?: ");
				newInput = translateInput(userInput);

				System.out.println(userName + ": " + userInput);
				System.out.println(userChoice + ": Rock");

				vP2 = playRockPlayer(userName, newInput);
				System.out.println(vP2);
				if (vP2.contains("win")) {
					winCounter++;
				} else if (vP2.contains("Sorry")) {
					lossCounter++;
				} else {
					drawCounter++;
				}

			} else {
				System.out.println("Invalid input");
			}

			System.out.println("Wins: " + winCounter + " -- Losses: " + lossCounter + " -- Draws: " + drawCounter);
			cont = Validator.getString(scan, "Would you like to continue (y/n)?");

		} while (cont.equalsIgnoreCase("y"));

		userRecord(winCounter, lossCounter);
	}

	// display win loss ratio
	public static void userRecord(int winCounter, int lossCounter) {
		if (lossCounter == 0) {
			System.out.println("Wow! you went undefeated!");
		} else if (winCounter > lossCounter) {
			System.out.println("Congrats, you ended with a positive record");
		} else if (winCounter == lossCounter) {
			System.out.println("You ended with an even record");
		} else {
			System.out.println("You ended with a losing record... better luck next time");
		}
	}

	public static String getResults(String userChoice) {

		if (userChoice.equalsIgnoreCase("p1")) {

		}

		return null;
	}

	// This method will determine who win vs random player
	public static String playRandomPlayer(String userName, int input, Roshambo random) {
		int newRandom = 0;
		if (random == Roshambo.Rock) {
			newRandom = 0;
		} else if (random == Roshambo.Paper) {
			newRandom = 1;
		} else if (random == Roshambo.Scissors) {
			newRandom = 2;
		}

		if (input == 0) {
			if (0 == newRandom) {
				return ("Draw!");
			} else if (newRandom == 2) {
				return (userName + " win!");
			} else {
				return ("Sorry, player 1 beat you with paper");
			}
		} else if (input == 1) {
			if (1 == newRandom) {
				return ("Draw!");
			} else if (newRandom == 0) {
				return (userName + " win!");
			} else {
				return ("Sorry, player 1 beat you with scissors");
			}
		} else if (input == 2) {
			if (input == newRandom) {
				return ("Draw!");
			} else if (newRandom == 1) {
				return (userName + " wins!");
			} else {
				return ("Sorry, player 1 beat you with rock");
			}
		}

		return null;
	}

	// This code determines whoe wins vs rock player
	public static String playRockPlayer(String userName, int input) {
		if (input == 0) {
			return ("Draw!");
		} else if (input == 1) {
			return (userName + " wins!");
		}
		return ("Sorry, player 2 won this round.");
	}

	// returns user input into integer
	public static int translateInput(String input) {

		if (input.equalsIgnoreCase("rock")) {
			return 0;
		} else if (input.equalsIgnoreCase("paper")) {
			return 1;
		} else
			return 2;

	}
}
