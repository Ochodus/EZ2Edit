package ez2edit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SqArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	SqTable sqTable = new SqTable();
	JScrollPane scroll = new JScrollPane(sqTable);
	
	static BorderLayout bl = new BorderLayout();
	
	public SqArea() {
		this.setLayout(bl);
		
		setOpaque(true);
		setBackground(Color.BLACK);
		add(scroll);
	}
}
