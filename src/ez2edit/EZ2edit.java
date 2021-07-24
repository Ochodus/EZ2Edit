package ez2edit;

public class EZ2edit {
	
	static MainFrame ez2Edit;
	
	public static void main(String[] args) {
		ez2Edit = new MainFrame("EZ2Edit");
		ez2Edit.addKeyListener(new KeyActionListener());
		ez2Edit.setFocusable(true);
		ez2Edit.getLocations();
		MainFrame.sqArea.initScroll();
	}
}
