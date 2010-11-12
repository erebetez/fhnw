
public class main_Aufgabe11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("Bitte Array eingeben");
//		double[] myArray = new double[5];
		double[] myArray = {1.3, 4, 5, 1, 1.1};
		
		printArray(myArray);
		System.out.println(summUpArray(myArray));		
		
		System.out.println(mittelwert(myArray));		
		
		reverseArray(myArray);
		printArray(myArray);
		
		reverseArray2(myArray);
		printArray(myArray);
		
		reverseArray3(myArray);
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
	
	private static double mittelwert(double[] array) {	
		return summUpArray(array) / array.length;
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
	
	private static void reverseArray2(double[] array) {
		int l = 0;
		int r = array.length -1;
		double temp;
		
		while ( l < r ) {
			temp = array[l];
			array[l++] = array[r];
			array[r--] = temp;			
		}				
	}
	
	private static void reverseArray3(double[] array) {
		double temp;
		
		for(int l = 0; l < array.length / 2; ++l) {
			temp = array[l];
			array[l] = array[array.length - 1 - l];
			array[array.length - 1 - l] = temp;
		}			
	}
	
	private static void printArray(double[] myArray){
		int i;
		System.out.print("[ ");
		for (i = 0; i < myArray.length; ++i) {
			 System.out.print(myArray[i] + " ");
		}
		System.out.println("]");
	}
	
	

}
