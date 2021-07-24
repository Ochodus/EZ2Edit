package ez2edit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Note extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public SqBar bar;
	private int pos;
	private String type;
	private int grid;
	private boolean selected = false;
	private boolean isUnderflowed = false;
	private boolean isOverflowed = false;
	
	private Dimension noteDim = new Dimension(Config.curColumnWidth, Config.NoteHeight);
	
	public Note(int curGrid) {
		
		this.pos = (Config.grid-curGrid)*(int)((Config.curBarHeight/Config.grid));
		this.grid = curGrid;
		this.setVisible(true);
		this.setPreferredSize(noteDim);
		this.setBackground(Color.black);
		this.setBounds(1, this.pos-Config.NoteHeight, Config.curColumnWidth, Config.NoteHeight);
	}
	
	public void pinNote(SqBar bar, String type) {
		this.bar = bar;
		this.type = type;
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListener);
		this.addMouseListener(new MouseActionListener().mouseEventListener);
		
		ProcessInfo.pinnedNote.add(this);
	}
	
	public void pinNote() {
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListener);
		this.addMouseListener(new MouseActionListener().mouseEventListener);
		
		ProcessInfo.pinnedNote.add(this);
	}
	
	public void highlightNote(Color color) {
		this.setBorder(BorderFactory.createLineBorder(color));
	}
	
	public void unhighlightNote() {
		if (!selected) {this.setBorder(null);}
	}
	
	public void unpinNote() {
		this.bar.remove(this);
		this.bar.revalidate();
		this.bar.repaint();
		
		ProcessInfo.pinnedNote.remove(this);
	}
	
	public void selectNote(boolean allMode) {
		if (!this.selected) {
			if (!KeyActionListener.isCtrPressed && !allMode) {
				while (ProcessInfo.selectedNote.size() != 0) {
					Note note = ProcessInfo.selectedNote.get(0);
					note.unselectNote();
				}
				ProcessInfo.selectedNote.add(this);
				this.setBackground(Color.MAGENTA);
			}
			else {
				ProcessInfo.selectedNote.add(this);
				this.setBackground(Color.MAGENTA);
			}
			this.selected = true;
		}
	}
	
	public void unselectNote() {
		ProcessInfo.selectedNote.remove(this);
		this.setBackground(Color.BLACK);
		this.selected = false;
		this.unhighlightNote();
	}
	
	public void reposition(int offsetX, int offsetY) {
		System.out.println("OffsetX: "+offsetX);
		if (offsetX != 0) {
			
			int index = SqTable.currentLines.indexOf(this.bar.line) + offsetX;
			
			this.unpinNote();
			
			if (index < 0) {
				index = SqTable.currentLines.size()-1;
			}
			else if (index > SqTable.currentLines.size() - 1) {
				index = 0;
			}
			
			this.bar = SqTable.currentLines.get(index).barsInColumn.get(-(this.bar.barNumber - Config.initBarNumber + 1));
			
			this.bar.add(this);
			this.pinNote();
		}
		if (offsetY != 0) {
			
			this.grid = this.grid + offsetY;
			
			if (this.isUnderflowed) {
				if (this.grid >= 0) {
					this.isUnderflowed = false;
					this.bar.add(this);
					this.pinNote();
				}
			}
			
			if (this.isOverflowed) {
				if (this.grid < Config.grid) {
					this.isOverflowed = false;
					this.bar.add(this);
					this.pinNote();
				}
			}
			
			if (this.grid < 0 && !this.isUnderflowed) {
				if (this.bar.prevBar == null) {
					this.unpinNote();
					this.isUnderflowed = true;
					return;
				}
				else {
					this.unpinNote();
					this.bar = this.bar.prevBar;
					this.bar.add(this);
					this.pinNote();
					this.grid = Config.grid - 1;
				}
			}
			else if (this.grid > Config.grid-1 && !this.isOverflowed) {
				if (this.bar.nextBar == null) {
					this.isOverflowed = true;
					this.unpinNote();
					return;
				}
				else {
					this.unpinNote();
					this.bar = this.bar.nextBar;
					this.bar.add(this);
					this.pinNote();
					this.grid = 0;
				}
			}
			
			this.pos = (Config.grid-this.grid)*(int)((Config.curBarHeight/Config.grid));
			this.setBounds(1, this.pos-Config.NoteHeight, Config.curColumnWidth, Config.NoteHeight);
		}
		
		SqArea.sqTable.repaint();
	}
	
	public int getPosX() {
		return this.getLocationOnScreen().x - EZ2edit.ez2Edit.getLocation().x - SqTable.offsetX;
	}
	
	public int getPosXFin() {
		return this.getLocationOnScreen().x - EZ2edit.ez2Edit.getLocation().x - SqTable.offsetX + this.getWidth();
	}
	
	public int getPosY() {
		return this.getLocationOnScreen().y - EZ2edit.ez2Edit.getLocation().y - SqTable.offsetY;
	}
	
	public int getPosYFin() {
		return this.getLocationOnScreen().y - EZ2edit.ez2Edit.getLocation().y - SqTable.offsetY + this.getHeight();
	}
}
