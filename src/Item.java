//Item class for Marist Mayhem
public class Item {

	public String item;
	public String itemDescription;

	public Item(String item, String itemDescription) {
		this.item = item;
		this.itemDescription = itemDescription;
	}

	// items are by default false if the user does not have them
	static boolean hasDagger = false;
	static boolean hasMap = false;
	static boolean hasApple = false;
	static boolean hasHandbook = false;

}
