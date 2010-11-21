
public class MyString {
//    private char[] m_string;
	
//	MyString(){
//		m_string[0] = '0';
//	}
//	
//	MyString(char[] string){
//		m_string = string;
//	}
	
	public static int lenght(char[] string){
		int i = 0;
		try{
			while( string[i++] != (char) 0 ){				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		} // error handling
		return --i;
	}
	
	public static char[] concat(char[] string, char[] string2){
		int i = 0;

		char [] newString = new char[lenght(string) + lenght(string2) + 1];
		
		for (i = 0; i < lenght(string); ++i ) {
			newString[i] = string[i];			
		}
		
		for( int j = 0; j < lenght(string2); ++j) {
			newString[i++] = string2[j];
		}
		
		newString[i] = (char) 0;
		return newString;		
	}
	
	
	public static void append(char[] destination, char[] source){
		int j = 0, i;
		
		for( i = lenght(destination); i < totalLenght(destination); ++i) {
		   try{			  
		        destination[i] = source[j++];
		        System.out.println(destination);
//				if (destination[i] != (char) 0) {
//					destination[i] = (char) 0; 
//				}		      
		   }catch (ArrayIndexOutOfBoundsException e) {
				if (destination[i] != (char) 0) {
					destination[i] = (char) 0; 
				}	
		   } // error handling
		}		

	}
	
	public static int totalLenght (char[] string){
		int len = 0;
		char buff;
		try{
		    for(;;){
				buff = string[len];
				++len;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		} // error handling

		System.out.println("totalcapacity" + len);
		return len;
		
	}
	
	public static int compare(char[] string1, char[] string2){
		return -1;
	}
	
	public void show(){
		
		
	}
	
	
}
