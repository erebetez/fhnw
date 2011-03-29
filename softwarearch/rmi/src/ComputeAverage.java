import java.rmi.*;
import java.rmi.registry.*;
import java.util.Vector;
import java.lang.Double;

public class ComputeAverage {

    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
	    Vector numbers = new Vector();
	    numbers.addElement( new Double( 1.0 ) );
	    numbers.addElement( new Double( 2.0 ) );
	    numbers.addElement( new Double( 3.0 ) );
	    numbers.addElement( new Double( 4.0 ) );
	    numbers.addElement( new Double( 3.0 ) );
	    numbers.addElement( new Double( 2.0 ) );
	    numbers.addElement( new Double( 1.0 ) );
	    

            Registry registry = LocateRegistry.getRegistry(args[0]);
            Statistics statistics = (Statistics) registry.lookup("Statistics");
	    Double avg= statistics.getAverage( numbers );

	    System.out.println( "Computed average: " + avg.toString() );

        } catch (Exception e) {
            System.err.println("ComputeAverage exception: " + 
                               e.getMessage());
            e.printStackTrace();
        }
    }
}
