package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.EditProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.math.BigDecimal;
import javax.swing.ImageIcon;

public class EditProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton cancelBtn;
	public  JButton updateBtn;
	
	//-----
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditProductView frame = new EditProductView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	private ProductView productView;
	public JTextField computerNameTxt;
	public JTextField cpuTxt;
	public JTextField priceTxt;
	public JTextField romTxt;
	public JTextField computerCodeTxt;
	public JTextField ramTxt;
	public JTextField sourceCapacityTxt;
	public JTextField screenSizeTxt;
	public JTextField quantityTxt;
	public JTextField screenCardTxt;
	public JTextField machineTypeTxt;
	public JTextField batteryCapacityTxt;
	public JTextField originTxt;
	public Dashboard dashboard;
	
	public EditProductView(ProductView productView, Dashboard dashboard) {
		this.productView = productView;
		this.dashboard = dashboard;
		init();
		
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	public void init() {
		EditProductController editProductController = new EditProductController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		updateBtn = new JButton("Save");
		updateBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\save 30.png"));
		updateBtn.setBounds(315, 529, 115, 41);
		updateBtn.addMouseListener(editProductController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\cancel 30.png"));
		cancelBtn.setBounds(629, 529, 115, 41);
		cancelBtn.addMouseListener(editProductController);
		contentPane.add(cancelBtn);
		
		JLabel computerNameLbl = new JLabel("Computer Name");
		computerNameLbl.setFont(new Font("Inter", Font.BOLD, 11));
		computerNameLbl.setOpaque(true);
		computerNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerNameLbl.setBounds(23, 287, 217, 41);
		computerNameLbl.setForeground(new Color(222, 173, 91));
		computerNameLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(computerNameLbl);
		
		JLabel cpuLbl = new JLabel("CPU");
		cpuLbl.setFont(new Font("Inter", Font.BOLD, 11));
		cpuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLbl.setBounds(776, 145, 217, 41);
		cpuLbl.setOpaque(true);
		cpuLbl.setBackground(new Color(54, 51, 46));
		cpuLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(cpuLbl);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setFont(new Font("Inter", Font.BOLD, 11));
		priceLbl.setOpaque(true);
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setBounds(527, 233, 217, 41);
		priceLbl.setForeground(new Color(222, 173, 91));
		priceLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(priceLbl);
		
		JLabel romLbl = new JLabel("Rom");
		romLbl.setFont(new Font("Inter", Font.BOLD, 11));
		romLbl.setOpaque(true);
		romLbl.setHorizontalAlignment(SwingConstants.CENTER);
		romLbl.setBounds(264, 323, 217, 41);
		romLbl.setForeground(new Color(222, 173, 91));
		romLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(romLbl);
		
		JLabel computerCodeLbl = new JLabel("Computer Code");
		computerCodeLbl.setFont(new Font("Inter", Font.BOLD, 11));
		computerCodeLbl.setOpaque(true);
		computerCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerCodeLbl.setBackground(new Color(54, 51, 46));
		computerCodeLbl.setForeground(new Color(222, 173, 91));
		computerCodeLbl.setBounds(264, 145, 217, 41);
		contentPane.add(computerCodeLbl);
		
		JLabel originLbl = new JLabel("Origin");
		originLbl.setFont(new Font("Inter", Font.BOLD, 11));
		originLbl.setOpaque(true);
		originLbl.setHorizontalAlignment(SwingConstants.CENTER);
		originLbl.setBounds(264, 414, 217, 41);
		originLbl.setForeground(new Color(222, 173, 91));
		originLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(originLbl);
		
		JLabel batteryCapacityLbl = new JLabel("Battery Capacity");
		batteryCapacityLbl.setFont(new Font("Inter", Font.BOLD, 11));
		batteryCapacityLbl.setOpaque(true);
		batteryCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		batteryCapacityLbl.setBounds(776, 322, 217, 41);
		batteryCapacityLbl.setBackground(new Color(54, 51, 46));
		batteryCapacityLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(batteryCapacityLbl);
		
		JLabel machineTypeLbl = new JLabel("Machine Type");
		machineTypeLbl.setFont(new Font("Inter", Font.BOLD, 11));
		machineTypeLbl.setOpaque(true);
		machineTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		machineTypeLbl.setBounds(776, 414, 217, 41);
		machineTypeLbl.setBackground(new Color(54, 51, 46));
		machineTypeLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(machineTypeLbl);
		
		JLabel screenCardLbl = new JLabel("Screen Card");
		screenCardLbl.setFont(new Font("Inter", Font.BOLD, 11));
		screenCardLbl.setOpaque(true);
		screenCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenCardLbl.setBounds(264, 234, 217, 41);
		screenCardLbl.setBackground(new Color(54, 51, 46));
		screenCardLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(screenCardLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setFont(new Font("Inter", Font.BOLD, 11));
		quantityLbl.setOpaque(true);
		quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLbl.setBounds(527, 145, 217, 41);
		quantityLbl.setBackground(new Color(54, 51, 46));
		quantityLbl.setForeground(new Color(222, 173, 91));
		contentPane.add(quantityLbl);
		
		JLabel screenSizeLbl = new JLabel("Screen Size");
		screenSizeLbl.setFont(new Font("Inter", Font.BOLD, 11));
		screenSizeLbl.setOpaque(true);
		screenSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenSizeLbl.setBounds(527, 326, 217, 41);
		screenSizeLbl.setForeground(new Color(222, 173, 91));
		screenSizeLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(screenSizeLbl);
		
		JLabel sourceCapacityLbl = new JLabel("Souce Capacity");
		sourceCapacityLbl.setFont(new Font("Inter", Font.BOLD, 11));
		sourceCapacityLbl.setOpaque(true);
		sourceCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sourceCapacityLbl.setBounds(776, 233, 217, 41);
		sourceCapacityLbl.setForeground(new Color(222, 173, 91));
		sourceCapacityLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(sourceCapacityLbl);
		
		JLabel ramLbl = new JLabel("RAM");
		ramLbl.setFont(new Font("Inter", Font.BOLD, 11));
		ramLbl.setOpaque(true);
		ramLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ramLbl.setBounds(527, 414, 217, 41);
		ramLbl.setForeground(new Color(222, 173, 91));
		ramLbl.setBackground(new Color(54, 51, 46));
		contentPane.add(ramLbl);

		computerCodeTxt = new JTextField();
		computerCodeTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		computerCodeTxt.setColumns(10);
		computerCodeTxt.setBounds(264, 183, 217, 41);
		contentPane.add(computerCodeTxt);
		
		computerNameTxt = new JTextField();
		computerNameTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		computerNameTxt.setColumns(10);
		computerNameTxt.setBounds(23, 329, 217, 41);
		contentPane.add(computerNameTxt);
		
		ramTxt = new JTextField();
		ramTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		ramTxt.setColumns(10);
		ramTxt.setBounds(527, 451, 217, 41);
		contentPane.add(ramTxt);
		
		cpuTxt = new JTextField();
		cpuTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		cpuTxt.setColumns(10);
		cpuTxt.setBounds(776, 182, 217, 41);
		contentPane.add(cpuTxt);
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		priceTxt.setColumns(10);
		priceTxt.setBounds(527, 271, 217, 41);
		contentPane.add(priceTxt);
		
		romTxt = new JTextField();
		romTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		romTxt.setColumns(10);
		romTxt.setBounds(264, 363, 217, 41);
		contentPane.add(romTxt);
		
		sourceCapacityTxt = new JTextField();
		sourceCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		sourceCapacityTxt.setColumns(10);
		sourceCapacityTxt.setBounds(776, 271, 217, 41);
		contentPane.add(sourceCapacityTxt);
		
		screenSizeTxt = new JTextField();
		screenSizeTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		screenSizeTxt.setColumns(10);
		screenSizeTxt.setBounds(527, 363, 217, 41);
		contentPane.add(screenSizeTxt);
		
		quantityTxt = new JTextField();
		quantityTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(527, 183, 217, 41);
		contentPane.add(quantityTxt);
		
		screenCardTxt = new JTextField();
		screenCardTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		screenCardTxt.setColumns(10);
		screenCardTxt.setBounds(264, 271, 217, 41);
		contentPane.add(screenCardTxt);
		
		machineTypeTxt = new JTextField();
		machineTypeTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		machineTypeTxt.setColumns(10);
		machineTypeTxt.setBounds(776, 455, 217, 41);
		contentPane.add(machineTypeTxt);
		batteryCapacityTxt = new JTextField();
		batteryCapacityTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		batteryCapacityTxt.setColumns(10);
		batteryCapacityTxt.setBounds(776, 363, 217, 41);
		contentPane.add(batteryCapacityTxt);
		
		originTxt = new JTextField();
		originTxt.setFont(new Font("Roboto", Font.PLAIN, 15));
		originTxt.setColumns(10);
		originTxt.setBounds(264, 456, 217, 41);
		contentPane.add(originTxt);
		
		JLabel titleLbl = new JLabel("EDIT COMPUTER");
		titleLbl.setFont(new Font("Bakery", Font.PLAIN, 27));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 1008, 112);
		titleLbl.setBackground(new Color(54, 51, 46));
		titleLbl.setForeground(new Color(222, 173, 91));
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
	}
	public void clickUpdateBtn() {
		int selectedRowIndex = this.productView.table.getSelectedRow();
		String conditionComputerCode = (String) this.productView.table.getValueAt(selectedRowIndex, 1);
		String screenCard = screenCardTxt.getText();
		String computerName = computerNameTxt.getText();
		String computerCode = computerCodeTxt.getText();
		String sourceCapacity = sourceCapacityTxt.getText();
		String cpuName = cpuTxt.getText();
		String ram = ramTxt.getText();
		String machineType = machineTypeTxt.getText();
		BigDecimal price = BigDecimal.valueOf( Long.parseLong(priceTxt.getText()) );
		
		System.out.println(price);
		int quantity = Integer.parseInt(quantityTxt.getText());
		String rom = romTxt.getText();
		String origin = originTxt.getText();
		Double screenSize = Double.parseDouble(screenSizeTxt.getText());
		String batteryCapacity = batteryCapacityTxt.getText();
		Computer com = new Computer(computerCode, computerName, quantity, cpuName, ram, screenCard, price, sourceCapacity, machineType, rom, screenSize,
				batteryCapacity, origin);
		//back-end
		int check = ProductDAO.getInstance().update(com, conditionComputerCode);
			//front-end
			productView.model.setValueAt(computerName, selectedRowIndex, 0);
			productView.model.setValueAt(computerCode, selectedRowIndex, 1);
			productView.model.setValueAt(quantity, selectedRowIndex, 2);
			productView.model.setValueAt(cpuName, selectedRowIndex, 3);
			productView.model.setValueAt(ram, selectedRowIndex, 4);
			productView.model.setValueAt(screenCard, selectedRowIndex, 5);
			productView.model.setValueAt(price, selectedRowIndex, 6);
			productView.model.setValueAt(sourceCapacity, selectedRowIndex, 7);
			productView.model.setValueAt(machineType, selectedRowIndex, 8);
			productView.model.setValueAt(rom, selectedRowIndex, 9);
			productView.model.setValueAt(screenSize, selectedRowIndex, 10);
			productView.model.setValueAt(batteryCapacity, selectedRowIndex, 11);
			productView.model.setValueAt(origin, selectedRowIndex, 12);
	
	}
	public void clickCancelBtn() {
		this.dispose();
		dashboard.setVisible(true);
	}
	
	
}
