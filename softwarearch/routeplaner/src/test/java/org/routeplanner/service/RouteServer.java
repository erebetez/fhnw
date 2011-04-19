package org.routeplanner.service;

import java.io.IOExeption;
import java.net.URL;
import java.util.Properties;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.routeplanner.doa.*;


public class RouteServer {
    public static void main( String [] args ){
    	try {
    		Properties props = new Properties();
    		URL url = ClassLoader.getSystemResource("orb.properties");
    		props.load(url.openStream());
    		
    		ORB orb = ORB.init(args, props);
    		
    		POA rootpoa = POAHelper.narrow(
    				orb.resolve_initial_references("RootPOA"));
    		
    		rootpoa.the_POAManager().activate();
    		
    		RouteDao dao = new RouteDao();
    		
    		RouteManagerImpl theRouteManager = 
    			new RouteManagerImpl(orb, rootpoa);
    		theRouteManager.setRouteDoa(dao);
    				
    		org.omg.CORBA.Object ref=
    			rootpoa.servant_to_reference(theRouteManager);
    		RouteManager mref = RouteManagerHelper.narrow(ref);
    		
    		org.omg.CORBA.Object objRef =
    			orb.resolve_initial_references("NameService");
    		
    		NamingContextExt ncRef = 
    			NamingContextExtHelper.narrow(objRef);
    		
    		String name = "RouteManager";
    		
    		NameComponent path[] = ncRef.to_name( name );
    		ncRef.rebind( path, mref );
    		
    		System.out.println("RouteServer ready and waiting ...");
    		
    		orb.run();
    				
    		
    	} catch( UserExeption ue ){
    		ue.printStackTrace();
    	} catch( SystemExeption e ){
    		e.printStackTrace();
    	}


    	
    	
    }
	
	
}
