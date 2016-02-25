import java.util.Collection;

//Locale class for Marist Mayhem
public class Locale{
		
		//locations and their descriptions
		//public static String[] locationDescription = {    "Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop."};
		//public static String[] location = {"Marist", "Champagnat", "Leo", "Marian", "Midrise", "Sheahan", "Lower Townhouses", "Lower West Cedar Townhouses"};
		public String item;
		public String itemDescription;
		public String location;
		public String locationDescription;
		
		public Locale(String location, String locationDescription, String item, String itemDescription) {
			this.location = location;
			this.locationDescription = locationDescription;
			this.item = item;
			this.itemDescription = itemDescription;
		}
		
		static boolean hasDagger = false;
		static boolean hasMap = false;
		static boolean hasApple = false;
		static boolean hasHandbook = false;
		
		static int[][] map = {
		//  N   S  E  W
			{1, 3, 4, 2},	//Marist		
			{-1, 0, -1, -1},//Champagnat
			{-1, -1, 0, 5}, //Leo
			{0, 7, -1, -1}, //Marian
			{-1, -1, 6, 0}, //Midrise
			{-1, -1, 2, -1},//Sheahan
			{-1, -1, -1, 4},//Lower Townhouses
			{3, -1, -1, -1},//Lower West Cedar Townhouses
		};
		
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