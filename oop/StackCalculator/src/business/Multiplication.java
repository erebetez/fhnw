package business;

public class Multiplication extends Operation{
	public Multiplication(OperationContainer owner, String id) {
		super(owner, id);
	}

	@Override
	public boolean calcResult() {
        double a, b, c;
        a = CalcStack.uniqueInstance().pop();
		b = CalcStack.uniqueInstance().pop();
		
		c = a * b;
		
		CalcStack.uniqueInstance().push(c);		
		return true;
	}
}
