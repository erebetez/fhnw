


public class main_Aufgabe13 {
	public static void main(String[] args) {
		String strInput;
		StringBuilder buffer = new StringBuilder();
		int[] histogramm = new int[26];
		
		do {
		   strInput = Terminal.readString();
		   buffer.append(strInput);			
		} while(strInput.length() > 0);

		analyze(histogramm, buffer);
		printHistogram(histogramm);
	}
	
	public static void analyze(int[] arr, StringBuilder buffer){
		char chrTmp;
		int intTmp;
		
		for( int i = 0; i < buffer.length(); ++i ){
			chrTmp = buffer.charAt(i);			
			intTmp = (int) chrTmp;
			
			if (intTmp >= (int) 'a' && intTmp <= (int) 'z' ){
				intTmp -= 32;
			}			

			if (intTmp >= (int) 'A' && intTmp <= (int) 'Z' ){				
				arr[intTmp - (int) 'A']++;
			}
		}
	}
	
	public static void printHistogram(int[] histogramm){
		int summ = summUpArray(histogramm);		
		char temp = 0;
		double percent;
		
		System.out.println("Total chars: " + summ);
		
		System.out.println("Char | anzahl | prozent");
		for( int i = 0; i < histogramm.length; ++i){
			percent = (double) histogramm[i]/ (double) summ * 100;
			temp = (char) (i + 64 + 1);			
			System.out.println(temp + " | " + histogramm[i] + " | " + percent + "%");
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
