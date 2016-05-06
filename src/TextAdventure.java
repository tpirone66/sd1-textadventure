/**Trevor Pirone
 * CMPT 220L
 * Software Development 1
 * Project 4
 * Text Adventure Game v0.7
 * 
 * A text adventure based game created by @author Trevor Pirone
 */

//anywhere it mentions @SupressWarnings, ignore it

import java.util.Scanner;//used for reading user input on the keyboard
import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;//will be used later on for random generation
import java.io.*;

@SuppressWarnings("unused")

public class TextAdventure {

	// items
	static ArrayList<Item> ChampItemList = new ArrayList<Item>();
	static ArrayList<Item> MarianItemList = new ArrayList<Item>();
	static ArrayList<Item> LowerTownhouseItemList = new ArrayList<Item>();
	static ArrayList<Item> SheahanItemList = new ArrayList<Item>();
	static ArrayList<Item> BlankList = new ArrayList<Item>();
	static ArrayList<Item> HudsonRiverList = new ArrayList<Item>();
	static BreadcrumbTrail trail;
	static Item handbook = new Item("Handbook", " Everyone should read this!", false, 5);
	static Item dagger = new LimitedUseItem("Dagger", " A liquid silicone dagger to be exact! That's pretty trippy, man!", false, 5, 5);
	static Item apple = new LimitedUseItem("Apple", " What a tasty treat!", false, 5, 5);
	static Item map = new Item("Map", " Not sure why you did not have one in the first place.", false, 5);
	static Item key = new Item("Key", " I wonder what this could be for?", false, 5);
	int currLoc = Player.getPlayerLocation();

	// method for populateArrayList which takes the items and adds them to the
	// location to be picked up
	static void populateArrayList(ArrayList<Item> list, Item item) {
		list.add(item);
	}

	// array of locale objects
	static Locale[] locale = new Locale[] {
			new Locale("Marist",
					"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", BlankList, false),
			new Locale("Champagnat", "Champagnat is really loud tonight! Why is there a fire drill every weekend?",
					ChampItemList, false),
			new Locale("Leo", "Leo seems like the place where all the rich children live. $$$", BlankList, false),
			new Locale("Marian", "Marian is home to the Hobbit and the hermits. Sure seems clicky around here.",
					MarianItemList, false),
			new Locale("Midrise", "Midrise is Midrise...yeah...", BlankList, false),
			new Locale("Sheahan",
					"Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?",
					SheahanItemList, false),
			new Locale("Lower Townhouses",
					"Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.",
					LowerTownhouseItemList, false),
			new Locale("Lower West Cedar Townhouses",
					"Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop.",
					BlankList, false),
			new Locale("Hudson River",
					"The best looking polluted river on the planet! All of the Marist students should take a trip to here.",
					HudsonRiverList, false),
			new SecureLocale("Hancock Center",
					"The world's famous Nerd Palace! What a wonderful site! Let's explore it now.", BlankList, key, false),
			new SecureLocale("The Magical Wizard's House", "Home to world famous programmer Matthew Johnson!",
					BlankList, handbook, false) };
	static Locale currRoom = locale[Player.playerLocation];

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input = "";

		// call populateArrayList method
		populateArrayList(ChampItemList, handbook);
		populateArrayList(MarianItemList, dagger);
		populateArrayList(SheahanItemList, map);
		populateArrayList(LowerTownhouseItemList, apple);
		populateArrayList(HudsonRiverList, key);

		// method that will display the name of the game and description
		titleMessage();

		// method for allowing the user to name their character
		Player.promptName();

		// method to call a new Breadcrumb Trail
		BreadcrumbTrail trail = new BreadcrumbTrail();

		// method that begins the game
		startGame();

