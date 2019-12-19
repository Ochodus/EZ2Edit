package ez2edit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class SqTableColorRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		System.out.println("on");
		comp.setBackground(Color.red);
		return(comp);
	}
}
