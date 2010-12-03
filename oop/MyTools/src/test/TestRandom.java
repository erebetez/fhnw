package test;

import domain.MyTools;

public class TestRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        for (int i = 0; i < 30; ++i) {
		    System.out.println("Rand " + MyTools.getRandom(5, 10));
        }
	}

}