		System.out.print("\nCurrent location: " + Player.playerLocation + ".");
		System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
				+ locale[Player.playerLocation].getLocationDescription());

		while (true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();
			String[] inputParts = input.split(" ", 2);
			String part1 = inputParts[0];

			// what happens when the user types in H
			if (part1.equalsIgnoreCase("H")) {
				Item.showHelp();
			}

			// what happens when the user types in N
			else if (part1.equalsIgnoreCase("N")) {
				Player.moveNorth(trail);
			}

			// what happens when the user types in S
			else if (part1.equalsIgnoreCase("S")) {
				Player.moveSouth(trail);
			}

			// what happens when the user types in E
			else if (part1.equalsIgnoreCase("E")) {
				Player.moveEast(trail);
			}

			// what happens when the user types in W
			else if (part1.equalsIgnoreCase("W")) {
				Player.moveWest(trail);
			}

			// what happens when the user types in X
			else if (part1.equalsIgnoreCase("X")) {
				Item.examineItem();
			}
			
			// what happens when the user types in T
			else if (part1.equalsIgnoreCase("T")) {
				// check if the input parts array has another element (check the length)
				if (inputParts.length > 1) {
					String part2 = inputParts[1];
					Item.takeItem(part2);
				}
				else {
					String part2 = null;
					Item.promptTakeItem();
				}
			}
				
			// what happens when the user types in U
			else if (part1.equalsIgnoreCase("U")) {
				if (inputParts.length > 1) {
					String part2 = inputParts[1];
					LimitedUseItem.useItem(part2);
				}
				else {
					String part2 = null;
					LimitedUseItem.promptUseItem();
				}
			}
			
			// what happens when the user types in D
			else if (part1.equalsIgnoreCase("D")) {
				if (inputParts.length > 1) {
					String part2 = inputParts[1];
					Item.dropItem(part2);
				}
				else {
					String part2 = null;
					Item.promptDropItem();;
				}
			}

			// prints out a map if the user has it by typing M
			else if (part1.equalsIgnoreCase("M")) {
				if (Player.hasMap() == true) {
					Item.containsMap();
				}
				// this statement will print out if the user does not have the map
				else {
					System.out.println("I wish I knew where I was right now... -____-");
				}
			}
			
			// prints out the handbook if the user has it by typing R
			else if (part1.equalsIgnoreCase("R")) {
				if (Player.hasHandbook() == true) {
					Item.containsHandbook();
				}
				// this statement will print out if the user does not have the handbook
				else {
					System.out.print("It does not look like there is anything for you to read, " + Player.name + "!");
				}
			}
			
			// what happens when the user types in B
			else if (part1.equalsIgnoreCase("B")) {
				Player.callBacktrack(trail);
			}
			
			// what happens when the user types in score
			else if (part1.equalsIgnoreCase("Score")) {
				System.out.print(Player.score);
			}

			// what happens when the user types in I
			else if (part1.equalsIgnoreCase("I")) {
				Item.showInventory();
			}
			
			//what happens when the user types in speak
			else if (part1.equalsIgnoreCase("Speak")) {
				// the player speaks to the wizard
				if (Player.playerLocation == 10) {
					System.out.print("\nMatthew Johnson the Wizard: It is a pleasure to see you here, " + Player.name
							+ ". I would really appreciate it if you could give me the handbook in your inventory!");
				}
				else {
					// the player will speak to the rats
					System.out.print("\nRats: We're on to you, " + Player.name + "!");
				}
			}
			
			// what happens when the user types in Q
			else if (part1.equalsIgnoreCase("Q")) {
				// closing message for the game
				showCredits();
				break;
			}

			// if the user types in any other keys not mentioned above, it will print this message
			else {
				System.out.print("\nInvalid command!");
			}
		}
	}

	// prints a greeting message when the user runs the program
	private static void titleMessage() {
		System.out.println("Welcome to Marist Mayhem!");
		System.out.println("-----------------------------------");
		System.out.println(
				"Marist Mayhem is a text-adventure game where the user will explore the scary grounds of Marist and try to\nfind out what is happening on the campus and revert it back to normal.");
		System.out.println("-----------------------------------");
	}

	// this method will show the credits at the end of the game or when the user quits
	static void showCredits() {
		System.out.println("\nThank you for playing this game!");
		System.out.println("\nPlease come back soon!\n");
		System.out.println("Trevor Pirone Copyright 2016");
	}

	// the user will decide to start, get help or exit the game here
	private static void startGame() {
		System.out.println("\nPress the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		System.out.println("As of now, you are only allowed to backtrack a maximum of ten times before "
				+ "the rats eat all the breadcrumbs and catch you!");
		System.out.println("Use your backtracks wisely! The breadcrumbs go away in a short time!");
	}

	// the method is called after the user opens Hancock with the key and will precede with the closing of the game
	public static void endGame() {
		System.out.println(" However, there is a password one must solve to enter the Hancock Center.");
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		// the user must type in the correct password to enter Hancock into the
		// wizard's house
		if (input.equals("Matthew Johnson")) {
			Player.playerLocation = 10;
			System.out.print("\nCongratulations! You were able to enter into the 'Nerd's Palace'!");
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
					+ locale[Player.playerLocation].getLocationDescription());
		}
		// prints out a statement if the user does not have the password
		if (!input.equals("Matthew Johnson")) {
			System.out.print("That is not the correct password to enter! "
					+ "\nThere has to be some kind of clue somewhere...");
		}
	}

	// the victory message will display if the user gives the handbook to the Wizard
	public static void victoryMessage() {
		System.out.print("Matthew Johnson: Thank you for returning my precious handbook to me!");
		System.out.print("\nMatthew Johnson: Those rats thought they could just take my book without any punishment!");
		System.out.print("\nMatthew Johnson: You definitely deserve a good reward for this!");
		System.out.print("\nMatthew Johnson: Here is your reward!");
		Player.score = Player.score + 10;
		System.out.print("\nScore: " + Player.score);
		showCredits();
		System.exit(0);
	}

	/* the failure message will display if the user does not have the handbook to give to the Wizard
	 * they will also be sent back to the beginning of the game and lose 10 points
	 */
	public static void failureMessage() {
		System.out.print("Matthew Johnson: It seems that you do not have what I am looking for!");
		System.out.print("\nMatthew Johnson: The rats still have my book!");
		System.out.print("\nMatthew Johnson: You need to go find it right this second!");
		System.out.print("\nMatthew Johnson: Goodbye! Abracadabra!");
		Player.score = Player.score - 10;
		System.out.print("\nScore: " + Player.score);
		Player.playerLocation = 0;
		System.out.print("\nCurrent location: " + Player.playerLocation + ".");
		System.out.print(" You are now in " + currRoom.getLocation() + "." + " "
				+ currRoom.getLocationDescription());
	}

}