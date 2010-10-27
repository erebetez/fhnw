import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.regex.Pattern;



public class main_Aufgabe03 {

	/**
	 * Solage wiederholen bis eingabe '?'
	 * 1. Ein Zeichen abfangen
	 * 2. Checken ob Zeichen im Alphabet
	 * 
	 * 3. Konsonante oder Vokal
	 * 
	 * 
	 */
	public static void main(String[] args) {
	    System.out.println("Aufgabe03\n");

		char chr;
  
		do {
		   System.out.println("Zeichen eingeben");	
		   chr = readChar();

		   System.out.println(chr);
		
//		   if ( Pattern.matches("[a-zA-Z]", chr) ) {
   
			   switch (chr) {
				   case 'a':
				   case 'e':
				   case 'o':
					   // etc ...
					   System.out.println("Vokale");
					   break;
				   case 'b':
				   case 'c':
					   // etc ...
					   System.out.println("Konsonate");
					   break;
					   
				   default:
					   System.out.println("Kein Buchstabe");
			   }
		   
		} while ( chr != '?' );

	}


	// Reads from standard Input.
	private static char readChar() {
		char chrInput = '0';		
		InputStreamReader input = new InputStreamReader(System.in);		
//		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
		
		// Read input
		try {
			chrInput = (char) input.read();
			
		} catch (IOException e) {
			
		}

		return chrInput;
	}	
	
}

