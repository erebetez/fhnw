package business;

import java.util.*;


public class OperationContainer {
	
	private Vector<Operation> operationList; 

	public OperationContainer(){
		operationList = new Vector<Operation>();
	}
	
	public void add(Operation op){
		operationList.add(op);
	}
	
	public int getSize(){
		return operationList.size();
	}
	
	public String getBtnCaption(int idx){
		return operationList.elementAt(idx).getId();
	}
	
	public boolean calcResult(String btnCaption){
		
		for(Operation op: operationList)
			if( op.getId().equals( btnCaption ) )
				return op.calcResult();

		return false;
	}

}
