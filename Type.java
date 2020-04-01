import java.util.Scanner;
public class Type {
	public static final String S = "firetruck";
	public static final int NumOfTry = 6;
	public static void main(String[] arg) {
		int i = 0;
		int rightCounter = 0;
		int NOT = NumOfTry;
		// Number of tries
		int WLI = S.length();
		// word length index
		char guess;
		char restart = 'y';
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome, this is Hangman.");
		System.out.println("You have " + NOT + " chances to guess wrong.");
		System.out.println("The word has " + S.length() + " letters. Good luck and have fun.");
		
		
		
		
		
		while (restart == 'y') {
			System.out.println("Please enter a letter");
			System.out.println();
			char [] input = new char [WLI];
			
			char [] output = new char[WLI];
			
			for (int j = 0; j < WLI; j++) {
				input[j] = S.charAt(j);
			}
			for (int j = 0; j < WLI; j++) {
				output[j] = '*';
			}
			
			while (i < NOT) {
				guess = in.next().charAt(0);
				//start running here
				for (int j = 0; j < WLI; j++) {
					if (input[j] == guess) {
						output[j] = input[j];
						input[j] = '*';
						i = 1;
						rightCounter++;
					}
				}
				
				if (i == 1) {
					System.out.println();
					for (int j = 0; j < WLI; j++) {
						System.out.print(output[j]);
					}
					System.out.println("");
					
					if (rightCounter == S.length()) {
						System.out.println("");
						System.out.println("Ok, you got it. It seems like u are not a dummy.");
						restart = 'n';
						break;
					}
					i = 0;
				} else {
					NOT--;
					if (NOT == 0) {
						System.out.println("");
						System.out.println("Booooooo! U suck. U just lost the game.");
						System.out.println();
						System.out.println("Want to restart? Y/N");
						restart = in.next().charAt(0);
						if (restart == 'y') {
							System.out.println("Let's do it!");
							continue;
						} else {
							System.out.println("Goodbye!");
							break;
						}
					} else {
						System.out.println("");
						System.out.println("You have " + NOT + " chances left.");
						System.out.println("");
						for (int j = 0; j < WLI; j++) {
							System.out.print(output[j]);
						}
						System.out.println("");
					}
				}
			}
			NOT = NumOfTry;
			rightCounter = 0;
		}
		in.close();
	}
}
