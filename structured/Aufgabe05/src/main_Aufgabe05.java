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

		double a = 1, b = 1;
		double result;
		
		a = readDblInput();
		b = readDblInput("Bitte zweite Zahl eingeben:");
		
		while (a != 0 && b != 0) {
			result = ggt(a, b);
	
			System.out.println("Der Grösste gemeinsame Teiller von " + a + " und " + b + " ist " + result);
			
			a = readDblInput();
			b = readDblInput("Bitte zweite Zahl eingeben:");
		}
	}

	public static double ggt(double a, double b) {
		double r = 0;
		do {
			r = a % b;
			a = b;
			b = r;
		} while ( r != 0 && b != 0); // division with zero is evil
		return a;
	}
	
	// Reads from standard Input and return value if it is a number.
	private static double readDblInput(String strMessage) {
		double dblInput;
		String strInput = "";
		// Creating a BufferReader from standard input.
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.print(strMessage + " ");
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
