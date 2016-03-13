
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
	
	// navigation matrix map
			static int[][] map = {
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
	
	public static void moveNorth() {
		if (map[Player.playerLocation][0] != -1) {
			Player.playerLocation = map[Player.playerLocation][0];
			System.out.print("\nCurrent location: " + Player.playerLocation + ".");
			System.out.print(" You are now in " + playerLocName + "." + " "
					+ playerLocDesc);
			if (playerLocItem == null) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} 
			else {
				playerGetLocItem = TextAdventure.locale[Player.playerLocation].getItemList().get(0).item;
				playerGetLocItemDesc = TextAdventure.locale[Player.playerLocation].getItemList().get(0).itemDescription;
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
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
			if (playerLocItem == null) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} 
			else {
				playerGetLocItem = TextAdventure.locale[Player.playerLocation].getItemList().get(0).item;
				playerGetLocItemDesc = TextAdventure.locale[Player.playerLocation].getItemList().get(0).itemDescription;
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
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
			if (playerLocItem == null) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} 
			else {
				playerGetLocItem = TextAdventure.locale[Player.playerLocation].getItemList().get(0).item;
				playerGetLocItemDesc = TextAdventure.locale[Player.playerLocation].getItemList().get(0).itemDescription;
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
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
			if (playerLocItem == null) {
				System.out.print("\nYou found nothing. There is nothing here.");
			} 
			else {
				playerGetLocItem = TextAdventure.locale[Player.playerLocation].getItemList().get(0).item;
				playerGetLocItemDesc = TextAdventure.locale[Player.playerLocation].getItemList().get(0).itemDescription;
				System.out.print("\nYou found " + playerGetLocItem + "."
						+ playerGetLocItemDesc);
			}
		} 
		else if (map[Player.playerLocation][3] == -1) {
			System.out.print("\nCannot move that way!");
		}
	}
}
