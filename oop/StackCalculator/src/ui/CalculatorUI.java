package ui;

import java.io.*;
import business.*;

public class CalculatorUI {
	OperationContainer op;
    
	public CalculatorUI(OperationContainer op){
		this.op = op;
		welcome();
		usage();

		calcLoop();
	
    }
	
	private void calcLoop(){
		String input;
		do {
			refreshStackView();
			input = read();
		} while((prozessInput(input)));
	}
	
		
	private void welcome(){
		System.out.println("Welcome to the Stackcalculator");
		System.out.println("==============================");		
	}
	
	private void usage(){
		System.out.print("\n");
		System.out.print("c=clear Stack; ");
		System.out.print("d=delete; ");
		System.out.print("e=exit; ");
		System.out.print("\n");
		
		for(int i = 0; i < op.getSize(); ++i ){
			System.out.print(op.getBtnCaption(i));
			System.out.print(" ");
		}
		System.out.print("\n");		
	}
    
	private void refreshStackView() {
		System.out.print("\n");		
		System.out.print(CalcStack.uniqueInstance()+": ");
	}
	
	private boolean prozessInput(String input){		
		
		// Calculate result
		if( op.calcResult(input) ){
			return true;		
		}

		if( input.equals("c") ){
			clearStack();
			return true;
		}

		if( input.equals("d") ){
			deleteLastNumber();
			return true;
		}

		// Exit Program
		if( input.equals("e") ){
			return false;
		}
		
		if( addNumber(input) ){
			return true;
		}
		
		usage();
		return true;	
	}
	
	private void clearStack(){
		CalcStack.uniqueInstance().clearList();
	}
	
	private void deleteLastNumber(){
		CalcStack.uniqueInstance().pop();
	}
	
	private boolean addNumber(String input){
		return CalcStack.uniqueInstance().push(input);
	}
	
	private String read(){
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
		try {
			return buffRead.readLine();
		} catch (IOException e) {
			return "";
		}		
	}
}
