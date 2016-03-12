
/*Trevor Pirone
 * CMPT 220L
 * Software Development 1
 * Project 1
 * Text Adventure Game v0.3
 * 
 * A text adventure based game created by @author Trevor Pirone
 */

import java.util.Scanner;//used for reading user input on the keyboard

import java.util.Random;//will be used later on for random generation

import java.io.*;

public class TextAdventure {

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;

		// array of locale objects
		Locale[] locale = new Locale[] {
				new Locale("Marist",
						"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", null,
						" Nothing here."),
				new Locale("Champagnat", "Champagnat is really loud tonight! Why is there a fire drill every weekend?",
						"Handbook", " Everyone should read this!"),
				new Locale("Leo", "Leo seems like the place where all the rich children live. $$$", null,
						" Nothing here."),
				new Locale("Marian",
						"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!",
						"Dagger", " That's pretty trippy, man!"),
				new Locale("Midrise", "Midrise is Midrise...yeah...", null, " Nothing here."),
				new Locale("Sheahan",
						"Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?",
						"Map", " Not sure why you did not have one in the first place."),
				new Locale("Lower Townhouses",
						"Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.",
						"Apple", " What a tasty treat!"),
				new Locale("Lower West Cedar Townhouses",
						"Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop.",
						null, " Nothing here."), };

		// navigation matrix map
		int[][] map = {
				// N S E W
				{ 1, 3, 4, 2 }, // Marist
				{ -1, 0, -1, -1 }, // Champagnat
				{ -1, -1, 0, 5 }, // Leo
				{ 0, 7, -1, -1 }, // Marian
				{ -1, -1, 6, 0 }, // Midrise
				{ -1, -1, 2, -1 }, // Sheahan
				{ -1, -1, -1, 4 }, // Lower Townhouses
				{ 3, -1, -1, -1 },// Lower West Cedar Townhouses
		};

		// method that will display the name of the game and description
		titleMessage();

		// method for allowing the user to customize their character
		Player.promptName();

		// method that begins the game
		startGame();

		System.out.print("\nCurrent location: " + Player.playerLocation + ".");
		System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
				+ locale[Player.playerLocation].getLocationDescription());
		System.out.print("\nYou found nothing." + locale[Player.playerLocation].getItemDescription());

		while (true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();

			// what happens when the user types in H
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

			// what happens when the user types in N
			else if (input.equalsIgnoreCase("N")) {
				if (map[Player.playerLocation][0] != -1) {
					Player.playerLocation = map[Player.playerLocation][0];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItem() == null) {
						System.out.print("\nYou found nothing." + locale[Player.playerLocation].getItemDescription());
					} else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + "."
								+ locale[Player.playerLocation].getItemDescription());
					}
				} else if (map[Player.playerLocation][0] == -1) {
					System.out.print("\nCannot move that way!");
				}
			}

			// what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				if (map[Player.playerLocation][1] != -1) {
					Player.playerLocation = map[Player.playerLocation][1];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItem() == null) {
						System.out.print("\nYou found nothing." + locale[Player.playerLocation].getItemDescription());
					} else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + "."
								+ locale[Player.playerLocation].getItemDescription());
					}
				} else if (map[Player.playerLocation][1] == -1) {
					System.out.print("\nCannot move that way!");
				}
			}

			// what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				if (map[Player.playerLocation][2] != -1) {
					Player.playerLocation = map[Player.playerLocation][2];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItem() == null) {
						System.out.print("\nYou found nothing." + locale[Player.playerLocation].getItemDescription());
					} else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + "."
								+ locale[Player.playerLocation].getItemDescription());
					}
				} else if (map[Player.playerLocation][2] == -1) {
					System.out.print("\nCannot move that way!");
				}
			}

			// what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				if (map[Player.playerLocation][3] != -1) {
					Player.playerLocation = map[Player.playerLocation][3];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItem() == null) {
						System.out.print("\nYou found nothing." + locale[Player.playerLocation].getItemDescription());
					} else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItem() + "."
								+ locale[Player.playerLocation].getItemDescription());
					}
				} else if (map[Player.playerLocation][3] == -1) {
					System.out.print("\nCannot move that way!");
				}
			}

			// what happens when the user types in T
			else if (input.equalsIgnoreCase("T")) {
				if (Player.playerLocation == 3 && Item.hasDagger == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Item.hasDagger = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				} else if (Player.playerLocation == 3 && Item.hasDagger == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (Player.playerLocation == 1 && Item.hasHandbook == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Item.hasHandbook = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				} else if (Player.playerLocation == 1 && Item.hasHandbook == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (Player.playerLocation == 5 && Item.hasMap == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Item.hasMap = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				} else if (Player.playerLocation == 5 && Item.hasMap == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (Player.playerLocation == 6 && Item.hasApple == false) {
					System.out.print("You obtained " + locale[Player.playerLocation].getItem() + "!");
					Item.hasApple = true;
					Player.inventory.add(locale[Player.playerLocation].getItem());
					Player.score += 5;
					System.out.print(" Score: " + Player.score);
				} else if (Player.playerLocation == 6 && Item.hasApple == true) {
					System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
				}
				if (locale[Player.playerLocation].getItem() == null) {
					System.out.print("There is nothing to take.");
				}
			}

			// prints out a map if the user has it by typing M
			else if (input.equalsIgnoreCase("M") && Item.hasMap == true) {
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

			// what happens when the user types in score
			else if (input.equalsIgnoreCase("Score")) {
				System.out.print(Player.score);
			}

			else if (input.equalsIgnoreCase("I")) {
				System.out.print(Player.inventory);
			}

			// what happens when the user types in Q
			else if (input.equalsIgnoreCase("Q")) {
				// closing message for the game
				showCredits();
				break;
			}

			// if the user types in any other keys not mentioned above, it will
			// print this message
			else {
				System.out.print("\nInvalid command!");
			}
		}
	}

	private static void titleMessage() {
		// prints a greeting message when the user runs the program
		System.out.println("Welcome to Marist Mayhem!");
		System.out.println("-----------------------------------");
		System.out.println(
				"Marist Mayhem is a text-adventure game where the user will explore the scary grounds of Marist and try to\nfind out what is happening on the campus and revert it back to normal.");
		System.out.println("-----------------------------------");
	}

	private static void showCredits() {
		System.out.println("Thank you for playing this game!");
		System.out.println("Please come back soon!\n");
		System.out.println("Trevor Pirone Copyright 2016");
	}

	private static void startGame() {
		// the user will decide to start, get help or exit the game here
		System.out.println("\nPress the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
	}

}