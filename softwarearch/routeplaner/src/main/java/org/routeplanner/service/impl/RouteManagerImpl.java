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
package org.routeplanner.service.impl;

import java.util.*;

import org.routeplanner.dao.RouteDao;
import org.routeplanner.model.*;
import org.routeplanner.model.impl.LinkImpl;
import org.routeplanner.service.RouteManager;


public class RouteManagerImpl implements RouteManager {
	private RouteDao routeDao;
	private City[] cities;
	private Link[] routes;

	public RouteManagerImpl() {
	}

	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#setRouteDao(org.routeplanner.dao.RouteDao)
	 */
	public void setRouteDao(RouteDao r) {
		this.routeDao = r;
	}

	/* 
	 * @see org.routeplanner.service.RouteManager#findCitiesBetween(java.lang.String, java.lang.String)
	 */
	private City[] findCitiesBetween(String fromName, String toName) {
		City from = routeDao.findCity(fromName);
		City to = routeDao.findCity(toName);
		return findCitiesBetween( from, to );
	}

	private List<City> findNeighbors(City c) {
		List<City> neighbors = new ArrayList<City>();
		for (Link r : routes) {
			if (c.equals(r.from())) {
				neighbors.add(r.to());
			} else if (c.equals(r.to())) {
				neighbors.add(r.from());
			}
		}
		return neighbors;
	}
	
	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#findAllRoutesBetween(org.routeplanner.model.City[])
	 */
	@Override
	public Link[] findAllRoutesBetween(City[] cities) {
		return routeDao.findRoutes(cities);
	}

	private double getDist(City c1, City c2) {
		for (Link r : routes) {
			if ((c1.equals(r.from()) && c2.equals(r.to()))
					|| (c2.equals(r.from()) && c1.equals(r.to()))) {
				return r.weight();
			}
		}
		return Double.MAX_VALUE;
	}


	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#findShortestPath(java.lang.String, java.lang.String)
	 */
	@Override
	public Link [] findShortestPath(String fromName, String toName) {
		cities = findCitiesBetween(fromName, toName);
		if( cities == null || cities.length<1)
			return new Link[0];
		routes = findAllRoutesBetween( cities );
		if( routes == null || routes.length<1)
			return new Link[0];

		City source = cities[0];
		City target = cities[cities.length-1];
		List<City> Q = new ArrayList<City>();
		Map<City, Double> dist = new HashMap<City, Double>();
		Map<City, City> previous = new HashMap<City, City>();
		for (City v : cities) {
			dist.put(v, Double.MAX_VALUE);
			previous.put(v, null);
			Q.add(v);
		}
		dist.put(source, 0.);
		while (!Q.isEmpty()) {
			City u = null;
			int i = 0;
			int iu = 0;
			double minDist = Double.MAX_VALUE;
			// find city u with smallest dist
			for (City c : Q) {
				if (dist.get(c) < minDist) {
					iu = i;
					u = c;
					minDist = dist.get(c);
				}
				i++;
			}
			if (u != null) {
				Q.remove(iu);
				for (City n : findNeighbors(u)) {
					double alt = dist.get(u) + getDist(u, n);
					if (!dist.containsKey(n) || alt < dist.get(n)) {
						dist.put(n, alt);
						previous.put(n, u);
					}
				}
			} else {
				break;
			}

		}
		LinkedList<City> cities = new LinkedList<City>();
		City u = target;
		while (previous.get(u) != null) {
			cities.addFirst(u);
			u = previous.get(u);
		}
		cities.addFirst(source);
		City from=null;
		City to=null;
		List<Link> itinerary = new ArrayList<Link>();
		for( City c: cities ){
			from=to;
			to=c;
			if( from!=null ){
				itinerary.add( findRoute( from, to ));
			}
		}
		return itinerary.toArray(new Link[ itinerary.size()]);
	}

	/**
	 * find link between 2 cities
	 * @param from
	 * @param to
	 * @return route (null if none found)
	 */
	private Link findRoute(City from, City to) {
		for( Link r: routes ){
			if( (from.equals(r.from()) && to.equals(r.to()))||
					(to.equals(r.from()) && from.equals(r.to()))){
				return createLink( from, to, r.weight() ); 
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#findCity(java.lang.String)
	 */
	@Override
	public City findCity(String name) {
		return routeDao.findCity(name);
	}
	
	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#findCitiesBetween(org.routeplanner.model.City, org.routeplanner.model.City)
	 */
	@Override
	public City[] findCitiesBetween(City from, City to) {
		this.cities = routeDao.findCities(from, to);
		return this.cities;
	}

	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#findCities(java.lang.String)
	 */
	@Override
	public City[] findCities(String country) {
		return routeDao.findCities(country);
	}

	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#findCountries()
	 */
	@Override
	public String[] findCountries() {
		return routeDao.findCountries();
	}

	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#createLink(org.routeplanner.model.City, org.routeplanner.model.City)
	 */
	@Override
	public Link createLink(City cityFrom, City cityTo) {
		Link link = createLink( cityFrom, cityTo, null );
		routeDao.saveLink( link );
		return link;
	}

	public Link createLink(City cityFrom, City cityTo, Double weight) {
		return new LinkImpl( cityFrom, cityTo, weight );
	}

	/* (non-Javadoc)
	 * @see org.routeplanner.service.RouteManager#createCity(java.lang.String, double, double, java.lang.String)
	 */
	@Override
	public City createCity(String cityName, double cityLat, double cityLon,
			String country) {
		City city = new City();
		city.id=-1;
		city.country = country;
		city.name=cityName;
		city.latitude=cityLat;
		city.longitude=cityLon;
		routeDao.saveCity(city);
		return city;
	}
	
	
}
