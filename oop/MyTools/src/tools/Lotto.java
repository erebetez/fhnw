package tools;

import domain.MyTools;

public class Lotto {
  public static int[] getTip(){
	  // Sechser Array zurückgeben mit zufalzahlen
	  int[] lotto = new int[6];
	  int i = 0;
	  boolean isOk = true;
	  int rand;
	  
	  
	  while (i < 6){
	     rand = MyTools.getRandom(1, 42);
	     
	     for (int j = 0; j < lotto.length; ++j) {
	    	 if (rand == lotto[j]) {
	    		 isOk = false;
	    	 }
	     }
	     
	     if (isOk == true){
	    	 lotto[i++] = rand;	    	 
	     }
	     isOk = true;
	  }
	  
	  return lotto;
  }
}
