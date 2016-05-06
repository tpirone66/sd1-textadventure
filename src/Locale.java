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
	 * @param location
	 *            returns the player's location
	 * 
	 * @param locationDescription
	 *            returns the description of the player's location
	 * 
	 * @param itemList
	 *            returns any item that might be at that location
	 * 
	 * @param itemDescription
	 *            returns the description of an item at a location
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

	// adds item to the location when the game starts
	public Item addItem(Item i) {
		itemList.add(i);
		return i;
	}
	
	// checks to see if a locale has been discovered
	public boolean getHasVisited() {
		return hasVisited;
	}

	// checks to see if an item has been discovered
	public boolean isDiscovered(ArrayList<Item> Item) {
		return false;
	}

}