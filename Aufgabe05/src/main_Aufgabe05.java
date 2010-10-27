import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class main_Aufgabe05 {

	/**
	 * ggt nach Euklid
	 * 
	 * Eingabe a
	 * Eingabe b
	 * Wiederhole  {
	 *   r = a mod b  
	 *    a = b;
	 *    b = r;
	 *    wenn r == 0 dann verlasse schleife
	 * }
	 */
	public static void main(String[] args) {
		System.out.println("Aufgabe05");

		double a = readDblInput();
		double b = readDblInput("Bitte zweite Zahl eingeben:");
		double r = 0;
		
		do {
			r = a % b;
			a = b;
			b = r;
		} while ( r != 0 && a != 0);
		
		System.out.println("Der Grösste gemeinsame Teiller ist " + a);
	}

	
	// Reads from standard Input and return value if it is a number.
	private static double readDblInput(String strMessage) {
		double dblInput;
		String strInput = "";
		// Creating a BufferReader from standard input.
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println(strMessage);
			// Read input
			try {
				strInput = buffRead.readLine();
			} catch (IOException e) {}			

		} while (!Pattern.matches("-?[0-9]+[.]?[0-9]*", strInput));
			
		try { // convert String to double
			dblInput = Double.valueOf(strInput);
		} catch (NumberFormatException e) {
			dblInput = 0;
		} // error handling
		
		return dblInput;
	}	
	
	// Wow, java can overload functions;) 
	private static double readDblInput() {
		return readDblInput("Bitte eine Zahl eingeben:");	
	}
}
