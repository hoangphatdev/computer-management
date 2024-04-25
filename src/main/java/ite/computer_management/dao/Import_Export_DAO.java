package ite.computer_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ite.computer_management.database.ConnectDatabase;
import ite.computer_management.model.Computer;
import ite.computer_management.view.ExportProductView;
import ite.computer_management.view.ImportsProductView;

public class Import_Export_DAO implements DAOInterface<Computer> {
	 private ImportsProductView ImportsView;
	 private ExportProductView DeliveryView;
	 public Import_Export_DAO(ImportsProductView IPV) {
		 ImportsView = IPV;
	   }

	   public static Import_Export_DAO getInstance() {
	      return new Import_Export_DAO();
	   }
	   
	   public Import_Export_DAO() {};
	public Import_Export_DAO(ExportProductView DPV) {
		DeliveryView = DPV;
	}

	@Override
	public int insert(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Computer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Computer> selectAll() {
		return null;
	}

	@Override
	public Computer selectById(Computer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Computer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Computer t, String condition) {
		
		return 0;
	}
	
	public void display(JTable table) {
		 try {
		        ConnectDatabase.getInstance();
				Connection connection = ConnectDatabase.getConnection();

		        String sql = "SELECT computer_Code, computer_Name, quantity, price FROM computer";
		        try (PreparedStatement p = connection.prepareStatement(sql)) {
		            try (ResultSet re = p.executeQuery()) {
		                DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		                model_table.setRowCount(0);	
		                int stt =1;
		                while (re.next()) {
		                    Object[] row = new Object[]{
		                    		stt++,
		                            re.getString("computer_Code"),
		                            re.getString("computer_Name"),                     
		                            re.getString("quantity"),
		                            re.getString("price"),                   
		                    };
		                    model_table.addRow(row);
		                }
		            }
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } 	
	}
	
	
}
