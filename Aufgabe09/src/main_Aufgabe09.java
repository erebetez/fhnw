import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;


public class main_Aufgabe09 {

	/**
	 * Hölzchen spiel
	 * 
	 * wiederholen bis kein hölzchen
	 *    spieler 1 
	 *     1 bis 3 hölzchen ziehen
	 *    cpu
	 *     1 bis 3 hölzchen ziehen
	 *     
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int intSticks = 20;
		int intRemoveSticks = 1;
		boolean isHumanTurn = true;
		
		printSticks(intSticks);
		
		while ( intSticks > 1 ) {
		
			// Mensch
			if (isHumanTurn) {
				intRemoveSticks = readIntInput("\n1 bis 3 Sticks nehemen:");
			   isHumanTurn = false;
			
			} else {
				System.out.println("\nComputer:");
				intRemoveSticks = ki(intSticks);
//				System.out.println("Remove" + intRemoveSticks);
			    isHumanTurn = true;
			}
			intSticks -= intRemoveSticks;		
			printSticks(intSticks);
		}

		if (isHumanTurn) {
			System.out.println("\nGame Over");
		} else {
			System.out.println("\nGewonnen!");
		}
	}
	
	private static int ki(int intSticks) {
		// TODO make that dynamic later
		int maxRemovable = 3;

		// verloren
		if (intSticks == 1)
			return 1;       
		
		// schlechter fall
		if ( ( intSticks - 1) % (maxRemovable + 1) == 0 ) {			
			Random myRandom = new Random( new Date().getTime());
			int rand = myRandom.nextInt(3);
			rand++;
            return rand;            
		} else {		
			// rest ist zwischen 1 und maxRemovalbe
			return ( intSticks - 1 ) % ( maxRemovable + 1 );
		}
		
	}
	
	private static void printSticks(int sticks) {
		System.out.print(sticks + "\t");
		while (sticks > 0) {
		    System.out.printf(" |");
		    --sticks;
		}
		System.out.println();
	}
	
	// Reads from standard Input and return value if it is a number.
	private static int readIntInput(String strMessage) {
		short intInput;
		String strInput = "";
		// Creating a BufferReader from standard input.
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print(strMessage + " ");
			// Read input
			try {
				strInput = buffRead.readLine();
			} catch (IOException e) {}			

		} while (!Pattern.matches("[1-3]?", strInput));
			
		try { // convert String to double
			intInput = Short.valueOf(strInput);
		} catch (NumberFormatException e) {
			intInput = 0;
		} // error handling
		
		return intInput;
	}	

}
