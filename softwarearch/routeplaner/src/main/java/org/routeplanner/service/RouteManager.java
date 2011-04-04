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

import org.routeplanner.dao.RouteDao;
import org.routeplanner.model.City;
import org.routeplanner.model.Link;

/**
 * 
 * @author Ronald Tanner
 *
 */
public interface RouteManager {
	/** 
	 * find all links completely included within an array of cities
	 * @param cities
	 * @return routes
	 */
	Link[] findAllRoutesBetween(City[] cities);
	
	/**
	 * find shortest path between source to target city
	 * {@link http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm}
	 * 
	 * @return itinerary
	 */
	Link[] findShortestPath(String fromName, String toName);

	/**
	 * find city by name
	 * @param name
	 * @return
	 */
	City findCity(String name);

	/**
	 * find all cities that are geographically within the given rectangle
	 * that is defined by the diagonal of 2 cities
	 * @param from city
	 * @param to city
	 * @return array of cities between from city and to city
	 */
	City[] findCitiesBetween(City from, City to);

	/**
	 * find all cities of a country
	 * @param country
	 * @return array of cities that are part of the given country
	 */
	City[] findCities(String country);

	/**
	 * find all countries
	 * @return array of names of all included country 
	 */
	String[] findCountries();

	/**
	 * create a link between 2 cities
	 * @param cityFrom
	 * @param cityTo
	 * @return created link
	 */
	Link createLink(City cityFrom, City cityTo);

	/**
	 * create a new city
	 * @param cityName
	 * @param cityLat
	 * @param cityLon
	 * @param country
	 * @return created city
	 */
	City createCity(String cityName, double cityLat, double cityLon,
			String country);

	
	/** 
	 * inject the dao object
	 * @param routeDao
	 */
	void setRouteDao(RouteDao routeDao);
}
