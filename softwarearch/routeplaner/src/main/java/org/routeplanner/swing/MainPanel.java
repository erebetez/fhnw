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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.routeplanner.model.City;
import org.routeplanner.model.Link;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel fromLabel = new JLabel("From:");
	JLabel toLabel = new JLabel("To:");
	JComboBox fromCity = null;
	JComboBox toCity = null;
	JTable citiesTable = new JTable();
	PlotArea plotArea = new PlotArea();
	JComboBox fromCountry = null;
	JComboBox toCountry = null;

	Controller controller;

	public MainPanel(String[] countries) {
		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				this);
		setLayout(mainPanelLayout);
		fromCity = new JComboBox();
		fromCity.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String name = (String)cb.getSelectedItem();
		        controller.setFromCity(name);
			}
		});
		toCity = new JComboBox();
		toCity.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String name = (String)cb.getSelectedItem();
		        controller.setToCity(name);
			}
		});

		fromCountry = new JComboBox( countries );
		fromCountry.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String name = (String)cb.getSelectedItem();
		        controller.setFromCountry(name);
			}
		});
		toCountry = new JComboBox( countries );
		toCountry.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		        JComboBox cb = (JComboBox)e.getSource();
		        String name = (String)cb.getSelectedItem();
		        controller.setToCountry(name);
			}
		});
		
		citiesTable.setModel(new CitiesTableAdapter(new City[0]));
		citiesTable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						for (int c : citiesTable.getSelectedRows()) {
							controller.setSelectedCity( (String)citiesTable.getModel().getValueAt(c, 0) );
						}
					}
				});

		drawRoutes(new Link[0], null, null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(citiesTable);

		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																plotArea,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																559,
																Short.MAX_VALUE)
														.addComponent(
																scrollPane,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																559,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																mainPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								fromCity,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								fromLabel)
																						.addComponent(
																								fromCountry))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								toCity,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								toLabel)
																						.addComponent(
																								toCountry)))))
										.addContainerGap()));

		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(fromLabel)
														.addComponent(toLabel))
										.addContainerGap()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(fromCountry)
														.addComponent(toCountry))
										.addContainerGap()
										.addGap(5, 5, 5)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																fromCity,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																toCity,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												scrollPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												131,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(2, 2, 2)
										.addComponent(
												plotArea,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												300, Short.MAX_VALUE)));
	}

	public void setController(Controller c) {
		this.controller = c;
	}

	public void drawRoutes( Link[] routes, Link[] itinerary, City selectedCity ) {
		plotArea.drawRoutes( routes, itinerary, selectedCity );
	}
	public void displayCities( City [] cities ){
		citiesTable.setModel(new CitiesTableAdapter(cities));
	}

	public void setFromCities(City[] cities) {
		DefaultComboBoxModel d = (DefaultComboBoxModel)fromCity.getModel();
		d.removeAllElements();
		for( City c: cities ){
			d.addElement(c.name);
		}		
	}

	public void setToCities(City[] cities) {
		DefaultComboBoxModel d = (DefaultComboBoxModel)toCity.getModel();
		d.removeAllElements();
		for( City c: cities ){
			d.addElement(c.name);
		}
	}

	public void setToCountry(int index) {
		toCountry.setSelectedIndex(index);
		toCity.setSelectedIndex(0);
	}
	public void setFromCountry(int index) {
		fromCountry.setSelectedIndex(index);
		fromCity.setSelectedIndex(0);
	}
}