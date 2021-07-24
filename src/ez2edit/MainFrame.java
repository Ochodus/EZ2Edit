package ez2edit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	static Toolbar toolbar = new Toolbar();
	static SqArea sqArea = new SqArea();
	static ConfigArea configArea = new ConfigArea();
	static StatBar statBar = new StatBar();
	static int x;
	static int y;
	public static Dimension frameDim = new Dimension(1080, 720);
	
	static BorderLayout mainFrameLayout = new BorderLayout();
	
	MainFrame(String name) {
		super(name);
		this.setLayout(mainFrameLayout); 
		this.add(toolbar, BorderLayout.NORTH);
		this.add(sqArea, BorderLayout.CENTER);
		this.add(configArea, BorderLayout.EAST);
		this.add(statBar, BorderLayout.SOUTH);;
		this.setPreferredSize(frameDim);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				frameDim = e.getComponent().getSize();
				System.out.println(sqArea.getSize());
			}
		});
		
		
	    
		SqArea.sqTable.setOffsets();
		
	}
	
	public void getLocations() {
		x = EZ2edit.ez2Edit.getLocation().x;
	    y = EZ2edit.ez2Edit.getLocation().y;
	}
}