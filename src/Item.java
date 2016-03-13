//Item class for Marist Mayhem
public class Item {

	public String item;
	public String itemDescription;
	
	public Item(String item, String itemDescription) {
		this.item = item;
		this.itemDescription = itemDescription;
	}
	
	public static void help() {
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
	
	static boolean hasMap = false;
}
