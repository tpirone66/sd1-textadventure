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

import java.io.*;

public class TextAdventure extends Player{

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;
		String direction;
		
		//locations and their descriptions
		String[] locationDescription = {"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", "Champagnat is really loud tonight! Why is there a fire drill every weekend?", "Leo seems like the place where all the rich children live. $$$", "Marian is home to the hobbits and the hermits. Sure seems clicky around here.", "Midrise is Midrise...yeah...", "Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?"};
		String[] location = {"Marist", "Champagnat", "Leo", "Marian", "Midrise", "Sheahan"};
		int playerLocation = 0;
		
		//method that will display the name of the game and description
		titleMessage();
		
		//method for allowing the user to customize their character
		promptName();
		
		//the user will decide to start, get help or exit the game here
		System.out.println("Press the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		
		System.out.print("\nCurrent location: "+playerLocation+".");
		System.out.print(" You are now in " + location[0] + "." + " " + locationDescription[0]);
		
		while(true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();
			direction = input;
			
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
				if (playerLocation == 0){
					direction = "North";
					playerLocation = 1;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[1] + "." + " " + locationDescription[1]);
					}
				else if (input.equalsIgnoreCase("N") && playerLocation == 3){
					direction = "North";
					playerLocation = 0;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[0] + "." + " " + locationDescription[0]);
				}
				else {
					System.out.print("\nCannot move North anymore!");
				}
				
			}
			
			//what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				if (playerLocation == 0){
					direction = "South";
					playerLocation = 3;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[3] + "." + " " + locationDescription[3]);
					}
				else if (input.equalsIgnoreCase("S") && playerLocation == 1){
						direction = "South";
						playerLocation = 0;
						System.out.print("\nYou moved " + direction + ". ");
						System.out.print("Current location: "+ playerLocation +".");
						System.out.print(" You are now in " + location[0] + "." + " " + locationDescription[0]);
				}
				else {
					System.out.print("\nCannot move South anymore!");
				}
			}
			
			//what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				if (playerLocation == 0){
					direction = "East";
					playerLocation = 4;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[4] + "." + " " + locationDescription[4]);
					}
				else if (input.equalsIgnoreCase("E") && playerLocation == 5){
					direction = "East";
					playerLocation = 2;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[2] + "." + " " + locationDescription[2]);
				}
				else if (input.equalsIgnoreCase("E") && playerLocation == 2){
					direction = "East";
					playerLocation = 0;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[0] + "." + " " + locationDescription[0]);
				}
				else {
					System.out.print("\nCannot move East anymore!");
				}
			}
			
			//what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				if (playerLocation == 0){
					direction = "West";
					playerLocation = 2;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[2] + "." + " " + locationDescription[2]);
				}
				else if (input.equalsIgnoreCase("W") && playerLocation==2) {
					direction = "West" ;
					playerLocation = 5;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[5] + "." + " " + locationDescription[5]);
				}
				else if (input.equalsIgnoreCase("W") && playerLocation == 4){
					direction = "West";
					playerLocation = 0;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ playerLocation +".");
					System.out.print(" You are now in " + location[0] + "." + " " + locationDescription[0]);
				}
				else {
					System.out.print("\nCannot move West anymore!");
				}
			}
				
			//what happens when the user types in Q
			else if (input.equalsIgnoreCase("Q")) {
				//closing message for the game
				showCredits();
				break;
			}
			
			//if the user types in any other keys not mentioned above, it will print this message
			else {
				System.out.println("Invalid command!\n");
				continue;
			}
	}
}
		
	private static void titleMessage() {
		//prints a greeting message when the user runs the program
		System.out.println("Welcome to Marist Mayhem!");
		System.out.println("-----------------------------------");
		System.out.println("Marist Mayhem is a text-adventure game where the user will explore the scary grounds of Marist and try to\nfind out what is happening on the campus and revert it back to normal.");
		System.out.println("-----------------------------------");
	}

	private static void showCredits() {
		System.out.println("Thank you for playing this game!");
		System.out.println("Please come back soon!\n");
		System.out.println("Trevor Pirone Copyright 2016");
	}

}