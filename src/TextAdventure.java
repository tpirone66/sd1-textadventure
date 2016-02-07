/*Trevor Pirone
 * CMPT 220L
 * Software Development 1
 * Project 1
 * Text Adventure Game v0.1
 * 
 * A text adventure based game created by @author Trevor Pirone
 */

import java.util.Scanner;//used for reading user input on the keyboard

import java.util.Random;//will be used later on for random generation

public class TextAdventure {

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;
		String direction;
		
		//prints a greeting message when the user runs the program
		System.out.println("Welcome to the Text Adventure Game!");
		System.out.println("-----------------------------------");
		
		//method for allowing the user to customize their character
		promptName();
		
		System.out.println("Press the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		//the user will decide to start, get help or exit the game here
		
		while(true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();
			direction = input;
			//locations and their descriptions
			String[] locationDescription = {"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", "Champagnat is really loud tonight! Why is there a fire drill every weekend?", "Leo seems like the place where all the rich children live. $$$", "Marian is home to the hobbits and the hermits. Sure seems clicky around here.", "Midrise is Midrise...yeah...", "Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?"};
			String[] location = {"Marist", "Champagnat", "Leo", "Marian", "Midrise", "Sheahan"};
			int[] locator;
			locator = new int[6];
			locator[0] = 0;
			locator[1] = 1;
			locator[2] = 2;
			locator[3] = 3;
			locator[4] = 4;
			locator[5] = 5;
			
			//what happens when the user types in H
			if (input.equalsIgnoreCase("H")) {
				System.out.println("Press N to go North.");
				System.out.println("Press S to go South.");
				System.out.println("Press E to go East.");
				System.out.println("Press W to go West.");
				System.out.println("Press Q to quit the game.");
			}
			
			//what happens when the user types in N
			else if (input.equalsIgnoreCase("N")) {
				direction = "North";
			}
			
			//what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				direction = "South";
			}
			
			//what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				direction = "East";
			}
			
			//what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				direction = "West";
			}
			
			//what happens when the user types in Q
			else if (input.equalsIgnoreCase("Q")) {
				break;
			}
			
			//if the user types in any other keys not mentioned above, it will print this message
			else {
				System.out.println("Invalid command!\n");
				continue;
			}
			
			//the result of pressing the directional keys
			System.out.print("You moved " + direction + ".\n");
			System.out.print("You are now in " + location[0] + "." + " " + locationDescription[0]);
			System.out.print("Current location: "+locator[0]);
			
		}
		
		//closing message for the game
		System.out.println("Thank you for playing this game!");
		System.out.println("Please come back soon!\n");
		System.out.println("Trevor Pirone Copyright 2016");

	}
	
	public static void promptName() {
		Scanner inputSource = new Scanner(System.in);
		String input;
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		System.out.println("Hello, " + input + "!");
		System.out.println("\n");//prints out a new line of whitespace
		
	};

}
