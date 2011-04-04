
import java.util.ArrayList;
import java.util.List;

import math.StatisticsPOA;


public class StatisticsImpl extends StatisticsPOA {
	private List<Double> numbers = new ArrayList<Double>();
	
	@Override
	public void setNumbers(double[] numbers) {
		for( Double d: numbers){
			this.numbers.add(d);
		}
	}

	@Override
	public double getAverage() {
		Double sum=0.;
		for( Double d: numbers){
			sum += d;
		}
		return sum/numbers.size();
	}

}
