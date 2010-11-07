import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;



public class main_Aufgabe10 {

	public static void main(String[] args) {
		int[] firstFraction = new int[2];
		int[] seccondFraction = new int[2];
		int[] summedFraction = new int[2];
        int i;
		int dblGgt;
		
		System.out.println("Erster Bruch");
		firstFraction = readFraction();

		System.out.println("Zweiter Bruch");
		seccondFraction = readFraction();
		
		summedFraction = sumFrac(firstFraction, seccondFraction);

		System.out.println("Nach dem addieren");
		System.out.println(summedFraction[0] + "/" + summedFraction[1]);		
		
		dblGgt = ggt(summedFraction[0], summedFraction[1]);
		
		for (i = 0; i < summedFraction.length; ++i) {
			summedFraction[i] = summedFraction[i] / dblGgt;
		}
		
		System.out.println("Nach addition und kürzung");
		System.out.println(summedFraction[0] + "/" + summedFraction[1]);		
	}
	
	public static int[] sumFrac(int[] frac01, int[] frac2 ){
		int[] sum = new int[2];
		
		sum[0] = frac01[0] * frac2[1] + frac2[0] * frac01[1];
		sum[1] = frac01[1] * frac2[1];
				
		return sum;
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
	
	
	private static int[] readFraction() {
		int[] fraction = new int[2];
		fraction[0] = readDblInput("Zähler:");
		fraction[1] = readDblInput("Nenner:");
		return fraction;
	}
	
	// Reads from standard Input and return value if it is a number.
	private static int readDblInput(String strMessage) {
		int dblInput;
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
			
		try { // convert String to int
			dblInput = Integer.valueOf(strInput);
		} catch (NumberFormatException e) {
			dblInput = 0;
		} // error handling
		
		return dblInput;
	}	
}
