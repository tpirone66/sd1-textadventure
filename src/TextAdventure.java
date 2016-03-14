/*Trevor Pirone
 * CMPT 220L
 * Software Development 1
 * Project 1
 * Text Adventure Game v0.3
 * 
 * A text adventure based game created by @author Trevor Pirone
 */

import java.util.Scanner;//used for reading user input on the keyboard
import java.util.ArrayList;
import java.util.Random;//will be used later on for random generation
import java.io.*;
@SuppressWarnings("unused")

public class TextAdventure {

	static ArrayList<Item> ChampItemList = new ArrayList<Item>();
	static ArrayList<Item> MarianItemList = new ArrayList<Item>();
	static ArrayList<Item> LowerTownhouseItemList = new ArrayList<Item>();
	static ArrayList<Item> SheahanItemList = new ArrayList<Item>();
	static ArrayList<Item> BlankList = new ArrayList<Item>();
	// make rest of arrayLists for locales with items
	// make rest of items
	static Item handbook = new Item("Handbook", " Everyone should read this!");
	static Item dagger = new Item("Dagger", " That's pretty trippy, man!");
	static Item apple = new Item("Apple", " What a tasty treat!");
	static Item map = new Item("Map", " Not sure why you did not have one in the first place.");

	//method for populateArrayList which takes the items and adds them to the location to be picked up
	static void populateArrayList(ArrayList<Item> list, Item item) {
		list.add(item);
	}

	// array of locale objects
	static Locale[] locale = new Locale[] {
			new Locale("Marist",
					"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", BlankList),
			new Locale("Champagnat", "Champagnat is really loud tonight! Why is there a fire drill every weekend?",
					ChampItemList),
			new Locale("Leo", "Leo seems like the place where all the rich children live. $$$", BlankList),
			new Locale("Marian",
					"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!",
					MarianItemList),
			new Locale("Midrise", "Midrise is Midrise...yeah...", BlankList),
			new Locale("Sheahan",
					"Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?",
					SheahanItemList),
			new Locale("Lower Townhouses",
					"Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.",
					LowerTownhouseItemList),
			new Locale("Lower West Cedar Townhouses",
					"Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop.",
					BlankList), };

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;

		// call populateArrayList method
		populateArrayList(ChampItemList, handbook);
		populateArrayList(MarianItemList, dagger);
		populateArrayList(SheahanItemList, map);
		populateArrayList(LowerTownhouseItemList, apple);
		
		// navigation matrix map
				int[][] Map = {
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
		
		//method to call a new Breadcrumb trail
		BreadcrumbTrail.startTrail();

		// method that begins the game
		startGame();

		System.out.print("\nCurrent location: " + Player.playerLocation + ".");
		System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
				+ locale[Player.playerLocation].getLocationDescription());
		System.out.print("\nYou found nothing. There is nothing here.");

		while (true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();

			// what happens when the user types in H
			if (input.equalsIgnoreCase("H")) {
				Item.showHelp();
			}

			// what happens when the user types in N
			else if (input.equalsIgnoreCase("N")) {
				if (Map[Player.playerLocation][0] != -1) {
					BreadcrumbTrail.dropCrumb(Player.playerLocation);
					Player.playerLocation = Map[Player.playerLocation][0];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItemList().size() == 0) {
						System.out.print("\nYou found nothing. There is nothing here." );
					} 
					else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItemList().get(0).item + "."
								+ locale[Player.playerLocation].getItemList().get(0).itemDescription);
					}
				} 
				else if (Map[Player.playerLocation][0] == -1) {
					System.out.print("\nCannot move that way!");
				}
				//Player.moveNorth();
			}

			// what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				if (Map[Player.playerLocation][1] != -1) {
					BreadcrumbTrail.dropCrumb(Player.playerLocation);
					Player.playerLocation = Map[Player.playerLocation][1];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItemList().size() == 0) {
						System.out.print("\nYou found nothing. There is nothing here.");
					} 
					else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItemList().get(0).item + "."
								+ locale[Player.playerLocation].getItemList().get(0).itemDescription);
					}
				} 
				else if (Map[Player.playerLocation][1] == -1) {
					System.out.print("\nCannot move that way!");
				}
				//Player.moveSouth();
			}

			// what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				if (Map[Player.playerLocation][2] != -1) {
					BreadcrumbTrail.dropCrumb(Player.playerLocation);
					Player.playerLocation = Map[Player.playerLocation][2];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItemList().size() == 0) {
						System.out.print("\nYou found nothing. There is nothing here.");
					} 
					else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItemList().get(0).item + "."
								+ locale[Player.playerLocation].getItemList().get(0).itemDescription);
					}
				} 
				else if (Map[Player.playerLocation][2] == -1) {
					System.out.print("\nCannot move that way!");
				}
				//Player.moveEast();
			}

			// what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				if (Map[Player.playerLocation][3] != -1) {
					BreadcrumbTrail.dropCrumb(Player.playerLocation);
					Player.playerLocation = Map[Player.playerLocation][3];
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
					if (locale[Player.playerLocation].getItemList().size() == 0) {
						System.out.print("\nYou found nothing. There is nothing here.");
					} 
					else {
						System.out.print("\nYou found " + locale[Player.playerLocation].getItemList().get(0).item + "."
								+ locale[Player.playerLocation].getItemList().get(0).itemDescription);
					}
				} 
				else if (Map[Player.playerLocation][3] == -1) {
					System.out.print("\nCannot move that way!");
				}
				//Player.moveWest();
			}

			// what happens when the user types in T
			else if (input.equalsIgnoreCase("T")) {
				Item.takeItem();
			}

			// prints out a map if the user has it by typing M
			else if (input.equalsIgnoreCase("M")) {
				Item.hasMap();
			}
				
			// what happens when the user types in score
			else if (input.equalsIgnoreCase("Score")) {
				System.out.print(Player.score);
			}
			
			//what happens when the user types in I
			else if (input.equalsIgnoreCase("I")) {
				Item.showInventory();
			}
			
			//what happens when the user types in D
			else if (input.equalsIgnoreCase("D")) {
				Item.dropItem();
			}
			
			//what happens when the user types in B
			else if (input.equalsIgnoreCase("B")) {
				Player.backtrackLocale();
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