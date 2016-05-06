/**SecureLocale class for Marist Mayhem*/

//anywhere it mentions @SupressWarnings, ignore it

import java.util.ArrayList;
import java.util.Scanner;

public class SecureLocale extends Locale {

	// constructor
	public SecureLocale(String location, String locationDescription, ArrayList<Item> listOfItems, Item requiredItem,
			boolean hasVisited) {
		super(location, locationDescription, listOfItems, hasVisited);
	}

	/*
	 * this method is called when the user wants to enter Hancock Center and go
	 * into the Wizard's house
	 */
	public static boolean canEnter() {
		System.out.print("Type in the item again to open the door.");
		int size = Player.inventory.size();
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		// they CAN ENTER Hancock if they have the key
		if (Player.playerLocation == 9 && input.toLowerCase().equals("key")) {
			for (int i = 0; i < size; i++) {
				if (Player.inventory.get(i).item.toLowerCase().equals("key")) {
					System.out.print("Congratulations! You found the key to the 'Nerd Palace'!");
					TextAdventure.endGame();
				}
			}
		}
		// they can be at the location, but they CANNOT ENTER Hancock if they do
		// not have the key
		else {
			for (int i = 0; i < size; i++) {
				if (Player.inventory.get(i).item.toLowerCase().equals(input)) {
					System.out.print("This item cannot be used here!");
				}
			}
		}
		return false;
	}
}
