import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Date;
//import java.util.Random;
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
        boolean quit = false;
		
		int intSticks = 20;
		int maxRemovable = 3;
		boolean isHumanTurn = true;
        
        System.out.println("Willkommen zum Stäbchenspiel");
        
		while(!quit) {
			System.out.println("\n1) Spielen");
			System.out.println("2) Einstellungen");
			System.out.println("3) Verlassen");
						
			switch(readIntInput("Eingabe:")) {
			  case 1:
				  game(intSticks, maxRemovable, isHumanTurn);	  
				  break;
			  case 2:
				  intSticks = readIntInput("Anzahl Stäbchen setzen:");
				  maxRemovable = readIntInput("Maximale Stäbhchenzahl pro Zug:");
				  System.out.print("Soll Mensch anfangen(j/n): ");
				  isHumanTurn = Terminal.readBool();
				  break;
			  case 3:
				 quit = true; 
			     break;
			}

		}		
		 System.out.println("\nTschüss.");		
	}

	
	private static void game(int intSticks, int maxRemovable, boolean isHumanTurn) {
		int intRemoveSticks = 1;
		
		printSticks(intSticks);
		
		while ( intSticks > 1 ) {		
			// Mensch
			if (isHumanTurn) {
				intRemoveSticks = readIntInput("1 bis " + maxRemovable + " Sticks nehemen:");
			    if (intRemoveSticks > 0 && intRemoveSticks <= maxRemovable ){
				    isHumanTurn = false;
			    } else {
			    	intRemoveSticks = 0;	
			    }
			
			} else {
				System.out.print("Computer: ");
				intRemoveSticks = ki(intSticks, maxRemovable);
				System.out.println(intRemoveSticks);
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

	
	private static int ki(int intSticks, int maxRemovable) {
		// verloren
		if (intSticks == 1)
			return 1;       
		
		// schlechter fall
		if ( ( intSticks - 1) % (maxRemovable + 1) == 0 ) {			
//			Random myRandom = new Random( new Date().getTime());
//			int rand = myRandom.nextInt(maxRemovable);
//          return ++rand; 
            return (int) Math.round(Math.random() * maxRemovable + 0.5);
		} else {
			// rest ist zwischen 1 und maxRemovalbe
			return ( intSticks - 1 ) % ( maxRemovable + 1 );
		}
		
	}
	
	private static void printSticks(int sticks) {
		System.out.print("\n" + sticks + "\t");
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

		} while (!Pattern.matches("[0-9]+", strInput));
			
		try { // convert String to double
			intInput = Short.valueOf(strInput);
		} catch (NumberFormatException e) {
			intInput = 0;
		} // error handling
		
		return intInput;
	}	

}
