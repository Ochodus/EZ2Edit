package ez2edit;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class SqTable extends JPanel {
	
	private static final long serialVersionUID = 1L;
	static FlowLayout fl = new FlowLayout(FlowLayout.LEFT, Config.typeGap, 0);
	
	public SqTable() {
		this.setLayout(fl);	
		setBackground(Color.BLACK);
	}
	
	public void addColumns() {
		add(SqComponent.sqTypeConfig);
		
		switch (Config.playMode) {
			case 5:
				add(SqComponent.sqTypeLKey);
				break;
			case 7:
				add(SqComponent.sqTypeLScratch);
				add(SqComponent.sqTypeLKey);
				add(SqComponent.sqTypePedal);
				break;
			case 9:
				add(SqComponent.sqTypeLScratch);
				add(SqComponent.sqTypeLKey);
				add(SqComponent.sqTypePedal);
				add(SqComponent.sqTypeLEffect);
				break;
			case 13:
				add(SqComponent.sqTypeLScratch);
				add(SqComponent.sqTypeLKey);
				add(SqComponent.sqTypePedal);
				add(SqComponent.sqTypeRKey);
				add(SqComponent.sqTypeRScratch);
				break;
			case 16:
				add(SqComponent.sqTypeLScratch);
				add(SqComponent.sqTypeLKey);
				add(SqComponent.sqTypeWEffect);
				add(SqComponent.sqTypeRKey);
				add(SqComponent.sqTypeRScratch);
				break;
		}
	}
}
