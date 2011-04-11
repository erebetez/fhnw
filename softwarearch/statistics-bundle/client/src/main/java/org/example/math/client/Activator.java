package org.example.math.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import org.example.math.service.Statistics;

/**
 * This class implements a simple bundle that uses the bundle
 * context to bind a statistics service
 * within the OSGi framework. 
**/
public class Activator implements BundleActivator
{
    /**
     * Implements BundleActivator.start(). 
     * @param context the framework context for the bundle.
    **/
    public void start ( BundleContext context ) {
	ServiceReference ref = 
	    context.getServiceReference( Statistics.class.getName( ) );
	if( ref != null ){
	    Statistics stat = ( Statistics ) context.getService( ref );
	    if ( stat != null ) {
		stat.addNumber( 1.0 );
		stat.addNumber( 2.0 );
		System.out.println ( "Average " + stat.getAverage() ) ;
	    } 
	    context.ungetService( ref );
	}
    }
    /**
     * Implements BundleActivator.stop(). Does nothing since
     * the framework will automatically unregister any registered services.
     * @param context the framework context for the bundle.
    **/
    public void stop(BundleContext context)
    {
        // NOTE: The service is automatically unregistered.
    }

}
