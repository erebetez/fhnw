package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.WindowConstants;

import domain.Mi6;

public class Mi6Gui extends JFrame implements ActionListener, Observer {

	private JLabel lblTitel = null;

	private JList lstAgents = null;

	private JButton btnKillAgent = null;

	private JButton btnNewAgent = null;

	private JButton btnEditAgent = null;

	private JButton btnRefreshList = null;

	private JLabel lblWest = null;

	private JLabel lblEast = null;

	private Mi6 mi6;
	
	public  Mi6Gui() {
		super("mi6");
		this.mi6 = Mi6.getUniqueInstance();
		this.mi6.addObserver(this);
		this.initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation( WindowConstants.DISPOSE_ON_CLOSE );
		this.setBounds(100, 100, 400, 400);
		this.add(getLblTitel(), BorderLayout.NORTH);
		this.add(getlstAgents(), BorderLayout.CENTER);
		Panel buttons = new Panel(new GridLayout(1, 4));
		buttons.add(getBtnKillAgent());
		buttons.add(getBtnNewAgent());
		buttons.add(getBtnEditAgent());
		buttons.add(getBtnRefreshList());
		this.add(buttons, BorderLayout.SOUTH);
		this.add(getLblEast(), BorderLayout.EAST);
		this.add(getLblWest(), BorderLayout.WEST);
		this.refreshList();
		this.setVisible(true);
		// this.pack();
	}

	// GET COMPONENTS
	private JLabel getLblEast() {
		if (this.lblEast == null) {
			this.lblEast = new JLabel("         ");
			this.lblEast.setOpaque(true);
			// this.lblEast.setBackground(Color.yellow);

		}
		return lblEast;
	}

	private JLabel getLblWest() {
		if (this.lblWest == null) {
			this.lblWest = new JLabel("         ");
			this.lblWest.setOpaque(true);
			// this.lblWest.setBackground(Color.yellow);

		}
		return lblWest;
	}

	private JLabel getLblTitel() {
		if (this.lblTitel == null) {
			this.lblTitel = new JLabel("Agenten beim mi6");
			// this.lblTitel.setBounds(0, 0, 780, 20);
		}
		return lblTitel;
	}

	private JList getlstAgents() {
		if (this.lstAgents == null) {
			this.lstAgents = new JList();
			this.lstAgents.setModel(new DefaultListModel());
			// this.lstAgents.setBounds(0, 0, 780, 20);
		}
		return lstAgents;
	}

	private JButton getBtnKillAgent() {
		if (this.btnKillAgent == null) {
			this.btnKillAgent = new JButton("KILL!");
			// this.btnKillAgent.setBounds(100, 200, 100, 20);
			// this.btnEnter.addActionListener(this);

			// Action Listener
			btnKillAgent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("IAM THE KILL BUTTON");
				}

			});
		}
		return btnKillAgent;
	}

	private JButton getBtnNewAgent() {
		if (this.btnNewAgent == null) {
			this.btnNewAgent = new JButton("NEW");
			// this.btnKillAgent.setBounds(100, 200, 100, 20);
			// this.btnEnter.addActionListener(this);

			// Action Listener
			btnNewAgent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AgentGui();
//					System.out.println("IAM THE NEW BUTTON");
				}

			});
		}
		return btnNewAgent;
	}

	private JButton getBtnRefreshList() {
		if (this.btnRefreshList == null) {
			this.btnRefreshList = new JButton("REFRESH");
			// this.btnKillAgent.setBounds(100, 200, 100, 20);
			// this.btnEnter.addActionListener(this);

			// Action Listener
			btnRefreshList.addActionListener(this);
		}
		return btnRefreshList;
	}

	private JButton getBtnEditAgent() {
		if (this.btnEditAgent == null) {
			this.btnEditAgent = new JButton("EDIT");
			// this.btnKillAgent.setBounds(100, 200, 100, 20);
			// this.btnEnter.addActionListener(this);

			// Action Listener
			btnEditAgent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.print("IAM THE EDIT BUTTON");
				}

			});
		}
		return btnEditAgent;
	}
	private void refreshList(){
		//	clear the gui list
		DefaultListModel listModel = (DefaultListModel)getlstAgents().getModel();
		listModel.clear();
        for (int i =0;i < mi6.count(); i++){
		    listModel.addElement(mi6.getAgent(i));
	     }	
	}
	public void actionPerformed(ActionEvent arg0) {
		refreshList();
	}

	@Override
	public void update(Observable o, Object arg) {
		refreshList();
	}
}