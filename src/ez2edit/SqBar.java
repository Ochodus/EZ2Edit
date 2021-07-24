package ez2edit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SqBar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static final Dimension barDim = new Dimension(Config.curColumnWidth, Config.curBarHeight);
	
	public String type;
	public SqColumn line;
	private static Note hoverNote;
	
	int lineNumber = 0;
	int barNumber;
	boolean isGrid = false;
	boolean isSelected = false;
	
	SqBar nextBar = null;
	SqBar prevBar = null;
	
	public SqBar(int initBeat, int initModer, int type, int mod, boolean is2P, int barNumber, SqColumn line) {
		
		this.barNumber = barNumber;
		this.line = line;
		
		this.setVisible(true);
		this.setPreferredSize(barDim);
		this.setBackground(Color.black);
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 2, 0, Color.LIGHT_GRAY));
		this.setLayout(null);
		
		switch (type) {
			case 0:
				setBackground(Color.YELLOW);
				this.type = SqTable.lineInfo[type][mod];
				break;
			case 1:
				if (mod%2 == 0) {setBackground(Color.DARK_GRAY);}
				else {setBackground(Color.BLUE);}
				if (is2P) {this.type = SqTable.lineInfo[type][mod+5];}
				else {this.type = SqTable.lineInfo[type][mod];}
				break;
			case 2:
				setBackground(Color.PINK);
				if (is2P) {this.type = SqTable.lineInfo[type][mod+1];}
				else {this.type = SqTable.lineInfo[type][mod];}
				break;
			case 3:
				setBackground(Color.GREEN);
				this.type = SqTable.lineInfo[type][mod];
				break;
			case 4:
				setBackground(Color.RED);
				this.type = SqTable.lineInfo[type][mod];
				break;
			case 5:
				setBackground(Color.RED);
				this.type = SqTable.lineInfo[type][mod];
				break;
		}
		
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListener);
		this.addMouseListener(new MouseActionListener().mouseEventListener);
	}

	public void updateHoverNote(int curGrid) {
		hoverNote = new Note(curGrid);
		add(hoverNote);
		this.revalidate();
		this.repaint();
	}
	
	public void removeHoverNote() {
		if (hoverNote != null) {remove(hoverNote);}
		this.revalidate();
		this.repaint();
	}
	
	public void pinNote(int pos) {
		hoverNote.pinNote(this, this.type);
		hoverNote = null;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.GRAY);
		for (int i = 1; i < Config.grid; i++) {
			g.drawLine(0, Config.curBarHeight/Config.grid*i-1, Config.curColumnWidth, Config.curBarHeight/Config.grid*i-1);
		}
		
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 1; i < Config.sub; i++) {
			g.drawLine(0, Config.curBarHeight/Config.sub*i-1, Config.curColumnWidth, Config.curBarHeight/Config.sub*i-1);
		}
	}
}
