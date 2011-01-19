package operators;

import business.*;

public class Division extends Operation{
	public Division(OperationContainer owner, String id) {
		super(owner, id);
	}

	@Override
	public boolean calcResult() {
        double a, b;
        a = CalcStack.uniqueInstance().pop();
		b = CalcStack.uniqueInstance().pop();
		
		double c = a;
		
		try{
		    c = b / a;
		} catch(ArithmeticException e) {
			CalcStack.uniqueInstance().push(b);
		}
		
		CalcStack.uniqueInstance().push(c);		
		return true;
	}
}
