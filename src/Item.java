/**Item class for Marist Mayhem*/

//anywhere it mentions @SupressWarnings, ignore it 

import java.util.ArrayList;
import java.util.Scanner;

public class Item {

	// item variables
	public String item;
	public String itemDescription;
	public boolean isDiscovered;
	public int itemValue;

	// constructor for items
	public Item(String item, String itemDescription, boolean isDiscovered, int itemValue) {
		this.item = item;
		this.itemDescription = itemDescription;
		this.isDiscovered = isDiscovered;
		this.itemValue = itemValue;
	}

	// this method shows instructions for the game
	public static void showHelp() {
		System.out.println("Press N to go North.");
		System.out.println("Press S to go South.");
		System.out.println("Press E to go East.");
		System.out.println("Press W to go West.");
		System.out.println("Press Q to quit the game.");
		System.out.println("Press T to take an item.");
		System.out.println("Press X to examine a location.");
		System.out.println("Press U to use an item.");
		System.out.println("Press I to view your inventory.");
		System.out.println("Press D to drop an item from your inventory.");
		System.out.println("Press B to backtrack to a previous location.");
		System.out.println("Type 'Score' to display the score.");
		System.out.println("Type 'Speak' to interact with the characters in the game.");
	}

	// this method shows the inventory
	public static void showInventory() {
		int size = Player.inventory.size();
		int finalIndex = size - 1;

		for (int x = 0; x < size; x++) {
			if (x != finalIndex) {
				System.out.print(Player.inventory.get(x).item + ", ");
			} else {
				System.out.println(Player.inventory.get(x).item);
			}
		}
	}
	
	//method for taking an item
	public static void takeItem(String part2) {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		boolean text = part2.equalsIgnoreCase("Handbook") || part2.equalsIgnoreCase("Dagger") ||
				part2.equalsIgnoreCase("Apple") || part2.equalsIgnoreCase("Map") || part2.equalsIgnoreCase("key");
		if (currentRoomList.isEmpty()) {
			System.out.println("There is nothing to take.");
		}
		else if (findItemList(part2, currentRoomList) == -1) {
			System.out.print("That is not the item you have found!");
		}
		else if (!(currentRoomList.isEmpty()) && text == false) {
			System.out.print("No such item exists, " + Player.name + "!");
		}
		else if (!(currentRoomList.isEmpty()) && text == true) {
			System.out.print("You obtained " + currentRoomList.get(0).item + "!");
			Player.score += currentRoomList.get(0).itemValue();
			Player.inventory.add(currentRoomList.get(0));
			currentRoomList.remove(0);
			System.out.print(" Score: " + Player.score);
		}
	}


