/*Trevor Pirone
 * CMPT 220L
 * Software Development 1
 * Project 3
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

	static ArrayList<Item> ChampItemList = new ArrayList<Item>();
	static ArrayList<Item> MarianItemList = new ArrayList<Item>();
	static ArrayList<Item> LowerTownhouseItemList = new ArrayList<Item>();
	static ArrayList<Item> SheahanItemList = new ArrayList<Item>();
	static ArrayList<Item> BlankList = new ArrayList<Item>();
	static BreadcrumbTrail trail;
	// make rest of arrayLists for locales with items
	// make rest of items
	static Item handbook = new Item("Handbook", " Everyone should read this!", false, 5);
	static Item dagger = new Item("Liquid Silicone Dagger", " That's pretty trippy, man!", false, 5);
	static Item apple = new Item("Apple", " What a tasty treat!", false, 5);
	static Item map = new Item("Map", " Not sure why you did not have one in the first place.", false, 5);

	// method for populateArrayList which takes the items and adds them to the
	// location to be picked up
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
			new Locale("Marian", "Marian is home to the Hobbit and the hermits. Sure seems clicky around here.",
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

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
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

		// method to call a new Breadcrumb Trail
		trail.startTrail();

		// method that begins the game
		startGame();

		System.out.print("\nCurrent location: " + Player.playerLocation + ".");
		System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
				+ locale[Player.playerLocation].getLocationDescription());

		while (true) {
			System.out.print("\nEnter a command: ");
			input = inputSource.nextLine();

			// what happens when the user types in H
			if (input.equalsIgnoreCase("H")) {
				Item.showHelp();
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
				Item.takeItem();
			}
			
			// what happens when the user types in U
			else if (input.equalsIgnoreCase("U")) {
				LimitedUseItem.useItem();
			}
			
			// what happens when the user types in U and has a map
			else if (input.equalsIgnoreCase("U") && Player.hasMap() == true) {
				Item.containsMap();
			}
			
			// what happens when the user types in U and does not have a map
			else if (input.equalsIgnoreCase("U") && Player.hasMap() == false) {
				System.out.println("I wish I knew where I was right now... -____-");
			}
			
			// what happens when the user types in X
			else if (input.equalsIgnoreCase("X")) {
				Item.examineItem();
			}


			// prints out a map if the user has it by typing M
			else if (input.equalsIgnoreCase("M") && Player.hasMap() == true) {
				Item.containsMap();
			}

			/* if the user types in M and does not have the map, this will print
		    out instead*/
			else if (input.equalsIgnoreCase("M") && Player.hasMap() == false) {
				System.out.println("I wish I knew where I was right now... -____-");
			}

			// what happens when the user types in score
			else if (input.equalsIgnoreCase("Score")) {
				System.out.print(Player.score);
			}

			// what happens when the user types in I
			else if (input.equalsIgnoreCase("I")) {
				Item.showInventory();
			}

			// what happens when the user types in D
			else if (input.equalsIgnoreCase("D")) {
				Item.dropItem();
			}

			// what happens when the user types in B
			else if (input.equalsIgnoreCase("B")) {
				if (BreadcrumbTrail.currCrumb == -1 || BreadcrumbTrail.hasNoMoreCrumbs() == true) {
					System.out.print(
							"That's funny. There's no going back! You can't escape now! The hungry rats are after you!");
				} else {
					Player.backtrackLocale(trail);
					System.out.print("\nCurrent location: " + Player.playerLocation + ".");
					System.out.print(" You are now in " + locale[Player.playerLocation].getLocation() + "." + " "
							+ locale[Player.playerLocation].getLocationDescription());
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

	// prints a greeting message when the user runs the program
	private static void titleMessage() {
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

	// the user will decide to start, get help or exit the game here
	private static void startGame() {
		System.out.println("\nPress the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If by mistake you opened this application, press Q on the keyboard to quit the game.");
		System.out.println(
				"As of now, you are only allowed to backtrack a maximum of ten times before the rats eat the breadcrumbs!");
		System.out.println("USe your backtracks wisely! The breadcrumbs go away in a short time!");
	}

}