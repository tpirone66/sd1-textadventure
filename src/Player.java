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
	//static Locale currRoom = TextAdventure.locale[Player.playerLocation];

	/**
	 * @return will return the handbook if it is in the inventory
	 */
	public static boolean hasMap() {
		int size = inventory.size();
		for (int i = 0; i < size; i++) {
			if (inventory.get(i).equals(TextAdventure.map)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return will return the handbook if it is in the inventory
	 */
	public static boolean hasHandbook() {
		int size = inventory.size();
		for (int i = 0; i < size; i++) {
			if (inventory.get(i).equals(TextAdventure.handbook)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return will return the key if it is in the inventory
	 */
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
	/**
	 * @param trail
	 *            will drop a crumb at the previous locale if the player wants
	 *            to backtrack if they are able to move north, this method will
	 *            allow them to do so or they will be told that they cannot move
	 *            that way
	 */
	public static void moveNorth(BreadcrumbTrail trail) {
		if (Map[playerLocation][0] != -1) {
			trail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][0];
			Locale currRoom = TextAdventure.locale[Player.playerLocation];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out
					.print(" You are now in " + currRoom.getLocation() + "." + " " + currRoom.getLocationDescription());
		} else if (Map[playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// the player moves south when the user types "S"
	/**
	 * @param trail
	 *            will drop a crumb at the previous locale if the player wants
	 *            to backtrack if they are able to move north, this method will
	 *            allow them to do so or they will be told that they cannot move
	 *            that way
	 */
	public static void moveSouth(BreadcrumbTrail trail) {
		if (Map[playerLocation][1] != -1) {
			trail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][1];
			Locale currRoom = TextAdventure.locale[Player.playerLocation];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out
					.print(" You are now in " + currRoom.getLocation() + "." + " " + currRoom.getLocationDescription());
		} else if (Map[playerLocation][1] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// the player moves east when the user types "E"
	/**
	 * @param trail
	 *            will drop a crumb at the previous locale if the player wants
	 *            to backtrack if they are able to move north, this method will
	 *            allow them to do so or they will be told that they cannot move
	 *            that way
	 */
	public static void moveEast(BreadcrumbTrail trail) {
		if (Map[playerLocation][2] != -1) {
			trail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][2];
			Locale currRoom = TextAdventure.locale[Player.playerLocation];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out
					.print(" You are now in " + currRoom.getLocation() + "." + " " + currRoom.getLocationDescription());
		} else if (Map[playerLocation][2] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}

	// the player moves west when the user types "W"
	/**
	 * @param trail
	 *            will drop a crumb at the previous locale if the player wants
	 *            to backtrack if they are able to move north, this method will
	 *            allow them to do so or they will be told that they cannot move
	 *            that way
	 */
	public static void moveWest(BreadcrumbTrail trail) {
		if (Map[playerLocation][3] != -1) {
			trail.dropCrumb(playerLocation);
			playerLocation = Map[playerLocation][3];
			Locale currRoom = TextAdventure.locale[Player.playerLocation];
			System.out.print("\nCurrent location: " + playerLocation + ".");
			System.out
					.print(" You are now in " + currRoom.getLocation() + "." + " " + currRoom.getLocationDescription());
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
		if (name.equals("Matthew Johnson")) {
			System.out.print("You're a god! You automatically win the game!");
			Player.score = 2147483647;
			System.out.print("\nScore: " + Player.score);
			TextAdventure.showCredits();
			System.exit(0);
		} else if (name.equals("Nick Barranco")) {
			System.out.print("You're a schmuck! You automatically lose the game!");
			System.out.print("\nGAME OVER!");
			Player.score = -2147483648;
			System.out.print("\nScore: " + Player.score);
			TextAdventure.showCredits();
			System.exit(0);
		} else {
			System.out.println("Hello, " + name + "!");
		}
	}

	// the method is used when the player wants to backtrack
	/**
	 * @param trail
	 *            once a crumb has been dropped, a player has the ability to
	 *            backtrack, but if they run out of crumbs, they will not be
	 *            able to backtrack and too many backtracks will cause the
	 *            player
	 * 
	 */
	public static void callBacktrack(BreadcrumbTrail trail) {
		// the player loses when they backtrack too much
		if (trail.currCrumb == -1 && trail.hasNoMoreCrumbs() == true && Player.actionCount == 0) {
			System.out.print("Oh no! The rats got you! You are now left to die!");
			System.out.println(" \nGAME OVER!");
			TextAdventure.showCredits();
			System.exit(0);
		}
		// the player cannot backtrack anymore and if they do, this message will
		// print out
		else if (trail.currCrumb == -1 || trail.hasMoreCrumbs() == true) {
			System.out.print("Oh no! The rats are after you! Be careful with those breadcrumbs of yours!");
			Player.actionCount = Player.actionCount - 1;
		}
		// the player backtracks as normal
		else if (trail.currCrumb != -1 && trail.hasNoMoreCrumbs() == false) {
			Player.backtrackLocale(trail);
			Locale currRoom = TextAdventure.locale[Player.playerLocation];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + currRoom.getLocation() + "." 
					+ " " + currRoom.getLocationDescription());
		}
	}

	// method for backtracking breadcrumbs
	public static void backtrackLocale(BreadcrumbTrail trail) {
		if (trail.hasNoMoreCrumbs() == false) {
			playerLocation = trail.pickupCrumb();
		}
	}

	// method that returns the player's location
	public static int getPlayerLocation() {
		return playerLocation;
	}

}