package test;

import business.*;

//import Stack01;

public class Stack01_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testStack01();
		testStack02();

	}
	
	public static void testStack01(){
		int stackSize = 3;
		Stack01 myStack = new Stack01(stackSize);
		double v = 0.01;
		int i = 10;
		System.out.println("Stack-Elemente in den Stack füllen:");
		while (!myStack.isFull()) {
			myStack.push(i + v);
			System.out.println(i + v);
			i++;
		}
		System.out.println("Stack-Elemente im Stack anszeigen:");
		for (int j = 0; j < myStack.getAmount(); j++) {
			System.out.println(myStack.getValue(j));
		}
		System.out.println("Stack-Elemente mit aus dem Stack nehmen:");
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
	}
	
	public static void testStack02(){
		int stackSize = 3;
		Stack02 myStack = new Stack02(stackSize);
		Double tmpDouble;
		double v = 0.01;
		int i = 10;
		System.out.println("Stack-Elemente in den Stack füllen:");
		do {
			tmpDouble = new Double(i + v);
			System.out.println(i + v);
			i++;
		} while (myStack.push(tmpDouble));
		
		System.out.println("Stack-Elemente im Stack anszeigen:");
		for (int j = 0; j < myStack.getAmount(); j++) {
			tmpDouble = (Double) myStack.getValue(j);
			System.out.println(tmpDouble.doubleValue());
		}
		
		System.out.println("Stack-Elemente mit aus dem Stack nehmen:");
		while (tmpDouble != null) {
			try {
				tmpDouble = (Double) myStack.pop();			
				System.out.println(tmpDouble.doubleValue());
			} catch (NullPointerException e) {				
			}
		}		
	}
	

}
