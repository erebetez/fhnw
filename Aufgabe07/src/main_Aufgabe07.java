

public class main_Aufgabe07 {

	public static void main(String[] args) {

		int i;
		
		for (i = 32; i < 256; i++) {
			if (i % 32 == 0) {
				System.out.println();
				System.out.print("\t");
				System.out.print( i );
				System.out.print("\t");
			} else {
				System.out.print((char) i);
			}			
		}
	}
}
