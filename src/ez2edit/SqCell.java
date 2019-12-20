package ez2edit;

import java.awt.*;
import javax.swing.*;

public class SqCell extends JPanel {

	private static final long serialVersionUID = 1L;
	
	String type;
	Color color;
	
	int lineNumber = 0;
	boolean isGrid = false;
	boolean isSelected = false;
	
	public SqCell() {
		setBackground(Color.GREEN);
		setVisible(true);
		setSize(10, 50);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
		g.setColor(Color.RED);
		//g.drawRect(0, 0, 50, 10);
	}
}
