import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class main_Aufgabe08 {

	public static void main(String[] args) {
		int i, intStart;
		int intMaxChar = 256;
		int intRowLenght = 32;
		
		do {
			intStart = readIntInput("\nBitte anfangs zeichen angeben:");
			
			if (intStart >= 0 && intStart <= intMaxChar) {

				for (i = intStart * intMaxChar; i < intStart * intMaxChar + intMaxChar; ++i) {
					if (i % intRowLenght == 0) {
						System.out.printf("\n%1$10d", i );
					}
//					writeFormated(i);
					System.out.print(String.format("%1$3s", (char) i));
				}
			}
		} while(intStart >= 0);
	}
	
	private static void writeFormated(int value){
//		if (value < 10) System.out.print(" ");
//		if (value < 100) System.out.print(" ");
//		if (value < 1000) System.out.print(" ");
		int scale = 10;
		
//		double x = Math.log10(value);
		
		
		while (scale < 1000) {
			System.out.print(" ");
			scale *= 10;
		}
		
		System.out.print((char) value);
		
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
