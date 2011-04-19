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

import org.junit.Assert;
import org.junit.Test;
import org.routeplanner.model.impl.LinkImpl;

public class LinkTest {
	@Test
	public void calcDistance(){
		City from = new City();
		from.latitude = 47.35;
		from.longitude= 8.517;
		City to = new City();
		to.latitude = 46.917;
		to.longitude = 7.467;
		Link link = new LinkImpl( from, to, null );
		Assert.assertEquals(93, link.getDirectDistance(), 1);

	}
}
