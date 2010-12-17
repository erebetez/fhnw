package test;

import domain.Data;
import domain.Pool;

public class PoolTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pool myData = new Pool();
		
		for (int i = 0; i < 10; ++i){
			myData.addData(new Data());
		}
		
		for (int i = 0; i < myData.getDataCount(); ++i) {
			System.out.println(myData.getData(i));
		}

	}

}
