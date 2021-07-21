package ez2edit;

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
	
	static GridBagLayout gbl = new GridBagLayout();
	
	public SqArea() {
		GridBagConstraints[] gbc = new GridBagConstraints[2];
		
		gbc[0] = new GridBagConstraints();
		gbc[1] = new GridBagConstraints();
		
		gbc[0].fill = GridBagConstraints.VERTICAL;
		setOpaque(true);
		setBackground(Color.BLACK);
		add(scroll, gbc[0]);
	}
}
