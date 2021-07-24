package ez2edit;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SqTable extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static final String[][] lineInfo = {{"BPM", "STOP"}, {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, {"LSC", "RSC"}, {"PED"}, {"E1", "E2"}, {"E1", "E2", "E3", "E4"}};
	public static List<SqColumn> currentLines = new ArrayList<SqColumn>();
	
	private static SqType sqTypeConfig = new SqType(0);
	private static SqType sqTypeLKey = new SqType(1);
	private static SqType sqTypeRKey = new SqType(1, true);
	private static SqType sqTypeLScratch = new SqType(2);
	private static SqType sqTypeRScratch = new SqType(2, true);
	private static SqType sqTypePedal = new SqType(3);
	private static SqType sqTypeLEffect = new SqType(4);
	private static SqType sqTypeWEffect = new SqType(5);
	
	public static SqType nextType = null;
	public static SqType prevType = null;
	
	public static int offsetX;
	public static int offsetY;
	
	private static FlowLayout sqTableLayout = new FlowLayout(FlowLayout.LEFT, Config.typeGap, 0);
	
	public SqTable() {
		this.setLayout(sqTableLayout);	
		this.setBackground(Color.BLACK);
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListener);
		this.addMouseListener(new MouseActionListener().mouseEventListener);
	}
	
	public void addColumns() {
		addType(sqTypeConfig);
		
		switch (Config.playMode) {
			case 5:
				addType(sqTypeLKey);
				break;
			case 7:
				addType(sqTypeLScratch);
				addType(sqTypeLKey);
				addType(sqTypePedal);
				break;
			case 9:
				addType(sqTypeLScratch);
				addType(sqTypeLKey);
				addType(sqTypePedal);
				addType(sqTypeLEffect);
				break;
			case 13:
				addType(sqTypeLScratch);
				addType(sqTypeLKey);
				addType(sqTypePedal);
				addType(sqTypeRKey);
				addType(sqTypeRScratch);
				break;
			case 16:
				addType(sqTypeLScratch);
				addType(sqTypeLKey);
				addType(sqTypeWEffect);
				addType(sqTypeRKey);
				addType(sqTypeRScratch);
				break;
		}
	}
	
	public void setOffsets() {
		offsetX = this.getLocationOnScreen().x - MainFrame.x;
		offsetY = this.getLocationOnScreen().y - MainFrame.y;
	}
	
	public void paintSelectBox(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect(MouseActionListener.rectX, MouseActionListener.rectY, MouseActionListener.rectWidth, MouseActionListener.rectHeight);
	}
	
	public void highlightNotesInBox() {
		for (int i = 0; i < ProcessInfo.pinnedNote.size(); i++) {
			Note note = ProcessInfo.pinnedNote.get(i);
			
			if ((note.getPosXFin() > MouseActionListener.rectX && note.getPosX() < (MouseActionListener.rectX + MouseActionListener.rectWidth)) && (note.getPosYFin() > MouseActionListener.rectY && note.getPosY() < (MouseActionListener.rectY + MouseActionListener.rectHeight))) {
				note.highlightNote(Color.WHITE);
			}
			else {
				note.unhighlightNote();
			}
		}
	}
	
	public void selectNotesInBox() {
		for (int i = 0; i < ProcessInfo.pinnedNote.size(); i++) {
			Note note = ProcessInfo.pinnedNote.get(i);
			
			if ((note.getPosXFin() > MouseActionListener.rectX && note.getPosX() < (MouseActionListener.rectX + MouseActionListener.rectWidth)) && (note.getPosYFin() > MouseActionListener.rectY && note.getPosY() < (MouseActionListener.rectY + MouseActionListener.rectHeight))) {
				note.selectNote(true);
			}
		}
	}
	
	public void moveSelectedNotes(int offsetX, int offsetY) {
		for (int i = 0; i < ProcessInfo.selectedNote.size(); i++) {
			Note note = ProcessInfo.selectedNote.get(i);
			System.out.println(i+"th Note");
			note.reposition(offsetX, offsetY);
		}
	}
	
	public void addType(SqType sqType) {
		for (int i = 0; i < sqType.linesInType.size(); i++) {
			SqTable.currentLines.add(sqType.linesInType.get(i));
		}
		this.add(sqType);
	}
	
	public void paint(Graphics g){
		super.paint(g);

		if (MouseActionListener.isLeftPressedOnTable) {
			paintSelectBox(g);
		}
	}
}
