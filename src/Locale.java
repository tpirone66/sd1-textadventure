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
		
		public static void createLocation(String location, String locationDescription, String item, int number) {
			new Locale("Marist", "Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", null, 0);
			new Locale("Champagnat", "Champagnat is really loud tonight! Why is there a fire drill every weekend?", "Handbook", 1);
			new Locale("Leo", "Leo seems like the place where all the rich children live. $$$", null, 2);
			new Locale("Marian", "Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", "Dagger", 3);
			new Locale("Midrise", "Midrise is Midrise...yeah...", null, 4);
			new Locale("Sheahan", "Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?", "Map", 5);
			new Locale("Lower Townhouses", "Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.", "Apple", 6);
			new Locale("Lower West Cedar Townhouses", "Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop.", null, 7);
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
		
		public Locale(int dest) {
			if (dest != -1){
				dest = map[Player.playerLocation][TextAdventure.direction];
			}
			else {
				Player.playerLocation = dest;
			}
		}

		public static Locale createLocation(Locale locale) {
			return new Locale(location, locationDescription, item, number);
		}

}

	
