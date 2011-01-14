package test;

import domain.Data;

public class DataTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data rightCorner = new Data(2, 5);
		Data leftCorner = new Data(3, 6);
		Data leftCorner2 = new Data(3, 6);
		
		System.out.println(rightCorner);

		if (leftCorner.equal(leftCorner2)) {
			System.out.println("beide linken Ecken sind gleicht.");
		}
		
		if (!rightCorner.equal(leftCorner)) {
			System.out.println("links und recht nicht gleicht");
		}
	}

}
