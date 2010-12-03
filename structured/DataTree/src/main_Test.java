

public class main_Test {

	public static void main(String[] args) {
		int[] array = new int[4];
		
		
		clear(test);
	}
	
	static void clear(Node root){
		   if(root != null) {
		        root.data = 0;
		        clear(root.L);
		        clear(root.R);
		   }
	}
	
	
}
