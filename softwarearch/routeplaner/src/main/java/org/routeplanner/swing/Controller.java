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
package org.routeplanner.swing;

import org.routeplanner.service.RouteManager;
import org.routeplanner.model.City;
import org.routeplanner.model.Link;

public class Controller {
	MainPanel mainPanel;
	RouteManager routeMgr;
	City[] cities = null;
	Link[] routes = null;
	Link[] itinerary = null;
	City from = null;
	City to = null;

	public Controller() {
	}

	public void setSelectedCity(String name) {
		mainPanel.drawRoutes(routes, itinerary, 
				routeMgr.findCity(name));
	}

	public void setMainPanel(MainPanel m) {
		this.mainPanel = m;
	}

	public void setRouteManager(RouteManager r) {
		this.routeMgr = r;
	}

	public void updateView() {
		if (from != null && to != null) {
			cities = routeMgr.findCitiesBetween(from, to);
			routes = routeMgr.findAllRoutesBetween(cities);
			itinerary = routeMgr.findShortestPath(from.name, to.name);
			mainPanel.displayCities(cities);
			mainPanel.drawRoutes(routes, itinerary, null);
		}
	}

	public void setFromCountry(String country) {
		mainPanel.setFromCities(routeMgr.findCities(country));
	}

	public void setToCountry(String country) {
		mainPanel.setToCities(routeMgr.findCities(country));
	}

	public void setFromCity(String name) {
		from=null;
		if( name!=null ){
			from = routeMgr.findCity(name);
		}
		updateView();
	}

	public void setToCity(String name) {
		to=null;
		if( name != null ){
			to = routeMgr.findCity(name);
		}
		updateView();
	}
}
