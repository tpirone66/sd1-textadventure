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
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		
		//the user will type their name here
		System.out.println("Hello, " + input + "!");
		System.out.println("\n");//prints out a new line of whitespace
		System.out.println("Press the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		//the user will decide to start, get help or exit the game here
		
		while(true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();
			direction = input;
			
			if (input.equalsIgnoreCase("H")) {
				System.out.println("Press N to go North.");
				System.out.println("Press S to go South.");
				System.out.println("Press E to go East.");
				System.out.println("Press W to go West.");
			}
			
			else if (input.equalsIgnoreCase("N")) {
				direction = "North";
			}
			
			else if (input.equalsIgnoreCase("S")) {
				direction = "South";
			}
			
			else if (input.equalsIgnoreCase("E")) {
				direction = "East";
			}
			
			else if (input.equalsIgnoreCase("W")) {
				direction = "West";
			}
			
			else if (input.equalsIgnoreCase("Q")) {
				break;
			}
			
			else {
				System.out.println("Invalid command!\n");
				continue;
			}
				
			System.out.print("You moved " + direction + ".\n");
		}
		
		System.out.println("Thank you for playing this game!");
		System.out.println("Please come back soon!\n");
		System.out.println("Trevor Pirone Copyright 2016");

	}

}
