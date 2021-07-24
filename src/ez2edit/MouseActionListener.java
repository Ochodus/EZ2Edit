package ez2edit;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseActionListener {
	public static int eX;
	public static int eY;
	public static int absX;
	public static int absY;
	public static int absXFin;
	public static int absYFin;
	public static int rectX;
	public static int rectY;
	public static int rectWidth;
	public static int rectHeight;
	public static boolean isLeftPressedOnTable = false;
	public static boolean isLeftPressedOnNote = false;
	public static int curGrid;
	public static SqBar curBar;
	public static SqColumn curColumn;
	
	MouseHoverListener mouseHoverListener = new MouseHoverListener();
	MouseEventListener mouseEventListener = new MouseEventListener();
	
	public static class MouseHoverListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if (isLeftPressedOnTable) {
				absXFin = e.getXOnScreen() - EZ2edit.ez2Edit.getLocation().x;
				absYFin = e.getYOnScreen() - EZ2edit.ez2Edit.getLocation().y;
				
				if (absXFin > absX) {
					rectX = absX - SqTable.offsetX;
					rectWidth = absXFin - absX;
				}
				else {
					rectX = absXFin - SqTable.offsetX;
					rectWidth = absX - absXFin;
				}
				
				if (absYFin > absY) {
					rectY = absY - SqTable.offsetY;
					rectHeight = absYFin - absY;
				}
				else {
					rectY = absYFin - SqTable.offsetY;
					rectHeight = absY - absYFin;
				}
				
				SqArea.sqTable.highlightNotesInBox();
				SqArea.sqTable.repaint();
			}
			
			if (isLeftPressedOnNote) {
				int nextGrid = -((int)((e.getYOnScreen() - e.getComponent().getParent().getLocationOnScreen().y)/(Config.curBarHeight/Config.grid))-Config.grid+1);
				if (e.getYOnScreen() - e.getComponent().getParent().getLocationOnScreen().y < 0) {nextGrid = 8;}
				if (nextGrid != curGrid) {
					int offset = nextGrid - curGrid;
					
					SqArea.sqTable.moveSelectedNotes(0, offset);
					
					if (nextGrid < 0) {nextGrid = Config.grid - 1;}
					if (nextGrid > Config.grid - 1) {nextGrid = 0;}
					curGrid = nextGrid;
				}
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
				case 0: 
					if (e.getSource() instanceof SqBar) {
						int nextGrid = -((int)(e.getY()/(Config.curBarHeight/Config.grid))-Config.grid+1);
						if (nextGrid != curGrid) {
							curGrid = nextGrid;
						}
					}
					if (e.getSource() instanceof Note) {
						int nextGrid = -((int)((e.getYOnScreen() - e.getComponent().getParent().getLocationOnScreen().y)/(Config.curBarHeight/Config.grid))-Config.grid+1);
						if (nextGrid != curGrid) {
							curGrid = nextGrid;
						}
					}
					break;
				case 1:  
					if (e.getSource() instanceof SqBar) {
						SqBar parent = (SqBar)e.getSource();
						int nextGrid = -((int)(e.getY()/(Config.curBarHeight/Config.grid))-Config.grid+1);
						if (nextGrid != curGrid) {
							curGrid = nextGrid;
							parent.removeHoverNote();
							parent.updateHoverNote(curGrid);
							System.out.println(curGrid);
						}
					}
					break;
				case 2:
					break;
			}
		}
	}
	
	public class MouseEventListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
				case 0: 
					if (e.getSource() instanceof Note) {
						Note note = (Note)e.getSource();
						note.selectNote(false);
						System.out.println("Selected");
						curColumn = note.bar.line;
						isLeftPressedOnNote = true;
					}
					else {
						if (!KeyActionListener.isCtrPressed) {
							while (ProcessInfo.selectedNote.size() != 0) {
								Note note = ProcessInfo.selectedNote.get(0);
								note.unselectNote();
							}
						}
						absX = e.getXOnScreen() - EZ2edit.ez2Edit.getLocation().x;
						absY = e.getYOnScreen() - EZ2edit.ez2Edit.getLocation().y;
						absXFin = absX;
						absYFin = absY;
						rectX = absX;
						rectY = absY;
						rectWidth = 0;
						rectHeight = 0;
						isLeftPressedOnTable = true;
					}
					break;
				case 1: 
					break;
				case 2:
					if (e.getSource() instanceof Note) {
						Note note = (Note)e.getSource();
						note.unpinNote();
						System.out.println("Removed");
					}
					break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
				case 0: 
					isLeftPressedOnTable = false;
					isLeftPressedOnNote = false;
					SqArea.sqTable.repaint();
					SqArea.sqTable.selectNotesInBox();
					break;
				case 1: 
					SqBar parent = (SqBar)e.getSource();
					parent.pinNote(curGrid);
					break;
				case 2:
					break;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
				case 0: 
					if (e.getSource() instanceof Note) {
						Note note = (Note)e.getSource();
						note.highlightNote(Color.WHITE);
					}
					if (e.getSource() instanceof SqBar && isLeftPressedOnNote) {
						SqBar parent = (SqBar)e.getSource();
						if (curBar != parent) {
							curBar = parent;
							//move note between bar
						}
						if (curColumn != parent.line) {
							int offset = SqTable.currentLines.indexOf(parent.line) - SqTable.currentLines.indexOf(curColumn);
							curColumn = parent.line;
							
							SqArea.sqTable.moveSelectedNotes(offset, 0);
						}
						System.out.println("type: " + parent.type + ", Bar: " + parent.barNumber);
					}
					break;
				case 1:
					if (e.getSource() instanceof SqBar) {
						SqBar parent = (SqBar)e.getSource();
						System.out.println("type: " + parent.type + ", Bar: " + parent.barNumber);
						parent.updateHoverNote(curGrid);
						curColumn = parent.line;
					}
					break;
				case 2:
					if (e.getSource() instanceof Note) {
						Note note = (Note)e.getSource();
						note.highlightNote(Color.RED);
					}
					break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
			case 0: 
				if (e.getSource() instanceof Note) {
					Note note = (Note)e.getSource();
					note.unhighlightNote();
				}
				break;
			case 1:
				if (e.getSource() instanceof SqBar) {
					SqBar parent = (SqBar)e.getSource();
					System.out.println(e.getSource() instanceof SqBar);
					parent.removeHoverNote();
				}
				break;
			case 2:
				if (e.getSource() instanceof Note) {
					Note note = (Note)e.getSource();
					note.unhighlightNote();
				}
				break;
		}
			
		}
	}
}
