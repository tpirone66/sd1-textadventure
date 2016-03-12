
//Player class for Marist Mayhem
import java.util.Scanner;
import java.util.ArrayList;

public class Player {

	Scanner inputSource = new Scanner(System.in);
	// Some of the player variables that will be in this class
	static String name;
	static int playerLocation = 0;
	static ArrayList<String> inventory = new ArrayList<>();
	static int score = 0;

	public static void promptName() {
		// method that will allow character customization
		Scanner inputSource = new Scanner(System.in);
		String input;
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		name = input;
		System.out.println("Hello, " + name + "!");
	}

}
