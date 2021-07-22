package ez2edit;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class SqColumn extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0, 0);
	
	private int mod = 0;
	private static final Dimension columnDim = new Dimension(Config.curColumnWidth, Config.initBarNumber*Config.curBarHeight);
	private boolean is2P;
	
	public SqColumn(int type, int mod, boolean is2P) {
		this.mod = mod;
		setVisible(true);
		setPreferredSize(columnDim);
		setLayout(fl);
		this.is2P = is2P;
		
		for(int i = Config.initBarNumber-1; i >= 0; i--) {
			SqBar sqBar = new SqBar(Config.initBeat, Config.initModer, type, this.mod, this.is2P, i);
			add(sqBar);
		}
	}
	
	public SqColumn(int type, int mod) {
		this(type, mod, false);
	}
	
	public SqColumn(int type) {
		this(type, 0, false);
	}
}
