/**LimitedUseItem class for Marist Mayhem*/

import java.util.Scanner;

public class LimitedUseItem extends Item {

	// variables
	static int usesRemaining;

	// constructor
	@SuppressWarnings("static-access")
	public LimitedUseItem(String item, String itemDescription, boolean isDiscovered, int itemValue, int usesRemaining) {
		super(item, itemDescription, isDiscovered, itemValue);
		this.usesRemaining = usesRemaining;
	}

	// method for using an item
	@SuppressWarnings("static-access")
	public static void useItem() {
		System.out.println("What item would you like to use?");
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		boolean text = !(input.equalsIgnoreCase("handbook") || input.equalsIgnoreCase("Liquid Silicone Dagger")
				|| input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map") || input.equalsIgnoreCase("Key"));
		/** @param input
		 * 
		 */
		if (!foundItem(input)) {
			System.out.println("You don't have the " + input);
			return;
		}
		/*
		 * checks for limited use item which as of now is only the apple once an
		 * item has expended all of its uses, it disappears from the game
		 */
		if (input.equals("apple")) {
			if (((LimitedUseItem) Player.inventory.get(findItem(input))).usesRemaining <= 0) {
				System.out.print("You cannot use this item anymore!");
				Player.inventory.remove(findItem(input));
			} else {
				((LimitedUseItem) Player.inventory.get(findItem(input))).usesRemaining--;
				System.out.println("You used the " + input);
				System.out.println("Uses remaining: " + usesRemaining);
			}
		}
		if (text == true) {
			System.out.print("No such item seems to exist, " + Player.name + ".");
		}
		// alternative way to print to the map instead of using the map command
		else if (foundItem(input)) {
			if (input.equals("map")) {
				Item.containsMap();
			} else {
				System.out.println("You used the " + input);
			}
		}
	}

	// this method checks to see if what the user typed in appears in the
	// inventory or game
	public static boolean foundItem(String input) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.toLowerCase().equals(input)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * this method will search through the inventory and find an item based off
	 * of the user's input and in turn will allow them to use it
	 */
	public static int findItem(String input) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.toLowerCase().equals(input)) {
				return i;
			}
		}
		return -1;
	}
}
