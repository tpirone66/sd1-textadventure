//Locale class for Marist Mayhem
import java.util.Collection;

public class Locale{
		
		//variables for the locale array of objects
		public String item;
		public String itemDescription;
		public String location;
		public String locationDescription;
		
		//constructor with four parameters
		public Locale(String location, String locationDescription, String item, String itemDescription) {
			this.location = location;
			this.locationDescription = locationDescription;
			this.item = item;
			this.itemDescription = itemDescription;
		}
		
		//items are by default false if the user does not have them
		static boolean hasDagger = false;
		static boolean hasMap = false;
		static boolean hasApple = false;
		static boolean hasHandbook = false;
		
		//these get methods look for the corresponding variables and returns them
		public String getLocation(){
			return location;
		}
		
		public String getLocationDescription(){
			return locationDescription;
		}
		
		public String getItem(){
			return item;
		}
		
		public String getItemDescription(){
			return itemDescription;
		}
}