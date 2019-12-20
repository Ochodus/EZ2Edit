package ez2edit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class SqArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	SqTable sqTable = new SqTable();
	JScrollPane scroll = new JScrollPane(sqTable);
	
	public SqArea() {
		scroll.setPreferredSize(new Dimension(1000,600));
		setOpaque(true);
		setBackground(Color.BLACK);
		add(scroll);
	}
}
