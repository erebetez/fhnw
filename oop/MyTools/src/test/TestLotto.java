package test;

import tools.Lotto;
import domain.MyTools;

public class TestLotto {

	public static void main(String[] args) {
        int i = 0;
		while(i++ < 20 ){
		   MyTools.printArray(Lotto.getTip());
		}
	}

}
