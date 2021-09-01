package databaseInterface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Interface extends JPanel{
	
	static GraphicalComponents gComponents = new GraphicalComponents();
	
	public static void initializeComponents() {
		
		JPanel pane = new Interface();
		pane.setLayout(null);
		
		gComponents.newTable(false, 0, 0);
		gComponents.newScrollPane(10, 10, 400, 200);
		gComponents.getScrollPane().setViewportView(gComponents.getTable());
		pane.add(gComponents.getScrollPane());
		
		gComponents.newJFrame(700, 500, "Database Interface", "", false, pane);
		
	}
	
	public static void main(String[] args) {
		
		
		
		MySQL database = new MySQL();
		
		if(database.getConnection()) {
			
			try {
				
				String query = "SELECT id, name, marca, quantity, color FROM estoque";
				PreparedStatement queryReady = database.connection.prepareStatement(query);
				ResultSet response = queryReady.executeQuery();
				
				initializeComponents();
				
				for(int i = 1; i <= response.getMetaData().getColumnCount(); i++) {
					
					gComponents.getTableModel().addColumn(response.getMetaData().getColumnName(i));
					
				}
				
				for(int i = 0; i < gComponents.getTable().getColumnCount(); i++) {
					
					gComponents.getTable().getColumnModel().getColumn(i).setCellRenderer(gComponents.newCellRenderer(SwingConstants.HORIZONTAL));
					gComponents.getTable().getColumnModel().getColumn(i).setResizable(true);
					gComponents.getTable().getColumnModel().getColumn(i).setPreferredWidth(100);
					gComponents.getTable().getColumnModel().getColumn(i).setMaxWidth(110);
					gComponents.getTable().getColumnModel().getColumn(i).setMinWidth(90);
					
				}
				
				
				while(response.next()) {
					
					String[] data = new String[response.getMetaData().getColumnCount()];
					
					for(int i = 1; i <= response.getMetaData().getColumnCount(); i++) {
						
						data[i - 1] = response.getString(i);
						
					}
					
					gComponents.getTableModel().addRow(data);
					
				}
				
				response.close();
				queryReady.close();
				database.close();
					
			}catch(SQLException error) {
				
			}
			
		}else {
			
			JOptionPane.showMessageDialog(null, "There was an error trying to connnect", "Connection", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}

}
