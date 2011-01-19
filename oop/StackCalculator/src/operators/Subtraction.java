package operators;

import business.CalcStack;
import business.Operation;
import business.OperationContainer;

public class Subtraction extends Operation{
	public Subtraction(OperationContainer owner, String id) {
		super(owner, id);
	}

	@Override
	public boolean calcResult() {
        double a, b, c;
        a = (Double) CalcStack.uniqueInstance().pop();
		b = (Double) CalcStack.uniqueInstance().pop();
		
		c = b - a;
		
		CalcStack.uniqueInstance().push(c);		
		return true;
	}
}
