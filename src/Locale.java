/**Locale class for Marist Mayhem*/

//anywhere it mentions @SupressWarnings, ignore it

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unused")

public class Locale {

	// variables for the locale array of objects
	public String itemDescription;
	public String location;
	public String locationDescription;
	ArrayList<Item> itemList = new ArrayList<Item>();
	public boolean hasVisited;

	/*
	 * Locale constructor with five parameters
	 */
	public Locale(String location, String locationDescription, ArrayList<Item> listOfItems, boolean hasVisited) {
		this.location = location;
		this.locationDescription = locationDescription;
		this.itemList = listOfItems;
		this.hasVisited = hasVisited;
	}

	/**
	 * these get methods look for the corresponding variables and returns them
	 * 
	 * @return location returns the player's location
	 * 
	 * @return locationDescription returns the description of the player's
	 *         location
	 * 
	 * @return itemList returns any item that might be at that location
	 * 
	 * @return itemDescription returns the description of an item at a location
	 * 
	 * @return hasVisited returns if the locale has been discovered
	 * 
	 */
	public String getLocation() {
		return location;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public boolean getHasVisited() {
		return hasVisited;
	}

	/**
	 * @param i
	 *            represents an item
	 * @return returns item
	 */
	public Item addItem(Item i) {
		itemList.add(i);
		return i;
	}

	/**
	 * @param Item
	 *            checks to see if an item has been discovered at a locale
	 * @return returns false or true depending on if it has been discovered
	 */
	public boolean isDiscovered(ArrayList<Item> Item) {
		if (hasVisited == false) {
			return false;
		} else {
			return true;
		}
	}

}