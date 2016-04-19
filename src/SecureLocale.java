/**SecureLocale class for Marist Mayhem*/

//anywhere it mentions @SupressWarnings, ignore it

import java.util.ArrayList;
import java.util.Scanner;

public class SecureLocale extends Locale {
	
	public SecureLocale(String location, String locationDescription, ArrayList<Item> listOfItems, Item requiredItem) {
		super(location, locationDescription, listOfItems);
	}

	public boolean canEnter() {
		int size = Player.inventory.size();
		@SuppressWarnings("resource")
		Scanner inputSource = new Scanner(System.in);
		String input;
		input = inputSource.nextLine();
		for (int i = 0; i < size; i++) {
			if (Player.inventory.get(i).item.toLowerCase().equals(input)) {
				return true;
			}
		}
		return false;
	}
}
