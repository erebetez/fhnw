// ApplicationListener.java
package gui;

import java.awt.*;
import java.awt.event.*;

public class ApplicationListener implements MouseListener {
	// MouseListener-Inerface implementieren
	public void mouseClicked(MouseEvent me) {
		me.getComponent().getParent().setBackground(Color.magenta);
	}

	public void mouseEntered(MouseEvent me) {
		me.getComponent().setBackground(Color.cyan);
	}

	public void mouseExited(MouseEvent me) {
		me.getComponent().setBackground(Color.lightGray);
		((Button) me.getComponent()).setLabel("Hintergrundfarbe pink");
		me.getComponent().getParent().setBackground(Color.white);
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
	}
}
