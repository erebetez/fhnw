package test;

import gui.AgentGui;

import javax.swing.JFrame;

import domain.Mi6;

public class GuiTester {

	public static void main(String[] args) {
//		tutorial();
		
		AgentTestGui();
		
		
	}

	public static void AgentTestGui(){
		new AgentGui();
	}
	
	
	
	public static void tutorial(){
		//1. Create the frame.
		JFrame frame = new JFrame("FrameDemo");

		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//3. Create components and put them in the frame.
		//...create emptyLabel...
//		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		frame.setBounds(200, 300, 300, 400);
		
		//4. Size the frame.
		frame.pack();

		//5. Show it.
		frame.setVisible(true);
	}
	

}
