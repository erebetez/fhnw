/*
 * Copyright (C) 2011 Ronald Tanner, CH-4123 Allschwil
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.routeplanner.feeder;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.routeplanner.dao.RouteDao;
import org.routeplanner.feeder.RouteFeeder;
import org.routeplanner.model.City;
import org.routeplanner.model.Link;
import org.routeplanner.service.RouteManager;
import org.routeplanner.service.impl.RouteManagerImpl;

public class RouteFeederTest {
	RouteManager routeMgr;
	@Before
	public void setUp() throws FileNotFoundException, IOException{
        RouteDao routeDao = new RouteDao();
		routeMgr = new RouteManagerImpl();
        routeMgr.setRouteDao( routeDao );
		RouteFeeder feeder = new RouteFeeder( routeMgr );
		feeder.loadCities("/cities.txt");
		feeder.loadRoutes("/routes.txt");
	}
	@Test
	public void findCity(){
		City to = routeMgr.findCity("Berlin");
		Assert.assertNotNull( to );
		Assert.assertEquals("Berlin", to.name);
	}
	@Test
	public void findCitiesAndRoutes(){
		City lyon = routeMgr.findCity("Lyon");
		City berlin = routeMgr.findCity("Berlin");
		City cities[] = routeMgr.findCitiesBetween(lyon, berlin);
 		Assert.assertEquals(183, cities.length);		
		Link routes[] = routeMgr.findAllRoutesBetween(cities);
		Assert.assertEquals(72, routes.length);
	}
	@Test
	public void findShortestPath() throws FileNotFoundException, IOException {
		Link[] itinerary = routeMgr.findShortestPath( "Lyon", "Berlin" );
		Assert.assertNotNull( itinerary );
		
		double dist = 0;
		String [] itCities = {"Lyon", "Genève", "Lausanne","Fribourg","Bern","Biel", "Delémont", "Basel", "Freiburg", "Karlsruhe", "Mannheim", "Frankfurt","Hannover","Berlin"};
		Assert.assertEquals( itCities.length-1, itinerary.length);
		int i=0;
		for (Link r : itinerary) {
			dist += r.weight();
			//System.out.println( r.getTo() + "    " + r.getDirectDistance() + "  " + dist);
			Assert.assertEquals(itCities[i],r.from().name);
			i++;
		}
		Assert.assertEquals(1131.63, dist, 0.1);
	}
}
