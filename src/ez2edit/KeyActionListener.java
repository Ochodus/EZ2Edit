package ez2edit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyActionListener implements KeyListener {
	
	public static boolean isCtrPressed = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 17) {isCtrPressed = true;
		System.out.println("Ctr Pressed.");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 17) {isCtrPressed = false;}
		
	}

}
