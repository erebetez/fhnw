package gui;

import java.awt.GridLayout;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import domain.*;

public class AgentGui extends JFrame implements ActionListener {
	private JTextField txtName;
	private JTextField txtFirstname;
	private JTextField txtAge;
	private JTextField txtCodename;
	private JCheckBox chkLicenceToKill;
	private JButton btnOK;
	private JButton btnCancel;
	
	private Mi6 secretService;

	public AgentGui(Mi6 secretService) {
		super("agent user Interface"); // Super muss erste anweisung im
										// konstruktor sein.
		this.setBounds(100, 100, 200, 200);
		this.setLayout(new GridLayout(6, 2));
		initGui();

		this.secretService = secretService;
		
		this.setVisible(true);
	}
	

	private void initGui() {

		this.add(new Label("Name"));
		txtName = new JTextField();
		this.add(txtName);

		Label lblName = new Label("VorName");
		this.add(lblName);
		txtFirstname = new JTextField();
		this.add(txtFirstname);

		this.add(new Label("Codename"));
		txtCodename = new JTextField();
		this.add(txtCodename);

		this.add(new Label("Alter"));
		txtAge = new JTextField();
		this.add(txtAge);

		this.add(new Label("Lizenz zum töten"));
		chkLicenceToKill = new JCheckBox();
		this.add(chkLicenceToKill);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		this.add(btnCancel);

		btnOK = new JButton("Ok");
		btnOK.addActionListener(this);
		this.add(btnOK);

		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(e.getSource());
		if( e.getSource().equals(btnOK) ){
			newAgent();
		}
		
		if( e.getSource().equals(btnCancel) ){			
			
			System.out.println("Event cancel ausgelöst");
		}

	}
	
	public void newAgent(){
		if( secretService.addAgent(new Agent(
				txtName.getText(),
				txtFirstname.getText(),
				txtCodename.getText(),
				Integer.decode( txtAge.getText() ),
				chkLicenceToKill.isSelected()				
		)) ){
			System.out.println("Agent hinzugefügt.");			
		}
			
	}
	
	
	

}
