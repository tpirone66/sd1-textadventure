//Item class for Marist Mayhem

//anywhere it mentions @SupressWarnings, ignore it

import java.util.ArrayList;
import java.util.Scanner;

public class Item {

	// item variables
	public String item;
	public String itemDescription;
	public static boolean isDiscovered;
	public int itemValue;

	// constructor for items
	@SuppressWarnings("static-access")
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

	// method for taking an item
	@SuppressWarnings("unused")
	public static void takeItem() {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		System.out.println("What item would you like to take?");
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		boolean text = !(input.equalsIgnoreCase("Handbook") || input.equalsIgnoreCase("Liquid Silicone Dagger") || 
				input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map"));
		if (currentRoomList == TextAdventure.BlankList) {
			System.out.println("There is nothing to take.");
		} else if (currentRoomList != null && currentRoomList.isEmpty()) {
			System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
		} else if (text == true) {
			System.out.print("No such item exists!");
		} else if (input.equalsIgnoreCase("Handbook") && !(Player.playerLocation == 1)){
			System.out.print("That is not the item you have found!");
		} else if (input.equalsIgnoreCase("Liquid Silicone Dagger") && !(Player.playerLocation == 3)){
			System.out.print("That is not the item you have found!");
		} else if (input.equalsIgnoreCase("Map") && !(Player.playerLocation == 5)){
			System.out.print("That is not the item you have found!");
		} else if (input.equalsIgnoreCase("Apple") && !(Player.playerLocation == 6)){
			System.out.print("That is not the item you have found!");
		} else {
			System.out.print(
					"You obtained " + TextAdventure.locale[Player.playerLocation].getItemList().get(0).item + "!");
			Player.inventory.add(currentRoomList.get(0));
			currentRoomList.remove(0);
			Player.score += 5;
			System.out.print(" Score: " + Player.score);
		}
	}

	// method for dropping an item
	public static void dropItem() {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		String item = Player.inventory.get(Player.inventory.size() - 1).item;
		if (currentRoomList == null || currentRoomList.isEmpty()) {
			System.out.print("You dropped " + item + "!"
					+ " I would advise you to pick it up.");
			Item droppedItem = Player.inventory.remove(Player.inventory.size() - 1);
			TextAdventure.locale[currLoc].addItem(droppedItem);
			Player.score -= 5;
			System.out.print(" Score: " + Player.score);
		}
	}
	
	// method for using an item
	public static void examineItem() {
		
	}

	// this method will show the map if you have it
	public static void containsMap() {
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
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            --------                                            ");
		System.out.println("                            |Marian|                                            ");
		System.out.println("                            --------                                            ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("                            	|                                               ");
		System.out.println("             	 -----------------------------                                  ");
		System.out.println("              	 |Lower West Cedar Townhouses|                                  ");
		System.out.println("              	 -----------------------------                                  ");
	}
	
}