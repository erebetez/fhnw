package operators;

import business.CalcStack;
import business.Operation;
import business.OperationContainer;

public class Mean extends Operation{
	public Mean(OperationContainer owner, String id) {
		super(owner, id);
	}

	@Override
	public boolean calcResult() {
        double summ = 0;
        double temp = 1;
        
        int count = CalcStack.uniqueInstance().size();
//        System.out.println(count);
        
        while (temp != 0) {
        	temp = CalcStack.uniqueInstance().pop();
//        	System.out.println(temp);
        	summ += temp;
        }
		
		double c = summ / count;
		
		CalcStack.uniqueInstance().push(c);		
		return true;
	}
}
