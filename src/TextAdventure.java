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

	public static final int direction = 0;

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;
		String[] direction = {"North", "South", "East", "West"} ;
		int dest = Locale.map[Player.playerLocation][TextAdventure.direction];
		
		Locale[] locale = new Locale[]{
				new Locale("Marist", "Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", null, null),
				new Locale("Champagnat", "Champagnat is really loud tonight! Why is there a fire drill every weekend?", "Handbook", ". Everyone should read this!"),
				new Locale("Leo", "Leo seems like the place where all the rich children live. $$$", null, null),
				new Locale("Marian", "Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", "Dagger", ". That's pretty trippy, man!"),
				new Locale("Midrise", "Midrise is Midrise...yeah...", null, null),
				new Locale("Sheahan", "Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?", "Map", ". Not sure why you did not have one in the first place."),
				new Locale("Lower Townhouses", "Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.", "Apple", ". What a tasty treat!"),
				new Locale("Lower West Cedar Townhouses", "Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop.", null, null),
		}; 
		
		//method that will display the name of the game and description
		titleMessage();
		
		//method for allowing the user to customize their character
		Player.promptName();
		
		//the user will decide to start, get help or exit the game here
		System.out.println("\nPress the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		
		System.out.print("\nCurrent location: "+ Player.playerLocation +".");
		System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
		
		while(true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();
			
			//what happens when the user types in H
			if (input.equalsIgnoreCase("H")) {
				System.out.println("Press N to go North.");
				System.out.println("Press S to go South.");
				System.out.println("Press E to go East.");
				System.out.println("Press W to go West.");
				System.out.println("Press Q to quit the game.");
				System.out.println("Press T to take an item.");
				System.out.println("Press I to view your inventory.");
				System.out.println("Type 'Score' to display the score.");
			}
			
			//what happens when the user types in N
			else if (input.equalsIgnoreCase("N")) {
				if (Player.playerLocation == 0) {
					direction[0] = "North";
					Player.playerLocation = 1;
					//Locale.item = "Handbook";
					System.out.print("\nYou moved " + direction[0] + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
					System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + locale[Player.playerLocation].getItemDescription());
					}
				else if (input.equalsIgnoreCase("N") && Player.playerLocation == 3) {
					direction[0] = "North";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction[0] + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else if (input.equalsIgnoreCase("N") && Player.playerLocation == 7) {
					direction[0] = "North";
					Player.playerLocation = 3;
					//Locale.item = "Dagger";
					System.out.print("\nYou moved " + direction + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
					System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + locale[Player.playerLocation].getItem());
				}
				else {
					System.out.print("\nCannot move North anymore!");
				}
			}
			
			//what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				if (Player.playerLocation == 0){
					direction[1] = "South";
					Player.playerLocation = 3;
					//Locale.item = "Dagger";
					System.out.print("\nYou moved " + direction[1] + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
					System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + locale[Player.playerLocation].getItemDescription());
					}
				else if (input.equalsIgnoreCase("S") && Player.playerLocation == 1) {
					direction[1] = "South";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction[1] + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else if (input.equalsIgnoreCase("S") && Player.playerLocation == 3) {
					direction[1] = "South";
					Player.playerLocation = 7;
					System.out.print("\nYou moved " + direction[1] + ". ");
					System.out.print("Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
			}
				else 
					System.out.print("\nCannot move South anymore!");
			}
			
			//what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				if (Player.playerLocation == 0) {
					direction[2] = "East";
					Player.playerLocation = 4;
					System.out.print("\nYou moved " + direction[2] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
					}
				else if (input.equalsIgnoreCase("E") && Player.playerLocation == 5) {
					direction[2] = "East";
					Player.playerLocation = 2;
					System.out.print("\nYou moved " + direction[2] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else if (input.equalsIgnoreCase("E") && Player.playerLocation == 2) {
					direction[2] = "East";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction[2] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else if (input.equalsIgnoreCase("E") && Player.playerLocation == 4) {
					direction[2] = "East";
					Player.playerLocation = 6;
					//Locale.item = "Apple";
					System.out.print("\nYou moved " + direction[2] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
					System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + locale[Player.playerLocation].getItemDescription());
				}
				else 
					System.out.print("\nCannot move East anymore!");
			}
			
			//what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				if (Player.playerLocation == 0){
					direction[3] = "West";
					Player.playerLocation = 2;
					System.out.print("\nYou moved " + direction[3] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else if (input.equalsIgnoreCase("W") && Player.playerLocation==2) {
					direction[3] = "West" ;
					Player.playerLocation = 5;
					//Locale.item = "Map";
					System.out.print("\nYou moved " + direction[3] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
					System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + locale[Player.playerLocation].getItemDescription());
				}
				else if (input.equalsIgnoreCase("W") && Player.playerLocation == 4) {
					direction[3] = "West";
					Player.playerLocation = 0;
					System.out.print("\nYou moved " + direction[3] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else if (input.equalsIgnoreCase("W") && Player.playerLocation == 6) {
					direction[3] = "West";
					Player.playerLocation = 4;
					System.out.print("\nYou moved " + direction[3] + ". ");
					System.out.print(" Current location: "+ Player.playerLocation +".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " " + locale[Player.playerLocation].getLocationDescription());
				}
				else 
					System.out.print("\nCannot move West anymore!");
			}
				
			//what happens when the user types in Q
			else if (input.equalsIgnoreCase("Q")) {
				//closing message for the game
				showCredits();
				break;
			}
			
			//what happens when the user types in T
			else if (input.equalsIgnoreCase("T")) {
				if (Player.playerLocation == 3 && Locale.hasDagger == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Locale.hasDagger = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				}
				else if (Player.playerLocation == 3 && Locale.hasDagger == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (Player.playerLocation == 1 && Locale.hasHandbook == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Locale.hasHandbook = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				}
				else if (Player.playerLocation == 1 && Locale.hasHandbook == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (Player.playerLocation == 5 && Locale.hasMap == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Locale.hasMap = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				}
				else if (Player.playerLocation == 5 && Locale.hasMap == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (Player.playerLocation == 6 && Locale.hasApple == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Locale.hasApple = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				}
				else if (Player.playerLocation == 6 && Locale.hasApple == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
			}
			
			else if (input.equalsIgnoreCase("M") && Locale.hasMap == true) {
				System.out.println("                           ------------                                         ");
				System.out.println("                           |Champagnat|                                         ");
				System.out.println("                           ------------                                         ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("     ---------     -----     --------     ---------     ------------------      ");
				System.out.println("     |Sheahan|-----|Leo|-----|Marist|-----|Midrise|-----|Lower Townhouses|      ");
				System.out.println("     ---------     -----     --------     ---------     ------------------      ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            --------                                            ");
				System.out.println("                            |Marian|                                            ");
				System.out.println("                            --------                                            ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("                            	|                                               ");
				System.out.println("             	 -----------------------------                                  ");
				System.out.println("              	 |Lower West Cedar Townhouses|                                  ");
				System.out.println("              	 -----------------------------                                  ");
			}
			
			//what happens when the user types in score
			else if (input.equalsIgnoreCase("Score")) {
				System.out.print(Player.score);
			}
			
			else if (input.equalsIgnoreCase("I")) {
				System.out.print(Player.inventory);
			}
			
			//if the user types in any other keys not mentioned above, it will print this message
			else 
				System.out.println("Invalid command!\n");
				continue;
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