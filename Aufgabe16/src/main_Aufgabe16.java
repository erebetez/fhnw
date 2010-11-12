
public class main_Aufgabe16 {
	public static void main(String[] args) {		
//		int[] arr = new int[4];
		int[] arr = {1, 4, 5, 1, 2};
		
		printArray(arr);
		arr = resize( arr, 10 );
		printArray(arr);
		
	}
	
	public static int[] resize(int[] a, int newSize) {
		int[] temp = new int[newSize];
				
		int toCopy = newSize < a.length ? newSize : a.length;		
		
		for( int i = 0; i < toCopy; ++i ) {
			temp[i] = a[i];			
		}
		
		return temp;		
	}
	
	
	private static void printArray(int[] myArray){
		int i;
		System.out.print("[ ");
		for (i = 0; i < myArray.length; ++i) {
			 System.out.print(myArray[i] + " ");
		}
		System.out.println("]");
	}
	

}
