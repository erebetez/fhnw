package domain;

public class B extends Base{

	public B(){
		System.out.println("hallo B");
	}
	
	public B(String txt){
		super(txt);
		System.out.println("text B " + txt);
	}
	
	public void printMe(){
		System.out.println("PrintMe von B");
	}
	
	@Override
	public void printProtocol() {
		System.out.println("protocoll b");		
	}
}
