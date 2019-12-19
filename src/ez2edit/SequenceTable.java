package ez2edit;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;

public class SequenceTable{
	
	private int initLineCount = 9;
	int lineCount = initLineCount;
	JTable jTable;
	JScrollPane jScrollPane;
	private int hoveredRow = -1;
	private int hoveredColumn = -1;
	String header[]= {"BPM","STOP","SC","1","2","3","4","5","PED"};
	Boolean rowData[][] = new Boolean[initLineCount][header.length];
	
	public SequenceTable() {
		jTable = new JTable(rowData, header);
		jScrollPane = new JScrollPane(jTable);
		
		TableColumn column = jTable.getColumnModel().getColumn(2);
		column.setCellRenderer(new SqTableColorRenderer());
		
		jTable.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();
				if (hoveredRow != jTable.rowAtPoint(p)) {
					hoveredRow = jTable.rowAtPoint(p);
					System.out.println(lineCount - hoveredRow + ", "  + header[hoveredColumn]);
				}
				if (hoveredColumn != jTable.columnAtPoint(p)) {
					hoveredColumn = jTable.columnAtPoint(p);
					System.out.println(lineCount - hoveredRow + ", "  + header[hoveredColumn]);
				}			
			}
		});
		
		jTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Point p = e.getPoint();
				hoveredRow = jTable.rowAtPoint(p);
				hoveredColumn = jTable.columnAtPoint(p);
				
				System.out.println(lineCount - hoveredRow + ", "  + header[hoveredColumn]);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	
}
