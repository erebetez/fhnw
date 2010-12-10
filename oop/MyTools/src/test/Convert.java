package test;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int value = 0;
		boolean ok = true;
		
		do {
			System.out.print("Ganze Zahl: ");
			String a = in.nextLine();
			
			try{
				value = Integer.parseInt(a);
				ok = true;
			} catch (NumberFormatException nfex) {
				System.out.println("Keine ganze Zahl, bitte Zahl eingeben.");
				ok = false;
			}
			
		} while (!ok);
		
		System.out.println(value);
	}

}
