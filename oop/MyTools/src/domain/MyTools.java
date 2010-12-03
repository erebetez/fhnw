package domain;

import java.util.*;

public class MyTools {

	public static int sign(double number) {
		if (number == 0){
		  return 0;
		}
		if (number > 0) {
		  return 1;
		}
		return -1;
	}
	
	public static int getRandom(int min, int max){
		Random rand = new Random();
		int n = rand.nextInt(max - min + 1);
				
		return n + min;
	}
	
	public static void printArray(int[] myArray){
		System.out.print("[");
		for (int i = 0; i < myArray.length; ++i) {
			 System.out.printf("%1$3d", myArray[i]);
		}
		System.out.println(" ]");
	}
}
