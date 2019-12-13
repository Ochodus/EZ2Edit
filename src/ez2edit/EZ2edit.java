package ez2edit;

import javax.swing.*;

@SuppressWarnings("serial")
public class EZ2edit extends JPanel {
	public static void main(String[] args) {
		EZ2edit editor = new EZ2edit();
		JFrame frame = new JFrame("EZ2Edit");
		frame.getContentPane().add(editor);
		frame.setBounds(200,300,400,450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
