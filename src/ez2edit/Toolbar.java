package ez2edit;

import java.awt.Color;

import javax.swing.*;

public class Toolbar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton jbt = new JButton("Tool");
	public Toolbar() {
		add(jbt);
		setOpaque(true);
		setBackground(Color.RED);
	}
}
