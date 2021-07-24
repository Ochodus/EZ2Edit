package ez2edit;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SqType extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int type;
	private boolean is2P = false;
	
	public SqType nextType = null;
	public SqType prevType = null;
	
	public List<SqColumn> linesInType = new ArrayList<SqColumn>();
	
	private static FlowLayout sqTypeLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);

	public SqType(int type, boolean is2P) {
		
		this.type = type;
		this.is2P = is2P;
		
		this.setLayout(sqTypeLayout);
		this.setBackground(Color.BLACK);
		
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.WHITE));
		
		switch (this.type) {
			case 0:
				for (int i = 0; i < 2; i++) {
					SqColumn sqColC = new SqColumn(this.type, i, this);
					sqColC.setBackground(Color.YELLOW);
					add(sqColC);
					linesInType.add(sqColC);
				}
				break;
			case 1:
				for (int i = 0; i < 5; i++) {
					SqColumn sqColK = new SqColumn(this.type, i, this.is2P, this);
					if (i%2 == 0) {sqColK.setBackground(Color.WHITE);}
					else {sqColK.setBackground(Color.BLUE);}
					add(sqColK);
					linesInType.add(sqColK);
				}
				break;
			case 2:
				SqColumn sqColSC = new SqColumn(this.type, 0, this.is2P, this);
				sqColSC.setBackground(Color.PINK);
				add(sqColSC);
				linesInType.add(sqColSC);
				break;
			case 3:
				SqColumn sqColPED = new SqColumn(this.type, 0, this);
				sqColPED.setBackground(Color.GREEN);
				add(sqColPED);
				linesInType.add(sqColPED);
				break;
			case 4:
				for (int i = 0; i < 2; i++) {
					SqColumn sqColE = new SqColumn(this.type, i, this);
					sqColE.setBackground(Color.RED);
					add(sqColE);
				}
				break;
			case 5:
				for (int i = 0; i < 4; i++) {
					SqColumn sqColE = new SqColumn(this.type, i, this);
					sqColE.setBackground(Color.RED);
					add(sqColE);
					linesInType.add(sqColE);
				}
				break;
		}
		
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListener);
		this.addMouseListener(new MouseActionListener().mouseEventListener);
	}
	
	public SqType(int type) {
		this(type, false);
	}
}
