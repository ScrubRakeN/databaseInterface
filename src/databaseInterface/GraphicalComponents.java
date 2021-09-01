package databaseInterface;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicalComponents {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;
	private DefaultTableCellRenderer cellRenderer;
	private JScrollPane scrollPane;
	private ImageIcon img;
	
	public GraphicalComponents newJFrame(int width, int height, String caption, String url, boolean resizable, Component components) {
		
		frame = new JFrame(caption);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(newImageIcon(url).getImage());
		frame.getContentPane().add(components);
		frame.setResizable(resizable);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		return this;
	}
	
	public JTable newTable(boolean isCellEditable, int tableColumn, int tableRow) {
		
		table = new JTable(newTableModel(isCellEditable, tableColumn, tableRow));
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		return table;
	}
	
	public JScrollPane newScrollPane(int x, int y, int width, int height) {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(x, y, width, height);
		
		return scrollPane;
		
	}
	
	public DefaultTableModel newTableModel(boolean isCellEditable, int tableColumn, int tableRow) {
		
		tableModel = new DefaultTableModel(new String[] {}, 0) {
			public boolean isCellEditable(int col, int row) {
				
				if(col == tableColumn || row == tableRow) {
					
					return isCellEditable;
					
				}
					return false;
				
			}
		};
		
		return tableModel;
	}
	
	public DefaultTableCellRenderer newCellRenderer(int alignment) {
		
		cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(alignment);
		
		return cellRenderer;
		
	}
	
	public ImageIcon newImageIcon(String url) {
		
		img = new ImageIcon(url);
		
		return img;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public DefaultTableCellRenderer getCellRenderer() {
		return cellRenderer;
	}

	public void setCellRenderer(DefaultTableCellRenderer cellRenderer) {
		this.cellRenderer = cellRenderer;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
}
