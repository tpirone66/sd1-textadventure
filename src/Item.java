import java.util.ArrayList;

//Item class for Marist Mayhem
public class Item {

	public String item;
	public String itemDescription;
	
	public Item(String item, String itemDescription) {
		this.item = item;
		this.itemDescription = itemDescription;
	}
	
	public static void showHelp() {
		System.out.println("Press N to go North.");
		System.out.println("Press S to go South.");
		System.out.println("Press E to go East.");
		System.out.println("Press W to go West.");
		System.out.println("Press Q to quit the game.");
		System.out.println("Press T to take an item.");
		System.out.println("Press I to view your inventory.");
		System.out.println("Press D to drop an item from your inventory.");
		System.out.println("Press B to backtrack to a previous location.");
		System.out.println("Type 'Score' to display the score.");
	}
	
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
	
	public static void takeItem() {
		int currLoc = Player.getPlayerLocation();
		ArrayList<Item> currentRoomList = TextAdventure.locale[currLoc].getItemList();
		if (currentRoomList == null) {
			System.out.println("There is nothing to take.");
		} else if (currentRoomList != null && currentRoomList.isEmpty()) {
			System.out.print("The item is already in the inventory! I guess you're just seeing things now...");
		} else {
			System.out.print("You obtained " + TextAdventure.locale[Player.playerLocation].getItemList().get(0).item + "!");
			Player.inventory.add(currentRoomList.get(0));
			currentRoomList.remove(0);
			Player.score += 5;
			System.out.print(" Score: " + Player.score);
		}
	}
	
	public static void hasMap() {
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
	
	static boolean hasMap = false;
}
