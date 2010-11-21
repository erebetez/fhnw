
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
		   if (j < lenght(source)) {
			   try{			  
			        destination[i] = source[j++];      
			   }catch (ArrayIndexOutOfBoundsException e) {
					if (destination[i] != (char) 0) {
						destination[i] = (char) 0; 
					}	
			   } // error handling
		   }
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

//		System.out.println("totalcapacity" + len);
		return len;
		
	}
	
	public static int compare(char[] string1, char[] string2){
		
		int min;
				
		min = lenght(string1) < lenght(string2) ? lenght(string1) : lenght(string2);
		System.out.println(min);
		
		for (int i = 0; i < min; ++i) {
//			if( string1[i] > 'z'){
//				string1[i] = string1[i] - 'A';
//			}
			
			if( string1[i] < string2[i] ) {
				return 1;				
			}
			if( string1[i] > string2[i] ) {
				return -1;
			}			
		}
		
		return 0;
	}
	
	public void show(){
		
		
	}
	
	
}
