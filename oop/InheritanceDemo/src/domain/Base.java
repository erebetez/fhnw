package domain;

public abstract class Base implements Protocollable {

	public Base(){
		System.out.println("hallo Base");
	}
	
	public Base(String txt){
		System.out.println("Base text " + txt);
	}
	
	public abstract void printMe();

}
