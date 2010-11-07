
public class main_Aufgabe11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        int i;		
		double[] myArray;		
//		double[] myArray = {1.3, 4, 5, 1, 1.1};
		
		System.out.println("Bitte Array eingeben");
		String strInput[] = Terminal.readString().split(" ");

		myArray = new double[strInput.length];
		for (i = 0; i < strInput.length; ++i) {
			try {
			   myArray[i] = Double.valueOf(strInput[i]);
			} catch (NumberFormatException e) {} // error 
		}		
		
		System.out.println("Summe: " + summUpArray(myArray));
		
		printArray(myArray);
		reverseArray(myArray);
		printArray(myArray);

	}
	
	private static double summUpArray(double[] array){
		double sum = 0;
		int i;
		
		for (i = 0; i < array.length; ++i) {
			sum += array[i];			
		}		
		return sum;
	}
	
	private static void reverseArray(double[] array) {
		int lenght = array.length, i;
		double[] tempArray = new double[lenght];
		
		// copy array
		for (i = 0; i < lenght; ++i){
			tempArray[i] = array[i];
		}
		
		// reverse
		for (i = 0; i < lenght; ++i){
			array[i] = tempArray[(lenght - 1) - i];			
		}
	}
	
	private static void printArray(double[] myArray){
		int i;
		for (i = 0; i < myArray.length; ++i) {
			 System.out.print(myArray[i] + " ");
		}
		System.out.println();
	}
	
	

}
