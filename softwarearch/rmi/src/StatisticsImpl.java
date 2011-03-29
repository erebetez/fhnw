import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

import java.util.Vector;
import java.util.Iterator;

public class StatisticsImpl implements Statistics
{
    public StatisticsImpl() {
        super();
    }
    
    public Double getAverage( Vector numbers ) {
	if( numbers.size()==0 )
	    return new Double(0.0);

	Iterator i = numbers.iterator();
	double sum = 0.0;
	while ( i.hasNext() ){
	    sum += ((Double)i.next()).doubleValue();
	}
	
	return new Double(sum/numbers.size());
    }
    
    public static void main(String[] args) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }

        try {
       Statistics engine = new StatisticsImpl();
       Statistics stub =
          (Statistics) UnicastRemoteObject.exportObject(engine,0);
       Registry registry = LocateRegistry.getRegistry("localhost");
       registry.rebind("Statistics", stub);
       System.out.println("StatisticsImpl bound");
        } catch (Exception e) {
            System.err.println("StatisticsImpl exception: " + 
                               e.getMessage());
            e.printStackTrace();
        }
    }
}
