package org.example.math.service;

import java.util.ArrayList;
import java.util.List;


public class StatisticsImpl implements Statistics {
	List<Double> numbers = new ArrayList<Double>();
	
	public void addNumber(double d) {
		numbers.add(d);
	}

	public double getAverage() {
		double sum=0;
		if( numbers.size()==0) return 0;
		for( Double d: numbers){
			sum += d;
		}
		return sum/numbers.size();
	}

}
