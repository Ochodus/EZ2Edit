package ez2edit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SqType extends JPanel {

	private static final long serialVersionUID = 1L;
	private int type;
	private static FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0, 0);
	private boolean is2P = false;

	public SqType(int type, boolean is2P) {
		this.type = type;
		this.setLayout(fl);
		this.setBackground(Color.BLACK);
		this.is2P = is2P;
		setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.WHITE));
		
		switch (this.type) {
			case 0:
				for (int i = 0; i < 2; i++) {
					SqColumn sqColC = new SqColumn(this.type, i);
					sqColC.setBackground(Color.YELLOW);
					add(sqColC);
				}
				break;
			case 1:
				for (int i = 0; i < 5; i++) {
					SqColumn sqColK = new SqColumn(this.type, i, is2P);
					if (i%2 == 0) {sqColK.setBackground(Color.WHITE);}
					else {sqColK.setBackground(Color.BLUE);}
					add(sqColK);
				}
				break;
			case 2:
				SqColumn sqColSC = new SqColumn(this.type, 0, is2P);
				sqColSC.setBackground(Color.PINK);
				add(sqColSC);
				break;
			case 3:
				SqColumn sqColPED = new SqColumn(this.type, 0);
				sqColPED.setBackground(Color.GREEN);
				add(sqColPED);
				break;
			case 4:
				for (int i = 0; i < 2; i++) {
					SqColumn sqColE = new SqColumn(this.type, 0);
					sqColE.setBackground(Color.RED);
					add(sqColE);
				}
				break;
			case 5:
				for (int i = 0; i < 4; i++) {
					SqColumn sqColE = new SqColumn(this.type, i);
					sqColE.setBackground(Color.RED);
					add(sqColE);
				}
				break;
		}
	}
	
	public SqType(int type) {
		this(type, false);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
		g.setColor(Color.RED);
	}
}
