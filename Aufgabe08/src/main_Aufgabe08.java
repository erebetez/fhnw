import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class main_Aufgabe08 {

	public static void main(String[] args) {

		boolean quit = false;
		int i, intStart;
		
		do {
			intStart = readIntInput("\nBitte anfangs zeichen angeben:");
			
			if (intStart >= 0 && intStart <= 256) {
				
				for (i = intStart * 256; i < intStart * 256 + 256; i++) {
					if (i % 32 == 0) {
						System.out.println();
						System.out.print("\t");
						System.out.print( i );
						System.out.print("\t");
					} else {
						System.out.print((char) i);
					}			
				}
			} else {
				quit = true;
			}
		
		} while(!quit);
	}
	
	
	// Reads from standard Input and return value if it is a number.
	private static int readIntInput(String strMessage) {
		int intInput;
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
			intInput = Integer.valueOf(strInput);
		} catch (NumberFormatException e) {
			intInput = 0;
		} // error handling
		
		return intInput;
	}	
}
