import java.util.Scanner;

// LimitedUseItem class for Marist Mayhem
public class LimitedUseItem extends Item{

	public LimitedUseItem(String item, String itemDescription, boolean isDiscovered, int itemValue, int usesRemaining) {
		super(item, itemDescription, isDiscovered, itemValue);
	
	}

	// method for using an item
		public static void useItem() {
			System.out.println("What item would you like to use?");
			@SuppressWarnings("resource")
			Scanner inputSource = new Scanner(System.in);
			String input;
			input = inputSource.nextLine();
			boolean text = !(input.equalsIgnoreCase("Handbook") || input.equalsIgnoreCase("Liquid Silicone Dagger") || 
					input.equalsIgnoreCase("Apple") || input.equalsIgnoreCase("Map"));
			if (text == true) {
				System.out.print("No such item seems to exist, " + Player.name + ".");
			}
			else if (foundItem(input)) {
				if(input.equals("map")) {
					Item.containsMap();
				}
			}
			else if (text == false) {
				System.out.print("You do not have such item to use, " + Player.name + ".");
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
		
}
