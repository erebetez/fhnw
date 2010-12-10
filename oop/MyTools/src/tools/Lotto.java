package tools;

import domain.MyTools;

public class Lotto {
  public static int[] getTip(){
	  // Sechser Array zurückgeben mit zufalzahlen
	  int[] lotto = new int[6];
	  int i = 0;
	  int rand;	  
	  
	  while (i < 6){
	     rand = MyTools.getRandom(1, 42);
	
	     if (!isNumberInArray(rand, lotto)){
	    	 lotto[i++] = rand;	    	 
	     }
	  }
	  
	 return lotto;
  }
  
  private static boolean isNumberInArray(int number, int[] array) {
	 for (int j = 0; j < array.length; ++j) {
		 if (number == array[j]) {
			 return true;
		 }
	 }
	 return false;
  }
  
}
