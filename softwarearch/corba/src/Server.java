import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    ORB orb = ORB.init(args, null);
		try {
		POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate(); // Nur auf server nögit.

		// Create a statistics object
		StatisticsImpl theStatistics = new StatisticsImpl();
  
		// get object reference from the servant
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(theStatistics);
		
		// convert ref to string and save it into file
		String  str = orb.object_to_string (ref);
		 BufferedWriter f = new BufferedWriter(
		          new FileWriter("Statistics.ref"));
		 f.write(str);
		 f.newLine();
		 f.close();
		 
	      System.out.println("Statistics Server is ready and waiting ...");

	      // wait for invocations from clients
	      orb.run();
		}
		catch(AdapterInactive ex){
			ex.printStackTrace();
		} catch (InvalidName e) {
			e.printStackTrace();
		} catch (ServantNotActive e) {
			e.printStackTrace();
		} catch (WrongPolicy e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
