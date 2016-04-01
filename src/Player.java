//Player class for Marist Mayhem

//anywhere it mentions @SupressWarnings, ignore it

import java.util.Scanner;
import java.util.ArrayList;

public class Player {

	Scanner inputSource = new Scanner(System.in);
	// Some of the player variables that will be in this class
	static String name;
	static int playerLocation = 0;
	static ArrayList<Item> inventory = new ArrayList<>();
	static int score = 0;

	// will check to see if the player has a map in the inventory
	public static boolean hasMap() {
		int size = inventory.size();
		for (int i = 0; i < size; i++) {
			if (inventory.get(i).equals(TextAdventure.map)) {
				return true;
			}
		}
		return false;
	}

	// navigation matrix map
	static int[][] Map = {
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
	
	//variables for move commands
	
	
	@SuppressWarnings("static-access")
	public static void moveNorth() {
		if (Map[Player.playerLocation][0] != -1) {
			TextAdventure.trail.dropCrumb(Player.playerLocation);
			Player.playerLocation = Map[Player.playerLocation][0];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.place + "." + " "
					+ TextAdventure.location);
			if (TextAdventure.itemList == 0) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} else {
				System.out.print("\nYou found " + TextAdventure.item
						+ "." + TextAdventure.description);
			}
		} else if (Map[Player.playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	@SuppressWarnings("static-access")
	public static void moveSouth() {
		if (Map[Player.playerLocation][1] != -1) {
			TextAdventure.trail.dropCrumb(Player.playerLocation);
			Player.playerLocation = Map[Player.playerLocation][0];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.place + "." + " "
					+ TextAdventure.location);
			if (TextAdventure.itemList == 0) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} else {
				System.out.print("\nYou found " + TextAdventure.item
						+ "." + TextAdventure.description);
			}
		} else if (Map[Player.playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	@SuppressWarnings("static-access")
	public static void moveEast() {
		if (Map[Player.playerLocation][2] != -1) {
			TextAdventure.trail.dropCrumb(Player.playerLocation);
			Player.playerLocation = Map[Player.playerLocation][0];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.place + "." + " "
					+ TextAdventure.location);
			if (TextAdventure.itemList == 0) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} else {
				System.out.print("\nYou found " + TextAdventure.item
						+ "." + TextAdventure.description);
			}
		} else if (Map[Player.playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	@SuppressWarnings("static-access")
	public static void moveWest() {
		if (Map[Player.playerLocation][3] != -1) {
			TextAdventure.trail.dropCrumb(Player.playerLocation);
			Player.playerLocation = Map[Player.playerLocation][0];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.place + "." + " "
					+ TextAdventure.location);
			if (TextAdventure.itemList == 0) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} else {
				System.out.print("\nYou found " + TextAdventure.item
						+ "." + TextAdventure.description);
			}
		} else if (Map[Player.playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}
	/*
	 * promptName() method
	 * @param input takes what the user types in
	 * @param name is then set to equal the input.
	 */
	public static void promptName() {
		// method that will allow character customization
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		name = input;
		System.out.println("Hello, " + name + "!");
	}

	public static int getPlayerLocation() {
		return Player.playerLocation;
	}

	// method for backtracking breadcrumbs
	@SuppressWarnings("static-access")
	public static void backtrackLocale(BreadcrumbTrail trail) {
		if (BreadcrumbTrail.hasNoMoreCrumbs() == false) {
			playerLocation = trail.pickupCrumb();
		}
	}
}