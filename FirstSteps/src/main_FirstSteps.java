public class main_FirstSteps {
	public static void main(String[] args) {
//		Jupii
		System.out.println("Hallo welt! 'Super' ... 2");
		
		int i;
		double dbl = 9;
	    char ch = 'A';
	    
		i = 8;
		
        i++;

        dbl = Math.sqrt(dbl);
        
		System.out.println(i);
		System.out.println(dbl);
		System.out.println((char)(ch + 2));

		for (i = 0; i < 200; i++){
			
			System.out.println((char)(i));
		}
		
		System.out.println("\n--");
		
		if (i > 0 ) {			
		    System.out.println(i);
		}else{
			
		    System.out.println("kein Reele antowrt");
		}
		
		short winkel = 45;
		while (winkel != 90) {
			winkel++;
			System.out.println(winkel);
		}

	}
}
