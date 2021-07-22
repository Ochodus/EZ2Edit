package ez2edit;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Note extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static Note[] pinnedNotes;
	private SqBar bar;
	private int pos;
	private String type;
	private boolean selected = false;
	
	private Dimension noteDim = new Dimension(Config.curColumnWidth, Config.NoteHeight);
	
	public Note(int curGrid) {
		setVisible(true);
		setPreferredSize(noteDim);
		setBackground(Color.black);
		this.pos = (Config.grid-curGrid)*(int)((Config.curBarHeight/Config.grid));
		setBounds(1, this.pos-Config.NoteHeight, Config.curColumnWidth, Config.NoteHeight);
	}
	
	public void pinNote(SqBar bar, String type) {
		Config.pinnedNote.add(this);
		this.bar = bar;
		this.type = type;
		this.addMouseMotionListener(new MouseActionListener().mouseHoverListenerNote);
		this.addMouseListener(new MouseActionListener().mouseEventListenerNote);
		Config.pinnedNote.add(this);
	}
	
	public void highlightNote(Color color) {
		this.setBorder(BorderFactory.createLineBorder(color));
	}
	
	public void unhighlightNote() {
		this.setBorder(null);
	}
	
	public void unpinNote() {
		this.bar.remove(this);
		Config.pinnedNote.remove(this);
		this.bar.revalidate();
		this.bar.repaint();
	}
	
	public void selectNote() {
		if (!this.selected) {
			if (!KeyActionListener.isCtrPressed) {
				while (Config.selectedNote.size() != 0) {
					Note note = Config.selectedNote.get(0);
					note.unselectNote();
				}
				Config.selectedNote.add(this);
				this.setBackground(Color.MAGENTA);
			}
			else {
				Config.selectedNote.add(this);
				this.setBackground(Color.MAGENTA);
			}
			this.selected = true;
		}
	}
	
	public void unselectNote() {
		Config.selectedNote.remove(this);
		this.setBackground(Color.BLACK);
		this.selected = false;
	}
}
