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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import org.routeplanner.model.City;
import org.routeplanner.model.Link;

/**
 * draw routes and cities 
 */
public class PlotArea extends JPanel {
	private static final long serialVersionUID = 1L;
	Shape shapes[];
	Set<City> cities;

	public PlotArea() {
		setBackground(Color.white);
		this.shapes = new Shape[3];
	}

	/**
	 * draw routes, mark city locations and make routes from selected city bold
	 * 
	 * @param routes
	 * @param itinerary
	 * @param selectedCity
	 */
	public void drawRoutes(Link[] routes, Link[] itinerary, City selectedCity) {
		GeneralPath routePath = new GeneralPath();
		GeneralPath selectedPath = new GeneralPath();
		GeneralPath itineraryPath = new GeneralPath();
		cities = new HashSet<City>();

		if (routes != null) {
			// draw routes
			for (Link r : routes) {
				routePath.moveTo(r.from().longitude, r.from().latitude);
				routePath.lineTo(r.to().longitude, r.to().latitude);
				cities.add(r.from());
				cities.add(r.to());
			}
			if (selectedCity != null) {
				// draw routes from selected city
				for (Link r : routes) {
					if (selectedCity.equals(r.from())
							|| selectedCity.equals(r.to())) {
						selectedPath.moveTo(r.from().longitude, 
								r.from().latitude);
						selectedPath.lineTo(r.to().longitude, 
								r.to().latitude);
					}
				}
			}
		}
		// draw itinerary
		if (itinerary != null) {
			for (Link r : itinerary) {
				itineraryPath.moveTo(r.from().longitude, r.from().latitude);
				itineraryPath.lineTo(r.to().longitude, r.to().latitude);
			}
		}

		this.shapes[0] = routePath;
		this.shapes[1] = itineraryPath;
		this.shapes[2] = selectedPath;
		repaint();
	}

	public void paintComponent(Graphics g) {
		if (shapes[0] == null) {
			return;
		}
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;

		Stroke oldStroke = g2.getStroke();
		Paint oldPaint = g2.getPaint();

		// Sets the selected Shape to the center of the Canvas.
		AffineTransform saveXform = g2.getTransform();

		Rectangle2D r = shapes[0].getBounds2D();
		
		AffineTransform transform = new AffineTransform();
		transform.translate(w / 2, h / 2);
		transform.scale(1, -1);
		transform.scale(0.9 * w / r.getWidth(), 0.9 * h / r.getHeight());
		transform.translate(-r.getCenterX(), -r.getCenterY());

		g2.setPaint(Color.blue);
		g2.draw(transform.createTransformedShape(shapes[0]));
		g2.setStroke(new BasicStroke(3.0f));
		g2.setPaint(Color.green);
		g2.draw(transform.createTransformedShape(shapes[1]));
		g2.setPaint(Color.red);
		g2.draw(transform.createTransformedShape(shapes[2]));

		g2.setPaint(Color.black);
		for (City c : cities) {
			double[] srcPts = { c.longitude, c.latitude };
			double[] dstPts = new double[2];
			transform.transform(srcPts, 0, dstPts, 0, 1);
			g2.drawString(c.name, (float) dstPts[0],
							(float) dstPts[1] - 5);
			Ellipse2D circle = new Ellipse2D.Double(dstPts[0], dstPts[1], 5., 5.);
			g2.draw(circle);
			g2.setPaint(Color.black);
			g2.fill(circle);
		}

		g2.setStroke(oldStroke);
		g2.setPaint(oldPaint);
		g2.setTransform(saveXform);

	}
}
