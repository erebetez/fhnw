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
package org.routeplanner.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.routeplanner.model.City;
import org.routeplanner.model.Link;

/*
 * provides access to cities and their links between.
 */
public class RouteDao {
	private List<City> cities = new ArrayList<City>();
	private List<Link> routes = new ArrayList<Link>();

	public RouteDao() {
	}

	public void saveLink(Link link) {
		routes.add(link);
	}

	/**
	 * save or modify city
	 * @param city
	 */
	public void saveCity(City city) {
		if( city.id<0 || city.id>=cities.size() ){
			city.id=cities.size();
			cities.add(city);
		}
		else {
			cities.set(city.id, city );
		}
	}

	/**
	 * find city
	 * @param name
	 * @return city
	 */
	public City findCity(String name) {
		if( name == null )
			return null;
		String n = name.trim().toLowerCase();
		for (City city : cities) {
			if (city.name.toLowerCase().equals(n))
				return city;
		}
		return null;
	}
	/**
	 * find cities of country
	 * @param country
	 * @return cities of country
	 */
	public City[] findCities( String country ){
		List<City> selectedCities = new ArrayList<City>();
		for ( City c: cities ){
			if( c.country.equals(country)){
				selectedCities.add( c );
			}
		}
		return selectedCities.toArray(new City[selectedCities.size()]);
	}

	/**
	 * find cities between from and to
	 * @param from
	 * @param to
	 * @return cities between from and to
	 */
	public City[] findCities(City from, City to) {
		List<City> selectedCities = new ArrayList<City>();
		if( from == null || to == null )
			return new City[0];

		selectedCities.add(from);

		double minLat = min(from.latitude, to.latitude);
		double maxLat = max(from.latitude, to.latitude);
		double minLon = min(from.longitude,to.longitude);
		double maxLon = max(from.longitude, to.longitude);
		for (City c : cities) {
			if (c.latitude > minLat && c.latitude < maxLat
					&& c.longitude > minLon && c.longitude < maxLon)
				selectedCities.add(c);
		}
		selectedCities.add(to);
		return selectedCities.toArray(new City[selectedCities.size()]);
	}

	private double min(Double a, Double b) {
		if( a<b ) return a;
		return b;
	}
	private double max(Double a, Double b) {
		if( a>b ) return a;
		return b;
	}

	/**
	 * find routes between cities
	 * @param cities
	 * @return routes between cities
	 */
	public Link[] findRoutes(City[] cities) {
		List<Link> selectedRoutes = new ArrayList<Link>();
		List<City> cityList = new ArrayList<City>();
		for( int i=0; i<cities.length; i++){
			cityList.add( cities[i] );
		}
		for (Link r : routes) {
			if (r.isIncludedIn(cities)) {
				selectedRoutes.add(r);
			}
		}

		return selectedRoutes.toArray(new Link[selectedRoutes.size()]);
	}
	/**
	 * find countries
	 * @return
	 */
	public String[] findCountries(){
		List<String> countries = new ArrayList<String>();
		for( City c: cities){
			if( !countries.contains(c.country) )
			countries.add( c.country );
		}
		Collections.sort(countries);
		return countries.toArray(new String[countries.size()]);
	}

}
