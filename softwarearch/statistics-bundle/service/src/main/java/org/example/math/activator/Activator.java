package org.example.math.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.example.math.service.Statistics;
import org.example.math.service.StatisticsImpl;

/**
 * This class implements a simple bundle that uses the bundle
 * context to register a statistics service
 * with the OSGi framework. 
**/
public class Activator implements BundleActivator
{
    /**
     * Implements BundleActivator.start(). Registers an
     * instance of a dictionary service using the bundle context;
     * attaches properties to the service that can be queried
     * when performing a service look-up.
     * @param context the framework context for the bundle.
    **/
    public void start(BundleContext context)
    {
        context.registerService(
            Statistics.class.getName(), new StatisticsImpl(), null);
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
