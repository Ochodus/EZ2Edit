package ez2edit;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ConfigArea extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Dimension ConfigDim = new Dimension(180, 0);

	public ConfigArea() {
		setOpaque(true);
		setBackground(Color.YELLOW);
		setPreferredSize(ConfigDim);
	}
}
