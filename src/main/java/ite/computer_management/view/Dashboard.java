package ite.computer_management.view;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.DashboardController;
import ite.computer_management.controller.ProductController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import java.awt.Font;


public class Dashboard extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel productNavLbl;
	public JTabbedPane tabbedPane;
	public JLabel accountNavLbl;
	public JLabel userNavLbl;
	public JLabel logOutNavLbl;
	public JLabel exportCouponNavLbl;
	public JLabel importCouponNavLbl;
	public JLabel exportProductNavLbl;
	public JLabel importProductNavLbl;
	public JLabel statisticalNavLbl;
	public JLabel supplierNavLbl;


	public Dashboard() {
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void init() {
		DashboardController dashboardController = new DashboardController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 800);
//		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navPanel = new JPanel();
		navPanel.setBounds(10, 0, 250, 763);
		contentPane.add(navPanel);
		navPanel.setBackground( new Color(230, 213, 211) );
		navPanel.setLayout(null);
		
		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-product-color\\icons8-product-30.png"));
		productNavLbl.setBounds(0, 120, 249, 30);
		productNavLbl.setBackground(new Color(214, 205, 188) );
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardController);
		navPanel.add(productNavLbl);
		
		JLabel greetingLbl = new JLabel("Hello ......");
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(0, 0, 249, 110);
		greetingLbl.setBackground(Color.white);
		greetingLbl.setOpaque(true);
		greetingLbl.setForeground(Color.black);
		navPanel.add(greetingLbl);
		
		supplierNavLbl = new JLabel("Supplier");
		supplierNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-supplier-color\\icons8-supplier-30.png"));
		supplierNavLbl.setOpaque(true);
		supplierNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		supplierNavLbl.setBackground( new Color(214, 205, 188) );
		supplierNavLbl.setBounds(0, 160, 249, 30);
		supplierNavLbl.addMouseListener(dashboardController);
		navPanel.add(supplierNavLbl);
		
		 statisticalNavLbl = new JLabel("Statistical");
		statisticalNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-analytics-30.png"));
		statisticalNavLbl.setOpaque(true);
		statisticalNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		statisticalNavLbl.setBackground(new Color(214, 205, 188) );
		statisticalNavLbl.setBounds(0, 400, 249, 30);
		statisticalNavLbl.addMouseListener(dashboardController);
		navPanel.add(statisticalNavLbl);
		
		 importProductNavLbl = new JLabel("Import Product");
		importProductNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		importProductNavLbl.setOpaque(true);
		importProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importProductNavLbl.setBackground(new Color(214, 205, 188) );
		importProductNavLbl.setBounds(0, 200, 249, 30);
		importProductNavLbl.addMouseListener(dashboardController);
		navPanel.add(importProductNavLbl);
		
		 exportProductNavLbl = new JLabel("Export Product");
		exportProductNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-flat\\icons8-import-goods-32.png"));
		exportProductNavLbl.setOpaque(true);
		exportProductNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportProductNavLbl.setBackground(new Color(214, 205, 188));
		exportProductNavLbl.setBounds(0, 280, 249, 30);
		exportProductNavLbl.addMouseListener(dashboardController);
		navPanel.add(exportProductNavLbl);
		
		importCouponNavLbl = new JLabel("Import Coupon");
		importCouponNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		importCouponNavLbl.setOpaque(true);
		importCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		importCouponNavLbl.setBackground(new Color(214, 205, 188));
		importCouponNavLbl.setBounds(0, 240, 249, 30);
		importCouponNavLbl.addMouseListener(dashboardController);
		navPanel.add(importCouponNavLbl);
		
		exportCouponNavLbl = new JLabel("Export Coupon");
		exportCouponNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		exportCouponNavLbl.setOpaque(true);
		exportCouponNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		exportCouponNavLbl.setBackground(new Color(214, 205, 188));
		exportCouponNavLbl.setBounds(0, 320, 249, 30);
		exportCouponNavLbl.addMouseListener(dashboardController);
		navPanel.add(exportCouponNavLbl);
		
		accountNavLbl = new JLabel("Account");
		accountNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\account management orange\\icons8-management-30.png"));
		accountNavLbl.setOpaque(true);
		accountNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		accountNavLbl.setBackground(new Color(214, 205, 188));
		accountNavLbl.setBounds(0, 360, 249, 30);
		accountNavLbl.addMouseListener(dashboardController);
		navPanel.add(accountNavLbl);
		
		userNavLbl = new JLabel("User");
		userNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-user-office-m\\icons8-user-30.png"));
		userNavLbl.setOpaque(true);
		userNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		userNavLbl.setBackground(new Color(214, 205, 188));
		userNavLbl.setBounds(0, 667, 249, 30);
		userNavLbl.addMouseListener(dashboardController);
		navPanel.add(userNavLbl);
		
		logOutNavLbl = new JLabel("Log out");
		logOutNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\log out\\icons8-log-out-32.png"));
		logOutNavLbl.setOpaque(true);
		logOutNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		logOutNavLbl.setBackground(new Color(214, 205, 188));
		logOutNavLbl.setBounds(0, 707, 249, 30);
		logOutNavLbl.addMouseListener(dashboardController);
		navPanel.add(logOutNavLbl);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, 0, 1032, 783);
		contentPane.add(tabbedPane);
		
		ProductView productView = new ProductView();
		tabbedPane.addTab("Product Management", productView);
		
		AccountView accountView = new AccountView();
		tabbedPane.addTab("Account Mangement", accountView);
		
		
	}
}

