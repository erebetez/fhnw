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

import javax.swing.table.*;

import org.routeplanner.model.City;

public class CitiesTableAdapter extends AbstractTableModel implements
		TableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String columnNames[] = { "Name", "Country", "Latitude",
			"Longitude" };
	City cities[] = null;

	public CitiesTableAdapter(City c[]) {
		cities = c;
	}

	public String getColumnName(int i) {
		return columnNames[i];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return cities.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class getColumnClass(int column) {
		Class dataType = super.getColumnClass(column);
		if (column == 2 || column == 3)
			return Double.class;
		return dataType;
	}

	public Object getValueAt(int r, int c) {
		switch (c) {
		case 0:
			return cities[r].name;
		case 1:
			return cities[r].country;
		case 2:
			return cities[r].latitude;
		case 3:
			return cities[r].longitude;
		default:
			return "?";
		}
	}
}