package operators;

import business.*;

public class Sum extends Operation{
	public Sum(OperationContainer owner, String id) {
		super(owner, id);
	}

	@Override
	public boolean calcResult() {
        double summ = 0;
        double temp = 1;
        
        while (temp != 0) {
        	temp = CalcStack.uniqueInstance().pop();
        	summ += temp;
        }		
		
		CalcStack.uniqueInstance().push(summ);		
		return true;
	}
}
