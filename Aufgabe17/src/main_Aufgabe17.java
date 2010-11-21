
public class main_Aufgabe17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
      char[] test = generateString("Hallo", 18);
      char[] test2 = generateString(" Welt", 8);
      char[] test3 = generateString("...", 8);

      String original = new String(test);
      System.out.println(original);
      System.out.println(MyString.lenght(test));
      
      System.out.println(MyString.concat(test, test2));
      MyString.append(test, test3);
	  System.out.println(test);
	}

    public static char[] generateString(String s, int capacity){
		char[] result = new char[capacity];
		for (int i=0; i<s.length(); ++i)
		    result[i] = s.charAt(i);
		result[s.length()] = (char) 0;
		return result;
	}	
	
	
}
