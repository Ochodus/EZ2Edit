package ez2edit;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseActionListener {
	static int eX;
	static int eY;
	static int curGrid;
	
	MouseHoverListener mouseHoverListener = new MouseHoverListener();
	MouseEventListener mouseEventListener = new MouseEventListener();
	
	MouseHoverListenerNote mouseHoverListenerNote = new MouseHoverListenerNote();
	MouseEventListenerNote mouseEventListenerNote = new MouseEventListenerNote();
	
	public static class MouseHoverListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
				case 0: 
					break;
				case 1: 
					SqBar parent = (SqBar)e.getSource();
					int nextGrid = -((int)(e.getY()/(Config.curBarHeight/Config.grid))-Config.grid+1);
					if (nextGrid != curGrid) {
						curGrid = nextGrid;
						parent.removeHoverNote();
						parent.updateHoverNote(curGrid);
						System.out.println(curGrid);
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
					while (Config.selectedNote.size() != 0) {
						Note note = Config.selectedNote.get(0);
						note.unselectNote();
					}
					break;
				case 1: 
					SqBar parent = (SqBar)e.getSource();
					int nextGrid = -((int)(e.getY()/(Config.curBarHeight/Config.grid))-Config.grid+1);
					if (nextGrid != curGrid) {
						curGrid = nextGrid;
						parent.removeHoverNote();
						parent.updateHoverNote(curGrid);
						System.out.println(curGrid);
					}
					break;
				case 2:
					break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch (Config.editMode) {
				case 0: 
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
					break;
				case 1:
					SqBar parent = (SqBar)e.getSource();
					System.out.println("type: " + parent.type + ", Bar: " + parent.barNumber);
					parent.updateHoverNote(curGrid);
					break;
				case 2:
					break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			SqBar parent = (SqBar)e.getSource();
			parent.removeHoverNote();
		}
	}
	
	public static class MouseHoverListenerNote implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class MouseEventListenerNote implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Note note;
			switch (Config.editMode) {
				case 0: 
					note = (Note)e.getSource();
					note.selectNote();
					System.out.println("Selected");
					break;
				case 1: 
					break;
				case 2:
					note = (Note)e.getSource();
					note.unpinNote();
					System.out.println("Removed");
					break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Note note;
			switch (Config.editMode) {
				case 0: 
					note = (Note)e.getSource();
					note.highlightNote(Color.WHITE);
					break;
				case 1:
					break;
				case 2:
					note = (Note)e.getSource();
					note.highlightNote(Color.RED);
					break;
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Note note;
			switch (Config.editMode) {
				case 0: 
					note = (Note)e.getSource();
					note.unhighlightNote();
					break;
				case 1:
					break;
				case 2:
					note = (Note)e.getSource();
					note.unhighlightNote();
					break;
			}
		}
	}
}
