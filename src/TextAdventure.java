
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

public class TextAdventure {

	static ArrayList<Item> ChampItemList = new ArrayList<Item>();
	static ArrayList<Item> MarianItemList = new ArrayList<Item>();
	static ArrayList<Item> LowerTownhouseItemList = new ArrayList<Item>();
	static ArrayList<Item> SheahanItemList = new ArrayList<Item>();
	// make rest of arrayLists for locales with items
	// make rest of items
	static Item handbook = new Item("Handbook", " Everyone should read this!");
	static Item dagger = new Item("Dagger", " That's pretty trippy, man!");
	static Item apple = new Item("Apple", " What a tasty treat!");
	static Item map = new Item("Map", " Not sure why you did not have one in the first place.");

	static void populateArrayList(ArrayList<Item> list, Item item) {
		list.add(item);
	}

	// array of locale objects

	static Locale[] locale = new Locale[] {
			new Locale("Marist",
					"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", null),
			new Locale("Champagnat", "Champagnat is really loud tonight! Why is there a fire drill every weekend?",
					ChampItemList),
			new Locale("Leo", "Leo seems like the place where all the rich children live. $$$", null),
			new Locale("Marian",
					"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!",
					MarianItemList),
			new Locale("Midrise", "Midrise is Midrise...yeah...", null),
			new Locale("Sheahan",
					"Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?",
					SheahanItemList),
			new Locale("Lower Townhouses",
					"Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.",
					LowerTownhouseItemList),
			new Locale("Lower West Cedar Townhouses",
					"Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop.",
					null), };

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;

		// call populateArrayList method
		populateArrayList(ChampItemList, handbook);
		populateArrayList(MarianItemList, dagger);
		populateArrayList(SheahanItemList, map);
		populateArrayList(LowerTownhouseItemList, apple);

		// method that will display the name of the game and description
		titleMessage();

		// method for allowing the user to customize their character
		Player.promptName();

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
				Item.help();
			}

			// what happens when the user types in N
			else if (input.equalsIgnoreCase("N")) {
				Player.moveNorth();
			}

			// what happens when the user types in S
			else if (input.equalsIgnoreCase("S")) {
				Player.moveSouth();
			}

			// what happens when the user types in E
			else if (input.equalsIgnoreCase("E")) {
				Player.moveEast();
			}

			// what happens when the user types in W
			else if (input.equalsIgnoreCase("W")) {
				Player.moveWest();
			}

			// what happens when the user types in T
			else if (input.equalsIgnoreCase("T")) {
				take();
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
				int size = Player.inventory.size();
				int finalIndex = size - 1;

				for (int x = 0; x < size; x++) {
					if (x != finalIndex) {
						System.out.print(Player.inventory.get(x).item + ", ");
					} else {
						System.out.println(Player.inventory.get(x).item);
					}
				}
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

	public static void take() {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = locale[currLoc].getItemList();
		if (currentRoomList == null) {
			System.out.println("There is nothing to take.");
		} else if (currentRoomList != null && currentRoomList.isEmpty()) {
			System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
		} else {
			System.out.print("You obtained " + locale[Player.playerLocation].getItemList().get(0).item + "!");
			Player.inventory.add(currentRoomList.get(0));
			currentRoomList.remove(0);
			Player.score += 5;
			System.out.print(" Score: " + Player.score);
		}

	}

}