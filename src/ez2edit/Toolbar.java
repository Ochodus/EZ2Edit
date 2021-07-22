package ez2edit;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Toolbar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Dimension ToolDim = new Dimension(0, 50);
	private static Button btn_select = new Button("select");
	private static Button btn_edit = new Button("edit");
	private static Button btn_delete = new Button("delete");
	
	public Toolbar() {
		setOpaque(true);
		setBackground(Color.RED);
		setPreferredSize(ToolDim);
		
		add(btn_select);
		add(btn_edit);
		add(btn_delete);
		
		btn_select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Config.editMode = 0;
				EZ2edit.ez2Edit.requestFocus();
			}
		});
		
		btn_edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Config.editMode = 1;
				EZ2edit.ez2Edit.requestFocus();
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Config.editMode = 2;
				EZ2edit.ez2Edit.requestFocus();
			}
		});
	}
}
