package ite.computer_management.view;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JPanel; 

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.print.PageFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProductView extends JPanel {
	public JLabel seeDetailLbl;
	public JLabel deleteLbl;
	public JLabel editLbl;
	public JLabel addLbl;
	public static DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	public static JTable table;
	public JTextField searchTxt;
	public JButton excelBtn;
	
	public ProductView() {
		ProductController productController = new ProductController(this);
		this.setSize(1032,763);
		setLayout(null);
		
		addLbl = new JLabel("ADD ");
		addLbl.setBounds(39, 10, 86, 40);
		addLbl.setBackground(Color.blue);
		addLbl.setOpaque(true);
		addLbl.setForeground(Color.white);
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.addMouseListener(productController);
		add(addLbl);
		
		deleteLbl = new JLabel("DELETE");
		deleteLbl.setOpaque(true);
		deleteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		deleteLbl.setForeground(Color.WHITE);
		deleteLbl.setBackground(Color.BLUE);
		deleteLbl.setBounds(169, 10, 86, 40);
		deleteLbl.addMouseListener(productController);
		add(deleteLbl);
		
		editLbl = new JLabel("EDIT");
		editLbl.setOpaque(true);
		editLbl.setHorizontalAlignment(SwingConstants.CENTER);
		editLbl.setForeground(Color.WHITE);
		editLbl.setBackground(Color.BLUE);
		editLbl.setBounds(298, 10, 86, 40);
		editLbl.addMouseListener(productController);
		add(editLbl);
		
		seeDetailLbl = new JLabel("SEE DETAIL");
		seeDetailLbl.setOpaque(true);
		seeDetailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		seeDetailLbl.setForeground(Color.WHITE);
		seeDetailLbl.setBackground(Color.BLUE);
		seeDetailLbl.setBounds(426, 10, 86, 40);
		seeDetailLbl.addMouseListener(productController);
		add(seeDetailLbl);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 61, 1012, 671);
		add(scrollPane);
		//create table and fetch data from database
		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		ProductDAO productDAO = new ProductDAO(this);
		productDAO.selectAll();
		scrollPane.setViewportView(table);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(productController);
		searchTxt.setBounds(712, 11, 190, 39);
		add(searchTxt);
		searchTxt.setColumns(10);
		
		JLabel searchLbl = new JLabel("Search here:");
		searchLbl.setFont(new Font("Roboto", Font.BOLD, 12));
		searchLbl.setBounds(616, 10, 86, 40);
		add(searchLbl);
		
		excelBtn = new JButton("Excel");
		excelBtn.setBounds(938, 4, 64, 52);
		excelBtn.addMouseListener(productController);
		add(excelBtn);
		
	}
	public void clickAddLbl() {
		new AddProductView(this);
	}
	public void clickDeleteLbl() {
		int check = table.getSelectedRowCount();
		int selectedRow = table.getSelectedRow();
		
		if(check <1) {
			JOptionPane.showMessageDialog(null, "Please select row to delete.");
		}else {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?"); // yes:0, no:1
			if(confirm == 0) {
				String computerCode =  model.getValueAt(selectedRow, 1).toString(); // index cua gelValuAt bat dau tu 0
				String computerName = model.getValueAt(selectedRow,0).toString();
				Computer deleteProduct = new Computer();
				deleteProduct.setComputerCode(computerCode);
				int result = ProductDAO.getInstance().delete(deleteProduct);
				System.out.println(result);
				if(result == 1) {
					model.removeRow(selectedRow);
				}
			}
			
		}
	}
	public void clickSearchBtn() {
		DefaultTableModel demo = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(demo);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
	}
//	public void openFile(String file) {
//		try {
//			File path = new File(file);
//			Desktop.getDesktop().open(path);
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(null,"Error: " + e);
//		}
//		
//	}
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
	public void clickEditBtn() {
		int check = table.getSelectedRowCount();
		int selectedRowIndex = table.getSelectedRow();
		if(check <1) { 
			JOptionPane.showMessageDialog(null, "Please select row to edit >< ");
		}else {
			EditProductView editProductView = new EditProductView(this);
			editProductView.computerNameTxt.setText( (String)model.getValueAt(selectedRowIndex,0) );
			editProductView.computerCodeTxt.setText( (String)model.getValueAt(selectedRowIndex, 1) );
			editProductView.quantityTxt.setText( (String)model.getValueAt(selectedRowIndex, 2) );
			editProductView.cpuTxt.setText( (String)model.getValueAt(selectedRowIndex, 3) );
			editProductView.ramTxt.setText( (String)model.getValueAt(selectedRowIndex, 4) );
			editProductView.screenCardTxt.setText( (String)model.getValueAt(selectedRowIndex, 5) );
			editProductView.priceTxt.setText( (String)model.getValueAt(selectedRowIndex, 6) );
			editProductView.sourceCapacityTxt.setText( (String)model.getValueAt(selectedRowIndex, 7) );
			editProductView.machineTypeTxt.setText( (String)model.getValueAt(selectedRowIndex, 8) );
			editProductView.romTxt.setText( (String)model.getValueAt(selectedRowIndex, 9) );
			editProductView.screenSizeTxt.setText( (String)model.getValueAt(selectedRowIndex, 10) );
			editProductView.batteryCapacityTxt.setText( (String)model.getValueAt( selectedRowIndex, 11 ) );
			editProductView.originTxt.setText( (String)model.getValueAt(selectedRowIndex, 12) );
			
		}
		
	}
	
	
	
}

