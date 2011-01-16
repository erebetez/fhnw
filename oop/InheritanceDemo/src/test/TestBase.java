package test;

import java.util.*;

import domain.*;

public class TestBase {

	public static void main(String[] args) {
		A anA = new A();
		B anB = new B("abcdefg");
		
		anA.printMe();
		
		Vector<Base> v = new Vector<Base>();

		v.add(new B());
		v.add(new A());		
		
		for (int i = 0; i < v.size(); ++i)
			v.get(i).printMe();
		
	}

}
