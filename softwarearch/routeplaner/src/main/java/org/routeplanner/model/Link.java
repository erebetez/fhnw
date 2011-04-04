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
package org.routeplanner.model;

/**
 * represents a connection between 2 cities
 * @author tar
 *
 */
public interface Link {

	/**
	 * calculate the distance of this link
	 * @return distance between the 2 cities of this link
	 */
	public abstract double getDirectDistance();

	/**
	 * get city at start of link
	 * @return city
	 */
	public abstract City from();

	/**
	 * get city at end of link
	 * @return city
	 */
	public abstract City to();

	/**
	 * get weight of this link
	 * @return weight
	 */
	public abstract double weight();

	/**
	 * check if both ends of this link are included in the array of cities
	 * @param cities
	 * @return true if this link is included in cities
	 */
	public abstract boolean isIncludedIn( City [] cities);
}