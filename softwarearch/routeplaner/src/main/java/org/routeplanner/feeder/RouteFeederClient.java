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

import java.io.IOException;

import org.routeplanner.service.RouteManager;
import org.routeplanner.service.impl.RouteManagerImpl;

public class RouteFeederClient {

	/**
	 * utility application to load cities and links
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

			RouteManager routeMgr = new RouteManagerImpl();
			
			RouteFeeder feeder = new RouteFeeder( routeMgr );
			System.out.println("Loading cities and routes..");
			System.out.println( "total cities :" + feeder.loadCities("/cities.txt") );
			System.out.println( "total routes :" + feeder.loadCities("/routes.txt") );

	}

}
