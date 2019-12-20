package ez2edit;

import java.awt.*;

import javax.swing.*;

public class SqTable extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	int initLineNumber = 100;
	int playMode = 9;
	
	public SqTable() {	
		setLayout(new GridLayout(initLineNumber, playMode, 1, 1));
		for(int i = 0; i < initLineNumber; i++) {
			for(int j = 0; j < playMode; j++) {
				SqCell sqCell = new SqCell();
				add(sqCell);
			}
		}
	}
}
