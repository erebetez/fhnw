
public class main_Aufgabe15 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20, 22, 30, 33, 34, 35, 36, 40, 50, 100, 111, 123, 124, 222 };
		
		System.out.println(binFind(arr, 111));

	}

	public static int binFind(int[] arr, int find) {
		int r = arr.length;
		int l = 0;
		int pos = arr.length/2;
		int value = arr[pos];
		
		while ( value != find ) {
			if ( (r-l) < 2){
				return -1;
			}			
//			System.out.println("l " + l);
//			System.out.println("r " + r);
//			System.out.println("pos " + pos);
//			System.out.println("value " + value + "\n");

			if ( value > find ) {
                r = pos;
                pos = pos - ((r-l) / 2) - 1;    
			} else {
				l = pos;
				pos = pos + ((r-l) / 2);	
			}			
			value = arr[pos];					
		}
		
		return pos;		
	}
}
