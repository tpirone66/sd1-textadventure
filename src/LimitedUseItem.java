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
		boolean text = !(input.equalsIgnoreCase("Handbook") || input.equalsIgnoreCase("Liquid Silicone Dagger")
				|| input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map") || input.equalsIgnoreCase("Key"));
		/** @param input
		 * 
		 */
		if (!foundItem(input) && text == false) {
			System.out.println("You don't have the " + input);
			return;
		}
		if (text == true) {
			System.out.print("No such item seems to exist, " + Player.name + ".");
		}
		/*
		 * checks for limited use item which as of now is only the apple once an
		 * item has expended all of its uses, it disappears from the game
		 */
		if (input.equalsIgnoreCase("apple")) {
			if (((LimitedUseItem) Player.inventory.get(findItem(input))).usesRemaining <= 0) {
				System.out.print("You cannot use this item anymore!");
				Player.inventory.remove(findItem(input));
			} 
			else {
				((LimitedUseItem) Player.inventory.get(findItem(input))).usesRemaining--;
				System.out.println("You used the " + input);
				System.out.println("Uses remaining: " + usesRemaining);
				Player.actionCount = Player.actionCount + 1;
			}
		}
		// alternative way to print to the map instead of using the map command
		else if (foundItem(input)) {
			if (input.equalsIgnoreCase("map")) {
				Item.containsMap();
			}
		// if the player is at Hancock and uses the key, it will call the canEnter() method
			if (input.equalsIgnoreCase("key") && Player.playerLocation == 9) {
				SecureLocale.canEnter();
			}
			if (input.equalsIgnoreCase("Liquid Silicone Dagger")){
				System.out.println("You used the " + input);
			}
			if (input.equalsIgnoreCase("Handbook")){
				System.out.println("You used the " + input);
			}
			if (input.equalsIgnoreCase("Key") && Player.playerLocation != 9){
				System.out.println("You cannot use the " + input + "here!");
			}
		}
	}

	// this method checks to see if what the user typed in appears in the inventory or game
	public static boolean foundItem(String input) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.equalsIgnoreCase(input)) {
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
			if (Player.inventory.get(i).item.equalsIgnoreCase(input)) {
				return i;
			}
		}
		return -1;
	}
}
