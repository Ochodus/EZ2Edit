package ez2edit;

import java.awt.*;
import javax.swing.*;

public class EZ2edit {
	
	public static void main(String[] args) {
		SequenceTable sqTable = new SequenceTable();
		Dimension dim = new Dimension(1080,720);
		JFrame frame = new JFrame("EZ2Edit");
		frame.setLocation(0, 0);
		frame.setPreferredSize(dim);
		
		frame.add(sqTable.jScrollPane);
		frame.pack();
		frame.setVisible(true);
	}
}
