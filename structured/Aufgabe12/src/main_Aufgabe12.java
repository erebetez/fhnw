
public class main_Aufgabe12 {
	public static void main(String[] args) {
//		int[][] myArray = {{1, 4, 5, 1, 2}, {7, 7, 7, 7, 7}, {8, 8, 8, 8}};
		int[][] myArray = new int[3][3];
		
		fillMatrix(myArray);
		
		display(myArray);
		
		System.out.println(sumElemetns(myArray));

	}
	
	public static void fillMatrix(int[][] m) {
		for( int i = 0; i < m.length; ++i) {
			for( int j = 0; j < m.length; ++j){
				System.out.print("[" + i + "][" + j + "]: ");
				m[i][j] = Terminal.readInt();			
		    }
			
		}		
	}
	
	public static int sumElemetns(int[][] m){
		int summ = 0;
		for( int i = 0; i < m.length; ++i) {
			for( int j = 0; j < m.length; ++j){
				summ += m[i][j];			
		    }			
		}
		return summ;
	}
	
	public static void display(int[][] m){
		for( int i = 0; i < m.length; ++ i) {
			printArray(m[i]);
		}				
	}
	
	private static void printArray(int[] myArray){
		int i;
 		System.out.print("[ ");
		for (i = 0; i < myArray.length; ++i) {
			 System.out.printf("%1$5d", myArray[i]);
		}
		System.out.println("]");
	}

}
