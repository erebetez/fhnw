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

import java.io.IOException;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.routeplanner.dao.RouteDao;
import org.routeplanner.feeder.RouteFeeder;
import org.routeplanner.service.RouteManager;
import org.routeplanner.service.impl.RouteManagerImpl;

/**
 * creates and manages the user interface of the routeplanner application
 * 
 * @author Ronald Tanner
 *
 */
public class App implements Runnable {
	// routeDao = null;
	private RouteManager routeMgr = null;
	private Controller controller = new Controller();
    private ResourceBundle rb;

	public App() throws IOException {
		rb = ResourceBundle.getBundle("application");

		RouteDao routeDao = new RouteDao();
		routeMgr = new RouteManagerImpl();
		routeMgr.setRouteDao(routeDao);
		
		RouteFeeder feeder = new RouteFeeder( routeMgr );
		feeder.loadCities(rb.getString("application.cities"));
		feeder.loadRoutes(rb.getString("application.routes") );
	}

	public static void main(String[] args) throws IOException {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new App());
	}

	public void run() {
		try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
	} catch (Exception e) {
	    // If laf is not available, you can set the GUI to another look and feel.
	}
	     
		String[] countries = routeMgr.findCountries();

		MainPanel mp = new MainPanel( countries );
		
		mp.setController(controller);
		controller.setMainPanel(mp);
		controller.setRouteManager(routeMgr);

		mp.setFromCountry(find(countries, "France"));
		mp.setToCountry(find(countries, "Germany"));
		
		JFrame display = new JFrame(rb.getString("application.name") +
					" (Version "+rb.getString("application.version")+")");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.getContentPane().add(mp);
		display.pack();
		display.setVisible(true);
	}

	private int find(String [] countries, String name) {
		int i=0;
		for( String c: countries){
			if( c.equals(name)){
				return i;
			}
			i++;
		}
		return 0;
	}
}
