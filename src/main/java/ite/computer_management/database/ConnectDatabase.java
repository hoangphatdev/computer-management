package ite.computer_management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectDatabase {
	public static ConnectDatabase getInstance() {
		return new ConnectDatabase();
	}
	public static Connection getConnection(){
		Connection connect = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/?user=root"; 
		String name = "root";
		String password = "051205";
		
		try {
			connect = DriverManager.getConnection(url,name,password);
//			java.sql.Statement st = connect.createStatement();
//			String sql = "use coffemanagementsystem";
//		     st.executeUpdate(sql);
 
		} catch (Exception e) {
			
		JOptionPane.showMessageDialog(null, "Database Connection Error: " + e);
			}	
		
		return connect;
	}
	public static void  closeConnection(Connection connect) {
		if(connect != null) {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
				
			}
		}
	};
	
}