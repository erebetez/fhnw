package business;

public abstract class Operation {
    private String id;    
	
	public Operation(OperationContainer owner, String id){
		this.id = id;
		owner.add(this);
	}
	
	public String getId(){
		return id;
	}
	
	public abstract boolean calcResult();	
}
