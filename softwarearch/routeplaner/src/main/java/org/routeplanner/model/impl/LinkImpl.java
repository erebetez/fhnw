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
package org.routeplanner.model.impl;

import org.routeplanner.model.City;
import org.routeplanner.model.Link;

/**
 * represents a connection between 2 city objects
 */
public class LinkImpl implements LinkPOA{
	private City from;
	private City to;
	private Double weight;
	
	public LinkImpl( City from, City to, Double d ){
		this.from=from;
		this.to=to;
		this.weight=(d!=null)?d:getDirectDistance();
	}

	// calculate the distance between 2 cities
	/* (non-Javadoc)
	 * @see org.routeplanner.model.Link#getDirectDistance()
	 */
	@Override
	public double getDirectDistance(){
		if( from.latitude == to.latitude &&
				from.longitude == to.longitude )
			return 0;
		// convert coordinates into radian
		double k = Math.PI/180;
		double a = from.latitude*k;
		double b = from.longitude*k;
		double c = to.latitude*k;
		double d = to.longitude*k;
		
		double x = Math.sin(a)*Math.sin(c)+
			Math.cos(a)*Math.cos(c)*Math.cos(b-d);
		double radius = 6371.007176; // in km
		if (x > 1) 
			return radius*Math.acos(1.);
		
		return radius*Math.acos(x);
	}

	public City from() {
		return from;
	}
	public City to() {
		return to;
	}
	/* (non-Javadoc)
	 * @see org.routeplanner.model.Link#weight()
	 */
	@Override
	public double weight() {
		return weight;
	}
	
	/**
	 * check if this link is included in array of cities
	 * @param cities
	 * @return true if both ends of this link are contained in array of cities
	 */
	public boolean isIncludedIn(City[] cities) {
		boolean from = false;
		boolean to=false;
		
		for( City c: cities){
			if( !from )
				from = c.id == from().id;
			if( !to )
				to = c.id == to().id;
			if( from && to )
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkImpl other = (LinkImpl) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
}
