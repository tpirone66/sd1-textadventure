
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
	public static void useItem(String part2) {
		boolean text = part2.equalsIgnoreCase("Handbook") || part2.equalsIgnoreCase("Dagger")
				|| part2.equalsIgnoreCase("Apple") || part2.equalsIgnoreCase("Map") || part2.equalsIgnoreCase("key");
		/*
		 * checks for limited use item and once an item has expended all of its
		 * uses, it disappears from the game
		 */
		if (part2.equalsIgnoreCase("apple")) {
			if (((LimitedUseItem) Player.inventory.get(findItem(part2))).usesRemaining <= 0) {
				System.out.print("You cannot use this item anymore!");
				Player.inventory.remove(findItem(part2));
			} else {
				((LimitedUseItem) Player.inventory.get(findItem(part2))).usesRemaining--;
				System.out.println("You consumed the " + part2 + " " + Player.name + "! It must taste really good!");
				System.out.println("Uses remaining: " + usesRemaining);
				Player.actionCount = Player.actionCount + 1;
			}
		}
		if (part2.equalsIgnoreCase("dagger")) {
			if (((LimitedUseItem) Player.inventory.get(promptFindItem(part2))).usesRemaining <= 0) {
				System.out.print("Oh no, " + Player.name + "! You just died! That was a wild trip!");
				System.out.print("\nI bet you regret using that item now!");
				Player.inventory.remove(findItem(part2));
				System.out.print("\nGAME OVER!");
				TextAdventure.showCredits();
				System.exit(0);
			} else {
				((LimitedUseItem) Player.inventory.get(promptFindItem(part2))).usesRemaining--;
				System.out
						.println("You used the " + part2 + " " + Player.name + "! I would advise that you refrain from"
								+ " using this item because it has dangerous side effects!");
				System.out.println("Uses remaining: " + usesRemaining);
			}
		}
		// alternative way to print to the map instead of using the map command
		else if (foundItem(part2)) {
			if (part2.equalsIgnoreCase("map")) {
				Item.containsMap();
			}
			// if the player is at Hancock and uses the key, it will call the
			// canEnter() method
			if (part2.equalsIgnoreCase("key") && Player.playerLocation == 9) {
				SecureLocale.canEnter();
			}
			// one of the victory situations is having the handbook and using it
			// in the wizard's house
			if (part2.equalsIgnoreCase("Handbook") && Player.playerLocation == 10 && Player.hasHandbook() == true) {
				TextAdventure.victoryMessage();
			}
			if (part2.equalsIgnoreCase("Handbook")) {
				System.out.println("You used the " + part2 + "!");
				Item.containsHandbook();
			}
			if (part2.equalsIgnoreCase("Key") && !(Player.playerLocation == 9 || Player.playerLocation == 10)) {
				System.out.println("You cannot use the " + part2 + " here!");
			}
		}
		if (!foundItem(part2) && text == true) {
			System.out.println("You don't have the " + part2 + ", " + Player.name + "!");
			// not exactly a failure, but the wizard will subtract 10 points and
			// put you back at location 0
			if (part2.equalsIgnoreCase("Handbook") && Player.playerLocation == 10 && Player.hasHandbook() == false) {
				TextAdventure.failureMessage();
			}
		}
		if (text == false) {
			System.out.print("No such item seems to exist, " + Player.name + ".");
		}
	}

	// method for prompt using an item
	@SuppressWarnings("static-access")
	public static void promptUseItem() {
		System.out.println("What item would you like to use?");
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		boolean text = !(input.equalsIgnoreCase("Handbook") || input.equalsIgnoreCase("Dagger")
				|| input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map") || input.equalsIgnoreCase("Key"));
		/*
		 * checks for limited use item and once an item has expended all of its
		 * uses, it disappears from the game
		 */
		if (input.equalsIgnoreCase("apple")) {
			if (((LimitedUseItem) Player.inventory.get(promptFindItem(input))).usesRemaining <= 0) {
				System.out.print("You cannot use this item anymore!");
				Player.inventory.remove(promptFindItem(input));
			} else {
				((LimitedUseItem) Player.inventory.get(promptFindItem(input))).usesRemaining--;
				System.out.println("You consumed the " + input + Player.name + "! It must taste really good!");
				System.out.println("Uses remaining: " + usesRemaining);
				Player.actionCount = Player.actionCount + 1;
			}
		}
		if (input.equalsIgnoreCase("dagger")) {
			if (((LimitedUseItem) Player.inventory.get(promptFindItem(input))).usesRemaining <= 0) {
				System.out.print("Oh no, " + Player.name + "! You just died! That was a wild trip!");
				System.out.print("\nI bet you regret using that item now!");
				Player.inventory.remove(findItem(input));
				System.out.print("\nGAME OVER!");
				TextAdventure.showCredits();
				System.exit(0);
			} else {
				((LimitedUseItem) Player.inventory.get(promptFindItem(input))).usesRemaining--;
				System.out.println("You used the " + input + "!");
				System.out.println("Uses remaining: " + usesRemaining);
			}
		}
		// alternative way to print to the map instead of using the map command
		else if (promptFoundItem(input)) {
			if (input.equalsIgnoreCase("map")) {
				Item.containsMap();
			}
			// if the player is at Hancock and uses the key, it will call the
			// canEnter() method
			if (input.equalsIgnoreCase("key") && Player.playerLocation == 9) {
				SecureLocale.canEnter();
			}
			if (!promptFoundItem(input) && input.equalsIgnoreCase("Handbook") && Player.playerLocation == 10
					&& Player.hasHandbook() == false) {
				TextAdventure.failureMessage();
			}
			if (input.equalsIgnoreCase("Handbook") && Player.playerLocation == 10 && Player.hasHandbook() == true) {
				TextAdventure.victoryMessage();
			}
			if (input.equalsIgnoreCase("Handbook")) {
				System.out.println("You used the " + input + "!");
				Item.containsHandbook();
			}
			if (input.equalsIgnoreCase("Key") && !(Player.playerLocation == 9 || Player.playerLocation == 10)) {
				System.out.println("You cannot use the " + input + " here!");
			}
		}
		if (!promptFoundItem(input) && text == false) {
			System.out.println("You don't have the " + input + ", " + Player.name + "!");
			// not exactly a failure, but the wizard will subtract 10 points and
			// put you back at location 0
			if (input.equalsIgnoreCase("Handbook") && Player.playerLocation == 10 && Player.hasHandbook() == false) {
				TextAdventure.failureMessage();
			}
		}
		if (text == true) {
			System.out.print("No such item seems to exist, " + Player.name + ".");
		}
	}

	/**
	 * @param input
	 *            checks to see if what the user typed in appears in the
	 *            inventory or game
	 * @return if it exists, it will return true if it does not exist, it will
	 *         return false
	 * 
	 *         this method is called in promptUseItem()
	 */
	public static boolean promptFoundItem(String input) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param input
	 *            will search through the inventory and find an item based off
	 *            of the user's input and in turn will allow them to use it
	 * @return if it is in the inventory, they can use it if it is not in the
	 *         inventory, they cannot use it
	 * 
	 *         this method is called in promptUseItem()
	 */
	public static int promptFindItem(String input) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.equalsIgnoreCase(input)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param part2
	 *            checks to see if what the user typed in appears in the
	 *            inventory or game
	 * @return if it exists, it will return true if it does not exist, it will
	 *         return false
	 * 
	 *         this method is called in useItem()
	 */
	public static boolean foundItem(String part2) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.equalsIgnoreCase(part2)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param part2
	 *            will search through the inventory and find an item based off
	 *            of the user's input and in turn will allow them to use it
	 * @return if it is in the inventory, they can use it if it is not in the
	 *         inventory, they cannot use it
	 * 
	 *         this method is called in useItem()
	 */
	public static int findItem(String part2) {
		int size = Player.inventory.size();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.equalsIgnoreCase(part2)) {
				return i;
			}
		}
		return -1;
	}
}
