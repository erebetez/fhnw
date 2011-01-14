package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import domain.Data;
import domain.Pool;

public class InputData extends JFrame implements ActionListener {    
	private Pool currentDataPool;
	
	private JButton btnOK = null;
	private JButton btnCancel = null;

	private JTextField txtA = null;
	private JTextField txtB = null;
	
	public InputData(){

		createGui();
		
		this.setVisible(true);
	}
	
	private void createGui(){
		this.setSize(230, 200);
		this.setLocation(400, 300);
		
		this.setLayout(new GridLayout(6, 2));
		
		this.add(getTxtA());
		this.add(getTxtB());
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		this.add(btnCancel);

		btnOK = new JButton("Ok");
		btnOK.addActionListener(this);
		this.add(btnOK);
	}
	
	public void setDataPool(Pool pool){
		this.currentDataPool = pool;
	}

	
	
	private JTextField getTxtA() {
		if(txtA == null) {
			txtA = new JTextField();			
		}
		return txtA;
	}

	private JTextField getTxtB() {
		if(txtB == null) {
			txtB = new JTextField();			
		}
		return txtB;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if( e.getSource().equals(btnOK) ){
        	System.out.println("button ok geklickt.");
        }
		
		
	}
	
	
	
	
}
