package databaseInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Interface extends JPanel{
	
	static GraphicalComponents gComponents = new GraphicalComponents();
	static MySQL database = new MySQL();
	
	public static void filter(JPanel pane) {
		
		pane.add(gComponents.newCheckBox(450, 15, 50, 30, "ID"));
		JCheckBox idBox = gComponents.getCheckBox();
		gComponents.getCheckBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(idBox.isSelected()) {
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("id")).setMinWidth(90);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("id")).setMaxWidth(110);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("id")).setPreferredWidth(100);
					
				}else {
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("id")).setMinWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("id")).setMaxWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("id")).setWidth(0);
					
				}
				
			}
		});
		
		pane.add(gComponents.newCheckBox(500, 15, 60, 30, "Name"));
		JCheckBox nameBox = gComponents.getCheckBox();
		gComponents.getCheckBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(nameBox.isSelected()) {
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("name")).setMinWidth(90);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("name")).setMaxWidth(110);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("name")).setPreferredWidth(100);
					
				}else{
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("name")).setMinWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("name")).setMaxWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("name")).setWidth(0);
					
				}
				
			}
		});
		
		pane.add(gComponents.newCheckBox(570, 15, 60, 30, "Brand"));
		JCheckBox brandBox = gComponents.getCheckBox();
		gComponents.getCheckBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(brandBox.isSelected()) {
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("brand")).setMinWidth(90);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("brand")).setMaxWidth(110);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("brand")).setPreferredWidth(100);
					
				}else{
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("brand")).setMinWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("brand")).setMaxWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("brand")).setWidth(0);
					
				}
				
			}
		});
		
		
		pane.add(gComponents.newCheckBox(450, 45, 80, 30, "Quantity"));
		JCheckBox quantityBox = gComponents.getCheckBox();
		gComponents.getCheckBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(quantityBox.isSelected()) {
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("quantity")).setMinWidth(90);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("quantity")).setMaxWidth(110);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("quantity")).setPreferredWidth(100);
					
				}else{
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("quantity")).setMinWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("quantity")).setMaxWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("quantity")).setWidth(0);
					
				}
				
			}
		});
		
		pane.add(gComponents.newCheckBox(535, 45, 100, 30, "Color"));
		JCheckBox colorBox = gComponents.getCheckBox();
		gComponents.getCheckBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(colorBox.isSelected()) {
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("color")).setMinWidth(90);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("color")).setMaxWidth(110);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("color")).setPreferredWidth(100);
					
				}else{
					
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("color")).setMinWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("color")).setMaxWidth(0);
					gComponents.getTable().getColumnModel().getColumn(gComponents.getTableModel().findColumn("color")).setWidth(0);
					
				}
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		
		JPanel pane = new Interface();
		pane.setLayout(null);
		
		gComponents.newTable();
		gComponents.getTable().setModel(gComponents.newTableModel(false, 0, 0));
		pane.add(gComponents.newScrollPane(10, 10, 400, 120));
		gComponents.getScrollPane().setViewportView(gComponents.getTable());
		
		if(database.getConnection()) {
			
			try {
				
				String query = "SELECT * FROM storage";
				
				PreparedStatement queryReady = database.connection.prepareStatement(query);
				ResultSet response = queryReady.executeQuery();
				
				
				for(int i = 1; i <= response.getMetaData().getColumnCount(); i++) {
					
						
					gComponents.getTableModel().addColumn(response.getMetaData().getColumnName(i));
						
					
				}
				
				for(int i = 0; i < gComponents.getTable().getColumnCount(); i++) {
					
					gComponents.getTable().getColumnModel().getColumn(i).setCellRenderer(gComponents.newCellRenderer(SwingConstants.HORIZONTAL));
					gComponents.getTable().getColumnModel().getColumn(i).setResizable(false);
					gComponents.getTable().getColumnModel().getColumn(i).setMinWidth(0);
					gComponents.getTable().getColumnModel().getColumn(i).setMaxWidth(0);
					gComponents.getTable().getColumnModel().getColumn(i).setWidth(0);
					
				}
				
				while(response.next()) {
					
					String[] data = new String[response.getMetaData().getColumnCount()];
					
					for(int i = 1; i <= response.getMetaData().getColumnCount(); i++) {
						
						data[i - 1] = response.getString(i);
						
					}
					
					gComponents.getTableModel().addRow(data);
					
				}
				
			}catch(SQLException error) {
			
			}
			
			filter(pane);
			
			gComponents.newJFrame(700, 175, "Database Interface", "C:\\Users\\CLIENTE\\Downloads\\database.png", false, pane);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "There was an error trying to connnect", "Connection", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}

}
