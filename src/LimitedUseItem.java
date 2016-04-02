import java.util.Scanner;

// LimitedUseItem class for Marist Mayhem
public class LimitedUseItem extends Item{

	public LimitedUseItem(String item, String itemDescription, boolean isDiscovered, int itemValue, int usesRemaining) {
		super(item, itemDescription, isDiscovered, itemValue);
	
	}

	// method for using an item
		@SuppressWarnings("unused")
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
			else if (text == false && Player.hasItem() == false) {
				System.out.print("You do not have such item to use, " + Player.name + ".");
			}
			else if (text == false && Player.hasItem() == true){
				System.out.print("You used " + Player.inventory.get(0).equals(TextAdventure.handbook));
			}
		}
		
}
