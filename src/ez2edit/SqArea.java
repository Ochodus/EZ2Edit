package ez2edit;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SqArea extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JScrollPane scroll = new JScrollPane(SqComponent.sqTable);
	
	static BorderLayout bl = new BorderLayout();
	
	public SqArea() {
		this.setLayout(bl);
		
		setOpaque(true);
		setBackground(Color.BLACK);
		add(scroll);
		
		SqComponent.sqTable.addColumns();
	}
	
	public void paintSelectBox() {
		//super.paintComponent(g);
	}
}
