//Player class for Marist Mayhem
import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		//Some of the player variables that will be in this class
		String name;
		String location;
		int inventory;
		int score;
	}


	public static void promptName() {
		Scanner inputSource = new Scanner(System.in);
		String input;
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		System.out.println("Hello, " + input + "!");
		System.out.println("\n");//prints out a new line of whitespace
	}
	
	
}
