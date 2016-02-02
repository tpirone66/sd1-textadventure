/*Trevor Pirone
 * CMPT 220L
 * Software Development 1
 * Project 1
 * Text Adventure Game v0.1
 * 
 * A text adventure based game created by @author Trevor Pirone
 */

import java.util.Scanner;//used for reading user input on the keyboard
import java.util.Random;//will be used later on for random generation

public class TextAdventure {

	public static void main(String[] args) {
		Scanner inputSource = new Scanner(System.in);
		String input;
		String direction;
		//prints a greeting message when the user runs the program
		System.out.println("Welcome to the Text Adventure Game!");
		System.out.println("-----------------------------------");
		System.out.print("What is your name? ");
		input = inputSource.nextLine();
		//the user will type their name here
		System.out.println("Hello, " + input + "!");
		System.out.println("\n");//prints out a new line of whitespace
		System.out.println("Press the H key on the keyboard before playing the game to read the instructions.");
		System.out.println("If you know the instructions already, press the Enter key on the keyboard.");
		System.out.print("If by mistake you opened this application, press Q on the keyboard to quit the game. ");
		//the user will decide to start, get help or exit the game here
		

	}

}
