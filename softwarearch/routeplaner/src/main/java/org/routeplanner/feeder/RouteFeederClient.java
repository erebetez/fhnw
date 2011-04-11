package org.routeplanner.feeder;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.routeplanner.service.RouteManager;
import org.routeplanner.service.RouteManagerHelper;


public class RouteFeederClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
    Properties props = new Properties();
    URL url = ClassLoader.getSystemResource("orb.properties");
    props.load(url.openStream());

    ORB orb = ORB.init(args, props);

    // get the root naming context
    org.omg.CORBA.Object objRef;
		try {
			objRef = orb.resolve_initial_references("NameService");
			NamingContextExt nc = NamingContextExtHelper.narrow(objRef);
			org.omg.CORBA.Object obj = nc.resolve_str("RouteManager");

			RouteManager routeMgr = RouteManagerHelper.narrow(obj);
			
			RouteFeeder feeder = new RouteFeeder( routeMgr );
			System.out.println("Loading cities and routes..");
			System.out.println( "total cities :" + feeder.loadCities("/cities.txt") );
			System.out.println( "total routes :" + feeder.loadRoutes("/routes.txt") );

		} catch (InvalidName e) {
			e.printStackTrace();
		} catch (NotFound e) {
			e.printStackTrace();
		} catch (CannotProceed e) {
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}

	}

}
