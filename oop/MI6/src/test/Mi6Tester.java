package test;

import domain.*;

public class Mi6Tester {
	public static void main(String[] args) {
		Mi6 mi6 = new Mi6();
		
		for (int i = 0; i < 10; ++i){
		    mi6.addAgent(new Agent());
		}
		
		for (int i = 0; i < mi6.count(); ++i) {
			System.out.println(mi6.getAgent(i));
		}
	}
}
