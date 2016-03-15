//Player class for Marist Mayhem
import java.util.Scanner;
import java.util.ArrayList;

public class Player {

	Scanner inputSource = new Scanner(System.in);
	// Some of the player variables that will be in this class
	static String name;
	static int playerLocation = 0;
	static String playerLocName = TextAdventure.locale[Player.playerLocation].getLocation();
	static String playerLocDesc = TextAdventure.locale[Player.playerLocation].getLocationDescription();
	static ArrayList<Item> playerLocItem = TextAdventure.locale[Player.playerLocation].getItemList();
	static String playerGetLocItem = null;
	static String playerGetLocItemDesc = null;
	static ArrayList<Item> inventory = new ArrayList<>();
	static int score = 0;
	
	//will check to see if the player has a map in the inventory
	public static boolean hasMap() {
		int size = inventory.size();
		for (int i = 0; i < size; i++) {
			if (inventory.get(i).equals(TextAdventure.map)) {
				return true;
			}
		}
		return false;
	}

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
	
	/*public static void moveNorth() {
		if (map[Player.playerLocation][0] != -1) {
			Player.playerLocation = map[Player.playerLocation][0];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + playerLocName + "." + " "
					+ playerLocDesc);
			if (playerLocItem != null) {
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
			} 
			else {
				System.out.print("\nYou found nothing. There is nothing here.");
			}
		} 
		else if (map[Player.playerLocation][0] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}
	
	public static void moveSouth() {
		if (map[Player.playerLocation][1] != -1) {
			Player.playerLocation = map[Player.playerLocation][1];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + playerLocName + "." + " "
					+ playerLocDesc);
			if (playerLocItem != null) {
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
			} 
			else {
				System.out.print("\nYou found nothing. There is nothing here.");
			}
		} 
		else if (map[Player.playerLocation][1] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}
	
	public static void moveEast() {
		if (map[Player.playerLocation][2] != -1) {
			Player.playerLocation = map[Player.playerLocation][2];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + playerLocName + "." + " "
					+ playerLocDesc);
			if (playerLocItem != null) {
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
			} 
			else {
				System.out.print("\nYou found nothing. There is nothing here.");
			}
		} 
		else if (map[Player.playerLocation][2] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}
	
	public static void moveWest() {
		if (map[Player.playerLocation][3] != -1) {
			Player.playerLocation = map[Player.playerLocation][3];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + playerLocName + "." + " "
					+ playerLocDesc);
			if (playerLocItem != null) {
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
			} 
			else {
				System.out.print("\nYou found nothing. There is nothing here.");
			}
		} 
		else if (map[Player.playerLocation][3] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}*/

	@SuppressWarnings("static-access")
	public static void backtrackLocale(BreadcrumbTrail trail) {
		if (BreadcrumbTrail.hasNoMoreCrumbs() == false) {
			playerLocation = trail.pickupCrumb();
		}
	}
}