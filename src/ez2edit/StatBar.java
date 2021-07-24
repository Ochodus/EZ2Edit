package ez2edit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class StatBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Dimension StatDim = new Dimension(0, 20);

	public StatBar() {
		setOpaque(true);
		setBackground(new Color(240,240,240));
		setPreferredSize(StatDim);
	}
}
