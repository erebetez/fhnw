import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;


public class main_Aufgabe06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double z1, z2, n1, n2;
		double zAdd, nAdd;
		double dblGgt;
		
		System.out.println("Erster Bruch");
		z1 = readDblInput("Zähler:");
		n1 = readDblInput("Nenner:");

		System.out.println("Zweiter Bruch");
		z2 = readDblInput("Zähler:");
		n2 = readDblInput("Nenner:");
		
		zAdd = z1 * n2 + z2 * n1;
		nAdd = n1 * n2;

		System.out.println("Nach dem addieren");
		System.out.println(zAdd + "/" + nAdd);		
		
		dblGgt = ggt(zAdd, nAdd);
		
		zAdd = zAdd / dblGgt;
		nAdd = nAdd / dblGgt;
		
		System.out.println("Nach addition und kürzung");
		System.out.println(zAdd + "/" + nAdd);		
		
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
}
