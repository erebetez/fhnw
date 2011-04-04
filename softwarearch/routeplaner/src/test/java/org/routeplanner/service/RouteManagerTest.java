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
package org.routeplanner.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.routeplanner.dao.RouteDao;
import org.routeplanner.model.City;
import org.routeplanner.model.Link;
import org.routeplanner.service.impl.RouteManagerImpl;

public class RouteManagerTest {
	RouteManager routeMgr;
	
	@Before
	public void setUp() {
        RouteDao routeDao = new RouteDao();
		routeMgr = new RouteManagerImpl();
        routeMgr.setRouteDao( routeDao );
        City cities[] = new City[5];
        cities[0]=routeMgr.createCity("Berlin", 52.52, 13.38, "Germany");
        cities[1]=routeMgr.createCity("Montreal", 45.52, -73.57, "Canada");
        cities[2]=routeMgr.createCity("Basel", 47.57, 7.58, "Switzerland");        
        cities[3]=routeMgr.createCity("Salzburg", 47.81, 13.04, "Austria");        
        cities[4]=routeMgr.createCity("Lyon", 45.76, 4.83, "France");
        
        routeMgr.createLink(cities[0], cities[2]);
        routeMgr.createLink(cities[0], cities[3]);
        routeMgr.createLink(cities[4], cities[2]);
        routeMgr.createLink(cities[4], cities[3]);
        routeMgr.createLink(cities[4], cities[1]);
        routeMgr.createLink(cities[1], cities[0]);
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
 		Assert.assertEquals(4, cities.length);		
		Link routes[] = routeMgr.findAllRoutesBetween(cities);
		Assert.assertEquals(4, routes.length);
	}
	@Test
	public void findShortestPath() {
		Link[] itinerary = routeMgr.findShortestPath( "Lyon", "Berlin" );
		Assert.assertNotNull( itinerary );
		
		double dist = 0;
		String [] itCities = {"Lyon", "Basel","Berlin"};
		Assert.assertEquals( itCities.length-1, itinerary.length);
		int i=0;
		for (Link r : itinerary) {
			dist += r.weight();
			Assert.assertEquals(itCities[i],r.from().name);
			i++;
		}
		Assert.assertEquals(979, dist, 0.1);
	}
}
