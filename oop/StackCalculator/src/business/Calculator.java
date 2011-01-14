package business;

import ui.CalculatorUI;

public class Calculator {

		public Calculator(){
		OperationContainer opContainer = new OperationContainer();
		new Addition(opContainer, "+");
		new Subtraction(opContainer, "-");
		new Multiplication(opContainer, "*");
		new Division(opContainer, "/");
		new Mean(opContainer,"mean");
		new Sum(opContainer, "sum");
		new CalculatorUI(opContainer);
		}

		public static void main(String[] args) {
		    new Calculator();
		}	
		
}
