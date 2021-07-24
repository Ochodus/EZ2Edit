package ez2edit;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Toolbar extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Dimension ToolDim = new Dimension(0, 50);
	
	private static Button btn_new = new Button("new");
	private static Button btn_open = new Button("Open");
	private static Button btn_save = new Button("Save");
	private static Button btn_new_save = new Button("Save as...");
	
	private static Button btn_select = new Button("select");
	private static Button btn_edit = new Button("edit");
	private static Button btn_delete = new Button("delete");
	
	private static String[] playerList = {"UBMPlayer, ETC, ½´½µ½µ½Ã¹ß·¯¸¶"};
	private static JList<String> playerSelect = new JList<String>(); 
	
	private static Button btn_play = new Button("play");
	private static Button btn_play_at = new Button("play at...");
	private static Button btn_stop = new Button("stop");
	
	
	
	
	public Toolbar() {
		setOpaque(true);
		setBackground(new Color(240,240,240));
		setPreferredSize(ToolDim);
		
		playerSelect.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		playerSelect.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		playerSelect.setVisibleRowCount(-1);
		
		for (int i = 0; i < playerList.length; i++) {
			playerSelect.add(new Button(playerList[i]));
		}
		
		JScrollPane playerSelectScroll = new JScrollPane(playerSelect);
		
		add(btn_new);
		add(btn_open);
		add(btn_save);
		add(btn_new_save);
		
		add(playerSelectScroll);
		
		add(btn_select);
		add(btn_edit);
		add(btn_delete);
		
		add(btn_play);
		add(btn_play_at);
		add(btn_stop);
		
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
				while (ProcessInfo.selectedNote.size() != 0) {
					Note note = ProcessInfo.selectedNote.get(0);
					note.unselectNote();
				}
				Config.editMode = 1;
				EZ2edit.ez2Edit.requestFocus();
			}
		});
		
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (ProcessInfo.selectedNote.size() != 0) {
					Note note = ProcessInfo.selectedNote.get(0);
					note.unselectNote();
				}
				Config.editMode = 2;
				EZ2edit.ez2Edit.requestFocus();
			}
		});
	}
}
