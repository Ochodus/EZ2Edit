package ez2edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class SqColumn extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public GridBagLayout gbl = new GridBagLayout();
	public GridBagConstraints gbc = new GridBagConstraints();
	
	public SqColumn() {
		setVisible(true);
		
		for(int i = 0; i < Config.initBarNumber; i++) {
			gbc.weightx = 1;
			gbc.weighty = 5;
			SqBar sqBar = new SqBar(Config.initBeat, Config.initModer);
			add(sqBar, gbc);
		}
	}
}
