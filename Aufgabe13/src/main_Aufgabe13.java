


public class main_Aufgabe13 {
	public static void main(String[] args) {
		String strInput;
		StringBuilder buffer = new StringBuilder();
		int[] histogramm = new int[26];
		
		long start = System.currentTimeMillis();
		
		do {
		   strInput = Terminal.readString();
		   buffer.append(strInput);			
		} while(strInput.length() > 0);

		analyze(histogramm, buffer);
		printHistogram(histogramm);
		
		System.out.println(System.currentTimeMillis() - start + "ms");
	}
	
	public static void analyze(int[] arr, StringBuilder buffer){
		char chrTmp;

		for( int i = 0; i < buffer.length(); ++i ){
			chrTmp = buffer.charAt(i);			
			
			if (chrTmp >= 'a' && chrTmp <=  'z' ){
				arr[chrTmp - 'a']++;
			}			

			if (chrTmp >= 'A' && chrTmp <= 'Z' ){
				arr[chrTmp - 'A']++;
			}
		}
	}
	
	public static void printHistogram(int[] histogramm){
		int summ = summUpArray(histogramm);		
		char temp = 0;
		float percent;
		
		System.out.println("Total chars: " + summ);
		
		System.out.println("  |   n |   %");
		System.out.println("__|_____|________");
		for( int i = 0; i < histogramm.length; ++i){
			percent = (float) histogramm[i]/ (float) summ * 100;
			
			temp = (char) (i + 'A');			
			System.out.printf("%1$1s | %2$3d | %3$6.2f%%\n", temp, histogramm[i], percent);
		}		
	}
	
	private static int summUpArray(int[] array){
		int sum = 0;
		
		for (int i = 0; i < array.length; ++i) {
			sum += array[i];			
		}
		
		return sum;
	}

}
