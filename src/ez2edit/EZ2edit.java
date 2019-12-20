package ez2edit;

import java.awt.*;
import javax.swing.*;

public class EZ2edit {
	
	static JFrame ez2Edit = new JFrame("EZ2Edit");
	static Toolbar toolbar = new Toolbar();
	static SqArea sqArea = new SqArea();
	static ConfigArea configArea = new ConfigArea();
	static StatBar statBar = new StatBar();
	
	static BorderLayout fl = new BorderLayout();
	
	public EZ2edit() {
		
	}
	
	public static void main(String[] args) {
		ez2Edit.setLayout(fl);
		ez2Edit.add(toolbar, BorderLayout.NORTH);
		ez2Edit.add(sqArea, BorderLayout.WEST);
		ez2Edit.add(configArea, BorderLayout.EAST);
		ez2Edit.add(statBar, BorderLayout.SOUTH);
		Dimension dim = new Dimension(1080,720);
		ez2Edit.setLocation(0, 0);
		ez2Edit.setPreferredSize(dim);
		ez2Edit.pack();
		ez2Edit.setVisible(true);
		ez2Edit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
