/**Player class for Marist Mayhem*/

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
	static int actionCount = 10;
	static int passwordCount = 5;

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

	// will check to see if the player has a handbook in the inventory
	public static boolean hasHandbook() {
		int size = inventory.size();
		for (int i = 0; i < size; i++) {
			if (inventory.get(i).equals(TextAdventure.handbook)) {
				return true;
			}
		}
		return false;
	}
	
	//will check to see if the player has a key in their inventory
	public static boolean hasKey() {
		int size = inventory.size();
		for (int i = 0; i < size; i++) {
			if (inventory.get(i).equals(TextAdventure.key)) {
				return true;
			}
		}
		return false;
	}

	// navigation matrix map
	static int[][] Map = {
			// N S E W
			{ 1, 3, 4, 2 }, // Marist
			{ 8, 0, -1, -1 }, // Champagnat
			{ -1, -1, 0, 5 }, // Leo
			{ 0, 7, -1, -1 }, // Marian
			{ -1, -1, 6, 0 }, // Midrise
			{ -1, -1, 2, -1 }, // Sheahan
			{ -1, 9, -1, 4 }, // Lower Townhouses
			{ 3, -1, -1, -1 }, // Lower West Cedar Townhouses
			{ -1, 1, -1, -1 }, // Hudson River
			{ 6, -1, -1, -1 }, // Hancock Center
			{ -1, -1, -1, -1 }, // The Magical Wizard's House
	};

	// the player moves north when the user types "N"
	public static void moveNorth() {
		if (Map[playerLocation][0] != -1) {
			BreadcrumbTrail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][0];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.locale[playerLocation].getLocation() + "." + " "
					+ TextAdventure.locale[playerLocation].getLocationDescription());
		} else if (Map[playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// the player moves south when the user types "S"
	public static void moveSouth() {
		if (Map[playerLocation][1] != -1) {
			BreadcrumbTrail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][1];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.locale[playerLocation].getLocation() + "." + " "
					+ TextAdventure.locale[playerLocation].getLocationDescription());
		} else if (Map[playerLocation][1] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// the player moves east when the user types "E"
	public static void moveEast() {
		if (Map[playerLocation][2] != -1) {
			BreadcrumbTrail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][2];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.locale[playerLocation].getLocation() + "." + " "
					+ TextAdventure.locale[playerLocation].getLocationDescription());
		} else if (Map[playerLocation][2] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// the player moves west when the user types "W"
	public static void moveWest() {
		if (Map[playerLocation][3] != -1) {
			BreadcrumbTrail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][3];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out.print(" You are now in " + TextAdventure.locale[playerLocation].getLocation() + "." + " "
					+ TextAdventure.locale[playerLocation].getLocationDescription());
		} else if (Map[playerLocation][3] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// method that will allow character customization
	public static void promptName() {
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		name = input;
		System.out.println("Hello, " + name + "!");
	}

	// method that returns the player's location
	public static int getPlayerLocation() {
		return playerLocation;
	}

	// method for backtracking breadcrumbs
	public static void backtrackLocale(BreadcrumbTrail trail) {
		if (BreadcrumbTrail.hasNoMoreCrumbs() == false) {
			playerLocation = BreadcrumbTrail.pickupCrumb();
		}
	}

}