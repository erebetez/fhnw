package business;

public class Division extends Operation{
	public Division(OperationContainer owner, String id) {
		super(owner, id);
	}

	@Override
	public boolean calcResult() {
        double a, b, c;
        a = CalcStack.uniqueInstance().pop();
		b = CalcStack.uniqueInstance().pop();
		
		c = a / b;
		
		CalcStack.uniqueInstance().push(c);		
		return true;
	}
}
