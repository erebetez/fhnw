package domain;

public class A extends Base{

	public A(){
		System.out.println("hallo A");
	}
	
	public A(String txt){
		System.out.println("text A " + txt);
	}
	
	public void printMe(){
		System.out.println("PrintMe von A");
	}

	@Override
	public void printProtocol() {
		System.out.println("protocoll a");		
	}
	
	
}
