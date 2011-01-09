// EventDelegation.java
package gui;

import java.awt.*;
import java.awt.event.*;

public class EventDelegationDemo extends Frame {
	Button btnBGColor;

	public EventDelegationDemo(String title, ApplicationListener aListener) {
		// Top-Level-Frame festlegen
		super(title);
		this.setSize(230, 200);
		this.setLocation(400, 300);
		this.setLayout(null);
		// Button btnBGColor festlegen
		btnBGColor = new Button("Hintergrundfarbe pink");
		btnBGColor.setBounds(40, 50, 150, 23);
		btnBGColor.addMouseListener(aListener);
		this.add(btnBGColor);
		// Top-Level-Frame via Anonymer Adapter-Klasse schliessen
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}