	// method for prompt taking an item
	public static void promptTakeItem() { // add a parameter to hold the item name
			// in here, check if item name is null, if so then do your prompt magic
			//          if not, then use that item name instead of prompting
			int currLoc = Player.getPlayerLocation();
			ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
			System.out.println("What item would you like to take?");
			@SuppressWarnings("resource")
			Scanner inputSource = new Scanner(System.in);
			String input = "";
			input = inputSource.nextLine();
			/*
			 * after the user decides which item they take, this part of the code
			 * deciphers based off of the user's input what the game decides to do
			 * when handling a variety of situations with taking items
			 */
			boolean text = !(input.equalsIgnoreCase("Handbook") || input.equalsIgnoreCase("Dagger")
					|| input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map") || input.equalsIgnoreCase("Key"));
			if (currentRoomList.size() == 0) {
				System.out.println("There is nothing to take.");
			} 
			else if (text == true) {
				System.out.print("No such item exists, " + Player.name + "!");
				return;
			} 
			else if (findItemInList(input, currentRoomList) == -1) {
				System.out.print("That is not the item you have found!");
			} 
			else {
				System.out.print("You obtained " + currentRoomList.get(0).item + "!");
				Player.score += currentRoomList.get(0).itemValue();
				Player.inventory.add(currentRoomList.get(0));
				currentRoomList.remove(0);
				System.out.print(" Score: " + Player.score);
			}
	}
	
	//method for dropping an item
	@SuppressWarnings("null")
	public static void dropItem(String part2) {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		int itemIndex = LimitedUseItem.findItem(part2);
		String item = "";
		/**
		 * @param item
		 * 
		 * @param intemIndex
		 *            at this point, similar to the take command, the drop
		 *            command will handle all possible outcomes for dropped
		 *            items
		 */
		if (itemIndex >= 0) {
			item = Player.inventory.get(itemIndex).item;
		} 
		else {
			item = "nothing";
		}
		boolean text = part2.equalsIgnoreCase("Handbook") || part2.equalsIgnoreCase("Dagger") ||
				part2.equalsIgnoreCase("Apple") || part2.equalsIgnoreCase("Map") || part2.equalsIgnoreCase("key");
		if (text == false) {
			System.out.println("There is no such thing in the inventory to drop!");
			return;
		}
		if (text == true && (currentRoomList == null || currentRoomList.isEmpty())) {
			System.out.println("You dropped " + item + "!" + " I would advise you to pick it up.");
			Item droppedItem = Player.inventory.remove(Player.inventory.size() - 1);
			TextAdventure.locale[currLoc].addItem(droppedItem);
			Player.score -= currentRoomList.get(0).itemValue();
			System.out.print("Score: " + Player.score);
		}
		if (text == true && (currentRoomList != null || !(currentRoomList.isEmpty()))) {
			System.out.println("You dropped " + item + "!" + " I would advise you to pick it up.");
			Item droppedItem = Player.inventory.remove(Player.inventory.size() - 1);
			TextAdventure.locale[currLoc].addItem(droppedItem);
			Player.score -= currentRoomList.get(0).itemValue();
			System.out.print("Score: " + Player.score);
		}
	}
	

	// method for prompt dropping an item
	@SuppressWarnings("null")
	public static void promptDropItem() {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		System.out.println("What item would you like to drop?");
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		int itemIndex = LimitedUseItem.findItem(input);
		String item = "";
		/**
		 * @param item
		 * 
		 * @param intemIndex
		 *            at this point, similar to the take command, the drop
		 *            command will handle all possible outcomes for dropped
		 *            items
		 */
		if (itemIndex >= 0) {
			item = Player.inventory.get(itemIndex).item;
		} 
		else {
			item = "nothing";
		}
		boolean text = !(input.equalsIgnoreCase("Handbook") || input.equalsIgnoreCase("Dagger")
				|| input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map"));
		if (text == true) {
			System.out.println("There is no such thing in the inventory to drop!");
			return;
		}
		if (item.compareTo("nothing") == 0 || (text == false && !currentRoomList.isEmpty())) {
			System.out.println("This item is not in the inventory and cannot be dropped!");
			return;
		}
		if (text == false && (currentRoomList == null || currentRoomList.isEmpty())) {
			System.out.println("You dropped " + item + "!" + " I would advise you to pick it up.");
			Item droppedItem = Player.inventory.remove(Player.inventory.size() - 1);
			TextAdventure.locale[currLoc].addItem(droppedItem);
			Player.score -= currentRoomList.get(0).itemValue();
			System.out.print("Score: " + Player.score);
		}
		if (text == true && (currentRoomList != null || !(currentRoomList.isEmpty()))) {
			System.out.println("You dropped " + item + "!" + " I would advise you to pick it up.");
			Item droppedItem = Player.inventory.remove(Player.inventory.size() - 1);
			TextAdventure.locale[currLoc].addItem(droppedItem);
			Player.score -= currentRoomList.get(0).itemValue();
			System.out.print("Score: " + Player.score);
		}
	}

	/**
	 * method for examining an item
	 * 
	 * @param currLoc
	 * @param currentRoomList
	 */
	public static void examineItem() {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		boolean isExplored = TextAdventure.locale[Player.playerLocation].getHasVisited();
		if (currentRoomList.isEmpty()) {
			if (isExplored == false) {
				System.out.print("It seems that there are no items for you to take here.");
			} 
		}
		if (!currentRoomList.isEmpty()) {
			if (isExplored == false) {
				System.out.print("\nYou found " + currentRoomList.get(0).item
						+ "." + currentRoomList.get(0).itemDescription);
			}
		}
	}

	// this method will show the map if you have it
	public static void containsMap() {
		System.out.println("                          --------------                                        ");
		System.out.println("                          |Hudson River|                                        ");
		System.out.println("                          --------------                                        ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                           ------------                                         ");
		System.out.println("                           |Champagnat|                                         ");
		System.out.println("                           ------------                                         ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("     ---------     -----     --------     ---------     ------------------      ");
		System.out.println("     |Sheahan|-----|Leo|-----|Marist|-----|Midrise|-----|Lower Townhouses|      ");
		System.out.println("     ---------     -----     --------     ---------     ------------------      ");
		System.out.println("                            	|								|               ");
		System.out.println("                            	|								|               ");
		System.out.println("                            	|								|               ");
		System.out.println("                            	|								|               ");
		System.out.println("                            	|								|               ");
		System.out.println("                            --------                    ----------------        ");
		System.out.println("                            |Marian|                    |Hancock Center|        ");
		System.out.println("                            --------                    ----------------        ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("             	 -----------------------------                                  ");
		System.out.println("              	 |Lower West Cedar Townhouses|                                  ");
		System.out.println("              	 -----------------------------                                  ");
	}

	/*
	 * method checks to see if the user has the handbook in the inventory and
	 * will print this if they do
	 */
	public static void containsHandbook() {
		System.out.print("The rats are coming! The rats are coming! -General Cornwallis\n"
				+ "\nI love to code. Coding is fun! Coding is all about problem solving!\n"
				+ "I love to style my code! Ever since coming to Marist, I have been intrigued by coding."
				+ "\nThere is a problem solving element to coding. I love to code in good coding style."
				+ "\nI always want to make sure that my code is readable to every human."
				+ "\nI am fluid in many programming languages, but as a wizard, I am magical."
				+ "\nIt's always good to be alive! Teaching is the best thing going for me..."
				+ "\nWell, so is writing this message." + "\n4/20 signed the Wizard" + "\nethMtwa hsJnoon");
	}

	// method checks to see if the item the user found in the location exists there
	// this method is called in promptTakeItem()
	public static int findItemInList(String input, ArrayList<Item> items) {
		int size = items.size();
		for (int i = 0; i < size; i++) {
			if (items.get(i).item.equalsIgnoreCase(input)) {
				return i;
			}
		}
		return -1;
	}
	
	// method checks to see if the item the user found in the location exists there
	// this method is called in takeItem()
	public static int findItemList(String part2, ArrayList<Item> items) {
		int size = items.size();
		for (int i = 0; i < size; i++) {
			if (items.get(i).item.equalsIgnoreCase(part2)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isDiscovered() {
		return isDiscovered;
	}
	
	public int itemValue() {
		return itemValue;
	}

}