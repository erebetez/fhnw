import java.io.*;

public class main_Aufgabe01 {

	/**
	 * input                        prozent
	 *   |
	 *   + wenn < 10000            -> 0%
	 *   + wenn 10000 bis 39999    -> 2%
	 *   + wenn 40000 bis 99999    -> 5%
	 *   + wenn >= 100000          -> 8%
	 *  
	 *   resultat = input * prozent / 100
	 */
	public static void main(String[] args) throws IOException{
       System.out.println("Aufgabe 01");
       
       double dblIncome = -1;
       double dblResult = 0;
       int    intPercent = 0;
       String strInput;
    	
       if ( args.length == 1) {
    	   strInput = args[0];
       } else {       
	       // Creating a BufferReader from standard input.   
	       BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
	
	       System.out.println("Bitte Einkommen eingeben: ");
	       
	       // Read input
	       strInput = buffRead.readLine();
	   }
       
       // convert String to double
       try { 
           dblIncome = Double.valueOf( strInput );
   	   } catch (NumberFormatException e) {} // error handling
       
       
   	   // Get the percentage of the tax
       if ( dblIncome >= 0 && dblIncome  < 10000 ) {
    	   intPercent  = 0;
    	   
	   } else if ( dblIncome >= 10000 && dblIncome  < 40000 ) {
    	   intPercent = 2;
    	   
       } else if ( dblIncome >= 40000 && dblIncome  < 100000 ) {
    	   intPercent = 5;
    	   
       } else if ( dblIncome >= 100000 ) {
    	   intPercent = 8;
    	   
       } else {
    	   intPercent = -1;
       }
       
       // calculate the tax according to the percentage
       if (intPercent == 0 ) {
    	   System.out.println("Jipii, es sind keine Steuern zu zahlen");
    	   
       } else if ( intPercent != -1 ) {
    	   dblResult = dblIncome * intPercent / 100;
    	   System.out.println("Steuern zu zahlen: " + dblResult);
    	   
       } else {    	   
    	   System.out.println("Eingabe nicht korrekt: " + strInput);
    	   
       }
	}
}
