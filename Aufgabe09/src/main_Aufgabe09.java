import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		
		do {
			printSticks(intSticks);
			// Mensch
			if (isHumanTurn) {
				intRemoveSticks = readIntInput("\n1 bis 3 Sticks nehemen:");
			   isHumanTurn = false;
			
			} else {
				System.out.println("\nComputer:");
				intRemoveSticks = ki(intSticks);
				System.out.println("Remove" + intRemoveSticks);
			    isHumanTurn = true;
			}
			
			
			intSticks -= intRemoveSticks;
						
		} while (intSticks > 0);
		
		

	}
	
	private static int ki(int sticks) {
		int take = 1;
		int newValue, temp;
		int i;
		
		/*
		 * anzahl stäbchen
		 * mögliche züge (1-3)
		 *   neuerWert = anzahl stäbchen - zug
		 * 
		 *    rekursives aufrufen
		 *     bis 
		 * 
		 * 
		 */
		for (i = 1; i <= 3; i++) {
			
			newValue = sticks - i;
			
			System.out.println(newValue);
			
			temp = getTurn(newValue);
			
			if (temp == -1)
				return i;
			
			if (newValue <= 0) {
				take = 1; //verloren				
			}
			take = i;

		}

		return take;
	}
	
	public static int getTurn(int sticks) {
		int newValue, i;
		for (i = 1; i <= 3; i++) {
			newValue = sticks - i;
			System.out.println(newValue);
			// Das ist gut
			if (newValue == 1) {
				return -1;
			}
			
			if (newValue <= 0) {
				return 1;
			}
			
			return getTurn(newValue);
			
		}
		
		
		return 3;
	}
	
	public static int ggt(int a, int b) {
		int r = 0;
		do {
			r = a % b;
			a = b;
			b = r;
		} while ( r != 0 && b != 0); // division with zero is evil
		return a;
	}
	
	private static void printSticks(int sticks) {
		System.out.print(sticks);
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

		} while (!Pattern.matches("-?[0-9]+", strInput));
			
		try { // convert String to double
			intInput = Short.valueOf(strInput);
		} catch (NumberFormatException e) {
			intInput = 0;
		} // error handling
		
		return intInput;
	}	

}
