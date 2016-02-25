import java.util.Collection;

//Locale class for Marist Mayhem
public class Locale{
		
		//locations and their descriptions
		public static String[] locationDescription = {"Marist is an interesting place. Green grass, lots of partygoers, and walking zombies!", "Champagnat is really loud tonight! Why is there a fire drill every weekend?", "Leo seems like the place where all the rich children live. $$$", "Marian is home to the hobbits and the hermits. Sure seems clicky around here.", "Midrise is Midrise...yeah...", "Sheahan is a mysterious place no one knows about because it's so far out there. What is that stench people?", "Lower Townhouses are not too shabby to live in. Right behind the world famous 'Nerd Palace'.", "Lower West Cedar Townhouses are for those crazy upperclassmen. They never seem to be in the loop."};
		public static String[] location = {"Marist", "Champagnat", "Leo", "Marian", "Midrise", "Sheahan", "Lower Townhouses", "Lower West Cedar Townhouses"};
		public static String item;
		
		private static Locale[] InitializelocationDescriptions(int location) {
			Locale[] locationDescription = new Locale[location + 1];
			for(int i = 0; i < location + 1; i++){
				locationDescription[i] = new Locale();
			}
			return locationDescription;
		}
		
		int[][] map = {
			{1, 3, 4, 2},			
			{-1, 0, -1, -1},
			{-1, -1, 0, 5},
			{0, 7, -1, -1},
			{-1, -1, 6, 0},
			{-1, -1, 2, -1},
			{-1, -1, -1, 4},
			{3, -1, -1, -1},
		};
		
		int dest = map[Player.playerLocation][TextAdventure.direction];
}
