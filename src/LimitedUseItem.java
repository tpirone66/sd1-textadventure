import java.util.Scanner;

// LimitedUseItem class for Marist Mayhem
public class LimitedUseItem extends Item{
	
	static int usesRemaining;

	public LimitedUseItem(String item, String itemDescription, boolean isDiscovered, int itemValue, int usesRemaining) {
		super(item, itemDescription, isDiscovered, itemValue);
		this.usesRemaining = usesRemaining;
	}

	// method for using an item
		public static void useItem() {
			System.out.println("What item would you like to use?");
			@SuppressWarnings("resource")
			Scanner inputSource = new Scanner(System.in);
			String input;
			input = inputSource.nextLine();
			boolean text = !(input.equalsIgnoreCase("handbook") || input.equalsIgnoreCase("Liquid Silicone Dagger") || 
					input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map"));
			if(!foundItem(input))
			{
				System.out.println("You dont have the " + input);
				return;
			}
			if(input.equals("apple")) {
				if(((LimitedUseItem)Player.inventory.get(findItem(input))).usesRemaining <= 0) {
					System.out.print("You cannot use this item anymore!");
					Player.inventory.remove(findItem(input));
				}
				else {
					((LimitedUseItem)Player.inventory.get(findItem(input))).usesRemaining --;
					System.out.println("You used the " + input);
					System.out.println("Uses remaining: " + usesRemaining);
				}
			}
			if (text == true) {
				System.out.print("No such item seems to exist, " + Player.name + ".");
			}
			else if (foundItem(input)) {
				if(input.equals("map")) {
					Item.containsMap();
				}
				else
				{
					System.out.println("You used the " + input);
				}
			}
		}
		
		public static boolean foundItem(String input)
		{
			int size = Player.inventory.size();
			for (int i = 0; i < size; i++) {
				if (Player.inventory.get(i).item.toLowerCase().equals(input)) {
					return true;
				}
			}
			return false;
		}
		
		
		public static int findItem(String input)
		{
			int size = Player.inventory.size();
			for (int i = 0; i < size; i++) {
				if (Player.inventory.get(i).item.toLowerCase().equals(input)) {
					return i;
				}
			}
			return -1;
		}
}
