package ez2edit;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SqColumn extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 0, 0);
	
	private int mod = 0;
	private static final Dimension columnDim = new Dimension(Config.curColumnWidth, Config.initBarNumber*Config.curBarHeight);
	private boolean is2P;
	public SqType type;
	
	public List<SqBar> barsInColumn = new ArrayList<SqBar>();
	
	public SqColumn(int type, int mod, boolean is2P, SqType sqType) {
		this.mod = mod;
		setVisible(true);
		setPreferredSize(columnDim);
		setLayout(fl);
		this.is2P = is2P;
		
		SqBar sqBar = new SqBar(Config.initBeat, Config.initModer, type, this.mod, this.is2P, Config.initBarNumber-1, this);
		add(sqBar);
		barsInColumn.add(sqBar);
		
		for(int i = Config.initBarNumber-2; i >= 0; i--) {
			SqBar nextSqBar = new SqBar(Config.initBeat, Config.initModer, type, this.mod, this.is2P, i, this);
			sqBar.prevBar = nextSqBar;
			nextSqBar.nextBar = sqBar;
			add(nextSqBar);
			
			barsInColumn.add(nextSqBar);
			sqBar = nextSqBar;
		}
	}
	
	public SqColumn(int type, int mod, SqType sqType) {
		this(type, mod, false, sqType);
	}
	
	public SqColumn(int type, SqType sqType) {
		this(type, 0, false, sqType);
	}
}
