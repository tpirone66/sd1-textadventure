import java.util.Collection;

//Locale class for Marist Mayhem
public class Locale{
		
		//locations and their descriptions
		//public static String[] locationDescription = {    "Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop."};
		//public static String[] location = {"Marist", "Champagnat", "Leo", "Marian", "Midrise", "Sheahan", "Lower Townhouses", "Lower West Cedar Townhouses"};
		public static String item;
		public static String location;
		public static String locationDescription;
		public static int number;
		
		public Locale(String location, String locationDescription, String item, int number) {
			this.location = location;
			this.locationDescription = locationDescription;
			this.item = item;
			this.number = number;
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

		public static Locale createLocation(Locale locale) {
			return new Locale(location, locationDescription, item, number);
		}
		
		public String getLocation(){
			return location;
		}
		
		public String getLocationDescription(){
			return locationDescription;
		}
}

	
