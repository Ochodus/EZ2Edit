package ez2edit;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SqArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static SqTable sqTable = new SqTable();
	private static JScrollPane scroll = new JScrollPane(sqTable);
	
	static BorderLayout sqAreaLayout = new BorderLayout();
	
	public SqArea() {
		this.setVisible(true);
		this.setLayout(sqAreaLayout);

		this.setBackground(Color.BLACK);
		this.add(scroll);
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListener);
		this.addMouseListener(new MouseActionListener().mouseEventListener);

		sqTable.addColumns();
	}
}
