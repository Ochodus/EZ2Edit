package ez2edit;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	static Toolbar toolbar = new Toolbar();
	static SqArea sqArea = new SqArea();
	static ConfigArea configArea = new ConfigArea();
	static StatBar statBar = new StatBar();
	
	static BorderLayout bl = new BorderLayout();
	
	MainFrame(String name) {
		super(name);
		this.setLayout(bl); 
		this.add(toolbar, BorderLayout.NORTH);
		this.add(sqArea, BorderLayout.CENTER);
		this.add(configArea, BorderLayout.EAST);
		this.add(statBar, BorderLayout.SOUTH);
		Dimension dim = new Dimension(1080,720);
		this.setLocation(0, 0);
		this.setPreferredSize(dim);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}