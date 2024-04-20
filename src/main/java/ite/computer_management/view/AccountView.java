package ite.computer_management.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ite.computer_management.controller.AccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AccountView extends JPanel {

	private static final long serialVersionUID = 1L;
	public JTable table;
	public DefaultTableModel model;
	public JLabel addLbl;
	public JLabel deleteLbl;
	public JLabel editLbl;
	public JLabel exportExcelLbl;
	public AccountDAO accountDAO;

	/**
	 * Create the panel.
	 */
	public AccountView() {
		init();
		this.setVisible(true);
		
	}
	public void init(){
		AccountController accountController = new AccountController(this);
		accountDAO = new AccountDAO(this);
		
		this.setSize(1032,763);
		setLayout(null);
		addLbl = new JLabel("ADD");
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.setBounds(29, 26, 97, 33);
		addLbl.addMouseListener(accountController);
		add(addLbl);
		
		deleteLbl = new JLabel("DELETE");
		deleteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLbl.setBounds(157, 26, 97, 33);
		deleteLbl.addMouseListener(accountController);
		add(deleteLbl);
		
		editLbl = new JLabel("EDIT ");
		editLbl.setHorizontalAlignment(SwingConstants.CENTER);
		editLbl.setBounds(300, 26, 97, 33);
		editLbl.addMouseListener(accountController);
		add(editLbl);
		
		exportExcelLbl = new JLabel("EXPORT");
		exportExcelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		exportExcelLbl.setBounds(390, 26, 97, 33);
		exportExcelLbl.addMouseListener(accountController);
		add(exportExcelLbl);
		
		JLabel borderLbl = new JLabel("");
		borderLbl.setBounds(460, 10, 562, 87);
		Border border = BorderFactory.createLineBorder(Color.black);
		borderLbl.setBorder(border);
		add(borderLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 115, 966, 610);
		add(scrollPane);
		//Create table and fetch data from database
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		AccountDAO accountDAO = new AccountDAO(this);
		accountDAO.selectAll();
		
		scrollPane.setViewportView(table);
	}
	public void clickAddLbl() {
		new AddAccountView(this);
	}
	public void clickDeleteLbl() {
		int frontEndCheck = table.getSelectedRowCount();
		
		if(frontEndCheck <1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		}else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if(confirm ==0) {
				int selectedRowIndex = table.getSelectedRow();
				String fullName = (String) model.getValueAt(selectedRowIndex, 0);
				String userName = (String)model.getValueAt(selectedRowIndex, 1);
				Account account = new Account();
				account.setUserName(userName);
				//back-end
				int check = accountDAO.delete(account);
				if(check ==1) {
					//front-end
					model.removeRow(selectedRowIndex);
				}
			}
		}
		
	}
	public void clickEditLbl() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) {
			JOptionPane.showMessageDialog(null, "Please select row to edit.");
		}else {
			String fullName = (String) model.getValueAt(selectedRowIndex, 0);  // getValueAt: first Parameter is: 0
			String userName = (String) model.getValueAt(selectedRowIndex, 1);
			String password = (String) model.getValueAt(selectedRowIndex, 2);
			String role = (String) model.getValueAt(selectedRowIndex, 3);
			
			EditAccountView editAccountView = new EditAccountView(this);
			editAccountView.fullNameTxt.setText(fullName); 
			editAccountView.userNameTxt.setText(userName);
			editAccountView.passwordTxt.setText(password);
			editAccountView.roleTxt.setText(role);
			
		}
		
	}
	public void clickExportExcel() {
		try {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.showSaveDialog(this);
			File saveFile = jFileChooser.getSelectedFile();
			
			if(saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet("product");
				
				Row rowCol = sheet.createRow(0);
				for(int i=0; i<table.getColumnCount(); i++) {
					Cell cell = rowCol.createCell(i);
					cell.setCellValue(table.getColumnName(i));
				}
				for(int j=0; j<table.getRowCount(); j++) {
					Row row = sheet.createRow(j);
					for(int k=0; k<table.getColumnCount(); k++) {
						Cell cell = row.createCell(k);
						if(table.getValueAt(j, k) != null) {
							cell.setCellValue(table.getValueAt(j, k).toString());
						}
					}
				}
				FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
				wb.write(out);
				wb.close();
				out.close();
				}
			JOptionPane.showMessageDialog(null, "Export successfully ><");
			}catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, e);
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
}
}
