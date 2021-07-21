package ez2edit;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SqType extends JPanel {

	private static final long serialVersionUID = 1L;
	private int type;

	public SqType(int type) {
		this.type = type;
		this.setBackground(Color.BLACK);
		
		switch (this.type) {
			case 0:
				for (int i = 0; i < 2; i++) {
					SqColumn sqColC = new SqColumn();
					sqColC.setBackground(Color.YELLOW);
					add(sqColC);
				}
				break;
			case 1:
				for (int i = 0; i < 5; i++) {
					SqColumn sqColK = new SqColumn();
					if (i%2 == 0) {sqColK.setBackground(Color.WHITE);}
					else {sqColK.setBackground(Color.BLUE);}
					add(sqColK);
				}
				break;
			case 2:
				SqColumn sqColSC = new SqColumn();
				sqColSC.setBackground(Color.PINK);
				add(sqColSC);
				break;
			case 3:
				SqColumn sqColPED = new SqColumn();
				sqColPED.setBackground(Color.GREEN);
				add(sqColPED);
				break;
			case 4:
				for (int i = 0; i < 2; i++) {
					SqColumn sqColE = new SqColumn();
					sqColE.setBackground(Color.RED);
					add(sqColE);
				}
				break;
			case 5:
				for (int i = 0; i < 4; i++) {
					SqColumn sqColE = new SqColumn();
					sqColE.setBackground(Color.RED);
					add(sqColE);
				}
				break;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		repaint();
		g.setColor(Color.RED);
	}
}
