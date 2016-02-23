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

public class TextAdventure{

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;
		String direction;
		
		//method that will display the name of the game and description
		titleMessage();
		
		//method for allowing the user to customize their character
		Player.promptName();
		
		//the user will decide to start, get help or exit the game here
		System.out.println("Press the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		
		System.out.print("\nCurrent location: "+Player.playerLocation+".");
		System.out.print(" You are now in " + Locale.location[0] + "." + " " + Locale.locationDescription[0]);
		
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
				if (Player.playerLocation == 0){
					direction = "North";
					Player.playerLocation = 1;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[1] + "." + " " + Locale.locationDescription[1]);
					}
				else if (input.equalsIgnoreCase("N") && Player.playerLocation == 3){
					direction = "North";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[0] + "." + " " + Locale.locationDescription[0]);
				}
				else if (input.equalsIgnoreCase("N") && Player.playerLocation == 7){
					direction = "North";
					Player.playerLocation = 3;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[3] + "." + " " + Locale.locationDescription[3]);
				}
				else {
					System.out.print("\nCannot move North anymore!");
				}
				
			}
			
			//what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				if (Player.playerLocation == 0){
					direction = "South";
					Player.playerLocation = 3;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[3] + "." + " " + Locale.locationDescription[3]);
					}
				else if (input.equalsIgnoreCase("S") && Player.playerLocation == 1){
						direction = "South";
						Player.playerLocation = 0;
						System.out.print("\nYou moved " + direction + ". ");
						System.out.print("Current location: "+ Player.playerLocation +".");
						System.out.print(" You are now in " + Locale.location[0] + "." + " " + Locale.locationDescription[0]);
				}
				else if (input.equalsIgnoreCase("S") && Player.playerLocation == 3){
					direction = "South";
					Player.playerLocation = 7;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[7] + "." + " " + Locale.locationDescription[7]);
			}
				else {
					System.out.print("\nCannot move South anymore!");
				}
			}
			
			//what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				if (Player.playerLocation == 0){
					direction = "East";
					Player.playerLocation = 4;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[4] + "." + " " + Locale.locationDescription[4]);
					}
				else if (input.equalsIgnoreCase("E") && Player.playerLocation == 5){
					direction = "East";
					Player.playerLocation = 2;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[2] + "." + " " + Locale.locationDescription[2]);
				}
				else if (input.equalsIgnoreCase("E") && Player.playerLocation == 2){
					direction = "East";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[0] + "." + " " + Locale.locationDescription[0]);
				}
				else if (input.equalsIgnoreCase("E") && Player.playerLocation == 4){
					direction = "East";
					Player.playerLocation = 6;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[6] + "." + " " + Locale.locationDescription[6]);
				}
				else {
					System.out.print("\nCannot move East anymore!");
				}
			}
			
			//what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				if (Player.playerLocation == 0){
					direction = "West";
					Player.playerLocation = 2;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[2] + "." + " " + Locale.locationDescription[2]);
				}
				else if (input.equalsIgnoreCase("W") && Player.playerLocation==2) {
					direction = "West" ;
					Player.playerLocation = 5;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[5] + "." + " " + Locale.locationDescription[5]);
				}
				else if (input.equalsIgnoreCase("W") && Player.playerLocation == 4){
					direction = "West";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[0] + "." + " " + Locale.locationDescription[0]);
				}
				else if (input.equalsIgnoreCase("W") && Player.playerLocation == 6){
					direction = "West";
					Player.playerLocation = 4;
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + Locale.location[4] + "." + " " + Locale.locationDescription[4]);
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