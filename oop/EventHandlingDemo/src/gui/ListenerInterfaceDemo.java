// ListenerInterfaceDemo.java  
package gui;

import java.awt.*;
import java.awt.event.*;

public class ListenerInterfaceDemo extends Frame 
								   implements MouseListener {

	Button btnBGColor;

	public ListenerInterfaceDemo(String title) {
		// Top-Level-Frame festlegen
		super(title);
		this.setSize(230, 200);
		this.setLocation(400, 300);
		this.setLayout(null);
		// Button btnBGColor festlegen
		btnBGColor = new Button("Hintergrundfarbe pink");
		btnBGColor.setBounds(40, 50, 150, 23);
		btnBGColor.addMouseListener(this);
		this.add(btnBGColor);
		// Top-Level-Frame via Anonymer Adapter-Klasse schliessen
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}

	// MouseListener-Inerface implementieren

	public void mouseClicked(MouseEvent me) {
		me.getComponent().getParent().setBackground(Color.magenta);
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
		me.getComponent().setBackground(Color.cyan);
	}

	public void mouseExited(MouseEvent me) {
		me.getComponent().setBackground(Color.lightGray);
		btnBGColor.setLabel("Hintergrundfarbe pink");
		me.getComponent().getParent().setBackground(Color.white);
	}

	public void mousePressed(MouseEvent me) {
	}

	public static void main(String[] args) {
		new ListenerInterfaceDemo("ListenerInterface");
	}
	
}
