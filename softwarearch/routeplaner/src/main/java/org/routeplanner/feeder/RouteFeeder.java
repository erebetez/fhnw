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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.routeplanner.model.City;
import org.routeplanner.service.RouteManager;

/**
 * provides services to load cities and links (routes)
 * into the routeplanner repository from text files with
 * tab separated records
 * 
 * @author Ronald Tanner
 *
 */
public class RouteFeeder {
	private RouteManager routeMgr;
	
	public RouteFeeder( RouteManager routeMgr ){
		this.routeMgr = routeMgr;
	}
	/**
	 * load cities from file
	 * @param filename
	 * @return count of loaded records
	 * @throws IOException
	 */
	public int loadCities( String filename ) throws IOException{
		return loadCities(new BufferedReader( new InputStreamReader(
				getClass().getResourceAsStream( filename ) ) ) );		
	}
	/**
	 * load routes (links between 2 cities) from file
	 * @param filename
	 * @return count of loaded records
	 * @throws IOException
	 */
	public int loadRoutes( String filename ) throws IOException{
		return loadRoutes(new BufferedReader( new InputStreamReader (
				getClass().getResourceAsStream(filename) ) ));
	}
	
	private int loadRoutes(BufferedReader br) throws IOException {
		int linkcount=0;
		String line;
		while ((line = br.readLine()) != null) {
			String [] recs = line.split("\t");
			if( recs.length==2){
				City from = routeMgr.findCity(recs[0]);
				City to = routeMgr.findCity(recs[1]);
				if (from != null && to != null) {
					routeMgr.createLink(from, to);
					linkcount++;
				}
			}
		}
		return linkcount;
	}

	private int loadCities(BufferedReader br) throws IOException {
		int citycount = 0;
		String line;
		while ((line = br.readLine()) != null) {
			String[] recs=line.split("\t");
			if( recs.length==5 ){
				String name = recs[0];
				String country = recs[1];
				Integer population = new Integer(recs[2]);
				double lat = new Double(recs[3]);
				double lon = new Double( recs[4] );
				routeMgr.createCity(name.trim(), lat, lon, country.trim());
				citycount ++;
			}
		}
		return citycount;
	}

}
