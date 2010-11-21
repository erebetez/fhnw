
public class main_Aufgabe14 {
    
	public static void main(String[] args) {
		int[] array= {4, 9, 3, 6, 2 , 1, 3, 7, 2, 1, 2};
		int start = 0;
		
		printArray(array);
		StaightSort(array, start, array.length);
		printArray(array);
	}
	
	public static void StaightSort(int[] array, int start, int end){
		int pos = start;
		int tempValue;
		int tempPos;
				
		while (start < (end - 1)) {
			tempValue = array[start];
			tempPos = start;
			for (pos = start; pos < end; ++pos){				
				if (array[pos] < tempValue ) {
				  tempValue = array[pos];
				  tempPos = pos;
				}
			}
			if (array[tempPos] != array[start]) {
				array[tempPos] = array[start];
				array[start] = tempValue;
			}
			++start;
		}
	}
	
	private static void printArray(int[] myArray){
		int i;
 		System.out.print("[");
		for (i = 0; i < myArray.length; ++i) {
			 System.out.printf("%1$2d", myArray[i]);
		}
		System.out.println(" ]");
	}
	
}
