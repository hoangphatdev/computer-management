package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddProductController;
import ite.computer_management.controller.ProductController;
import ite.computer_management.dao.ProductDAO;
import ite.computer_management.model.Computer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class AddProductView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField computerNameTxt;
	private JTextField computerCodeTxt;
	private JTextField cpuTxt;
	private JTextField ramTxt;
	private JTextField screenCardTxt;
	private JTextField screenSizeTxt;
	private JTextField priceTxt;
	private JTextField quantityTxt;
	private JLabel machineTypeLbl;
	private JTextField machineTypeTxt;
	private JLabel batteryCapacityLbl;
	private JTextField batteryCapacityTxt;
	private JLabel originLbl;
	private JTextField originTxt;
	private JTextField sourceCapacityTxt;
	private JTextField romTxt;
	public JLabel refreshLbl;
	public JLabel addLbl;
	public JLabel cancelLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductView frame = new AddProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddProductView() {
		AddProductController addProductController = new AddProductController(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLbl = new JLabel("ADD COMPUTER");
		titleLbl.setFont(new Font("Tahoma", Font.PLAIN, 21));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 1024, 139);
		titleLbl.setBackground(Color.gray);
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
		
		JLabel computerNameLbl = new JLabel("Computer Name");
		computerNameLbl.setBackground(Color.gray);
		computerNameLbl.setOpaque(true);
		computerNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerNameLbl.setBounds(27, 159, 217, 41);
		contentPane.add(computerNameLbl);
		
		JLabel computerCodeLbl = new JLabel("Computer Code");
		computerCodeLbl.setOpaque(true);
		computerCodeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		computerCodeLbl.setBackground(Color.gray);
		computerCodeLbl.setBounds(281, 162, 217, 41);
		contentPane.add(computerCodeLbl);
		
		JLabel cpuLbl = new JLabel("CPU");
		cpuLbl.setOpaque(true);
		cpuLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cpuLbl.setBackground(Color.gray);
		cpuLbl.setBounds(27, 262, 217, 41);
		contentPane.add(cpuLbl);
		
		JLabel ramLbl = new JLabel("RAM");
		ramLbl.setOpaque(true);
		ramLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ramLbl.setBackground(Color.gray);
		ramLbl.setBounds(281, 265, 217, 41);
		contentPane.add(ramLbl);
		
		JLabel screenCardLbl = new JLabel("Screen Card");
		screenCardLbl.setOpaque(true);
		screenCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenCardLbl.setBackground(Color.gray);
		screenCardLbl.setBounds(544, 265, 217, 41);
		contentPane.add(screenCardLbl);
		
		JLabel screenSizeLbl = new JLabel("Screen Size");
		screenSizeLbl.setOpaque(true);
		screenSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		screenSizeLbl.setBackground(Color.gray);
		screenSizeLbl.setBounds(281, 454, 217, 41);
		contentPane.add(screenSizeLbl);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setOpaque(true);
		priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		priceLbl.setBackground(Color.gray);
		priceLbl.setBounds(27, 362, 217, 41);
		contentPane.add(priceLbl);
		
		JLabel quantityLbl = new JLabel("Quantity");
		quantityLbl.setOpaque(true);
		quantityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLbl.setBackground(Color.gray);
		quantityLbl.setBounds(544, 162, 217, 41);
		contentPane.add(quantityLbl);
		
		computerNameTxt = new JTextField();
		computerNameTxt.setBounds(27, 201, 217, 41);
		contentPane.add(computerNameTxt);
		computerNameTxt.setColumns(10);
		
		computerCodeTxt = new JTextField();
		computerCodeTxt.setColumns(10);
		computerCodeTxt.setBounds(281, 204, 217, 41);
		contentPane.add(computerCodeTxt);
		
		cpuTxt = new JTextField();
		cpuTxt.setColumns(10);
		cpuTxt.setBounds(27, 299, 217, 41);
		contentPane.add(cpuTxt);
		
		ramTxt = new JTextField();
		ramTxt.setColumns(10);
		ramTxt.setBounds(281, 302, 217, 41);
		contentPane.add(ramTxt);
		
		screenCardTxt = new JTextField();
		screenCardTxt.setColumns(10);
		screenCardTxt.setBounds(544, 302, 217, 41);
		contentPane.add(screenCardTxt);
		
		screenSizeTxt = new JTextField();
		screenSizeTxt.setColumns(10);
		screenSizeTxt.setBounds(281, 492, 217, 41);
		contentPane.add(screenSizeTxt);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		priceTxt.setBounds(27, 400, 217, 41);
		contentPane.add(priceTxt);
		
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		quantityTxt.setBounds(544, 200, 217, 41);
		contentPane.add(quantityTxt);
		
		machineTypeLbl = new JLabel("Machine Type");
		machineTypeLbl.setOpaque(true);
		machineTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		machineTypeLbl.setBackground(Color.GRAY);
		machineTypeLbl.setBounds(544, 359, 217, 41);
		contentPane.add(machineTypeLbl);
		
		machineTypeTxt = new JTextField();
		machineTypeTxt.setColumns(10);
		machineTypeTxt.setBounds(544, 400, 217, 41);
		contentPane.add(machineTypeTxt);
		
		batteryCapacityLbl = new JLabel("Battery Capacity");
		batteryCapacityLbl.setOpaque(true);
		batteryCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		batteryCapacityLbl.setBackground(Color.GRAY);
		batteryCapacityLbl.setBounds(544, 454, 217, 41);
		contentPane.add(batteryCapacityLbl);
		
		batteryCapacityTxt = new JTextField();
		batteryCapacityTxt.setColumns(10);
		batteryCapacityTxt.setBounds(544, 495, 217, 41);
		contentPane.add(batteryCapacityTxt);
		
		originLbl = new JLabel("Origin");
		originLbl.setOpaque(true);
		originLbl.setHorizontalAlignment(SwingConstants.CENTER);
		originLbl.setBackground(Color.GRAY);
		originLbl.setBounds(793, 321, 217, 41);
		contentPane.add(originLbl);
		
		originTxt = new JTextField();
		originTxt.setColumns(10);
		originTxt.setBounds(793, 362, 217, 41);
		contentPane.add(originTxt);
		
		addLbl = new JLabel("ADD PRODUCT");
		addLbl.setBackground(Color.GREEN);
		addLbl.setOpaque(true);
		addLbl.setForeground(Color.white);
		addLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addLbl.setBounds(281, 569, 141, 41);
		addLbl.addMouseListener(addProductController);
		contentPane.add(addLbl);
		
		cancelLbl = new JLabel("Cancel");
		cancelLbl.setBackground(Color.red);
		cancelLbl.setOpaque(true);
		cancelLbl.setForeground(Color.white);
		cancelLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cancelLbl.setBounds(557, 569, 141, 41);
		cancelLbl.addMouseListener(addProductController);
		contentPane.add(cancelLbl);
		
		sourceCapacityTxt = new JTextField();
		sourceCapacityTxt.setColumns(10);
		sourceCapacityTxt.setBounds(281, 403, 217, 41);
		contentPane.add(sourceCapacityTxt);
		
		JLabel sourceCapacityLbl = new JLabel("Souce Capacity");
		sourceCapacityLbl.setOpaque(true);
		sourceCapacityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sourceCapacityLbl.setBackground(Color.GRAY);
		sourceCapacityLbl.setBounds(281, 365, 217, 41);
		contentPane.add(sourceCapacityLbl);
		
		JLabel romLbl = new JLabel("Rom");
		romLbl.setOpaque(true);
		romLbl.setHorizontalAlignment(SwingConstants.CENTER);
		romLbl.setBackground(Color.GRAY);
		romLbl.setBounds(27, 451, 217, 41);
		contentPane.add(romLbl);
		
		romTxt = new JTextField();
		romTxt.setColumns(10);
		romTxt.setBounds(27, 491, 217, 41);
		contentPane.add(romTxt);
		
		refreshLbl = new JLabel("REFRESH");
		refreshLbl.setOpaque(true);
		refreshLbl.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLbl.setForeground(Color.WHITE);
		refreshLbl.setBackground(Color.GREEN);
		refreshLbl.setBounds(837, 201, 141, 41);
		contentPane.add(refreshLbl);
		
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		setVisible(true);
	}
	
	public void clickAddLbl() {
		String screenCard = screenCardTxt.getText();
		String computerName = computerNameTxt.getText();
		String computerCode = computerCodeTxt.getText();
		String sourceCapacity = sourceCapacityTxt.getText();
		String cpuName = cpuTxt.getText();
		String ram = ramTxt.getText();
		String machineType = machineTypeTxt.getText();
		Double price = Double.parseDouble( priceTxt.getText());
		int quantity = Integer.parseInt(quantityTxt.getText());
		String rom = romTxt.getText();
		String origin = originTxt.getText();
		Double screenSize = Double.parseDouble(screenSizeTxt.getText());
		String batteryCapacity = batteryCapacityTxt.getText();
		Computer com = new Computer(computerCode, computerName, quantity, cpuName, ram, screenCard, price, sourceCapacity, machineType, rom, screenSize,
				batteryCapacity, origin);
		//back-end
		ProductDAO.getInstance().insert(com);
		//front-end
		String[] rowData = {computerCode, computerName, String.valueOf(quantity), cpuName, ram, screenCard, String.valueOf(price), sourceCapacity, machineType, rom,
				String.valueOf(screenSize),	batteryCapacity, origin};
		ProductView.model.addRow(rowData);
	}
	public void clickCancelLbl() {
		this.dispose();
	}
	public void clickRefreshLbl() {
		computerNameTxt.setText(null);
		computerCodeTxt.setText(null);
		quantityTxt.setText(null);
		cpuTxt.setText(null);
		ramTxt.setText(null);
		screenCardTxt.setText(null);
		priceTxt.setText(null);
		sourceCapacityTxt.setText(null);
		machineTypeTxt.setText(null);
		romTxt.setText(null);
		screenSizeTxt.setText(null);
		batteryCapacityTxt.setText(null);
		originTxt.setText(null);
	}
}


