
//Locale class for Marist Mayhem
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unused")
public class Locale {

	// variables for the locale array of objects
	public String item;
	public String itemDescription;
	public String location;
	public String locationDescription;
	ArrayList<Item> itemList = new ArrayList<Item>();

	// constructor with four parameters
	public Locale(String location, String locationDescription, ArrayList<Item> listOfItems) {
		this.location = location;
		this.locationDescription = locationDescription;
		this.itemList = listOfItems;
	}

	// these get methods look for the corresponding variables and returns them
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
}