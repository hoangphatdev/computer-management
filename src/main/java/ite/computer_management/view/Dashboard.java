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
		navPanel.setBackground(new Color(217, 211, 210));
		navPanel.setLayout(null);
		
		productNavLbl = new JLabel("Product");
		productNavLbl.setFont(new Font("Lato", Font.BOLD, 15));
		productNavLbl.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-product-color\\icons8-product-30.png"));
		productNavLbl.setHorizontalAlignment(SwingConstants.CENTER);
		productNavLbl.setBounds(0, 140, 249, 30);
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
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-supplier-color\\icons8-supplier-30.png"));
		lblSupplier.setOpaque(true);
		lblSupplier.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupplier.setFont(new Font("Lato", Font.BOLD, 15));
		lblSupplier.setBackground( new Color(214, 205, 188) );
		lblSupplier.setBounds(0, 198, 249, 30);
		navPanel.add(lblSupplier);
		
		JLabel lblTatistical = new JLabel("Statistical");
		lblTatistical.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-analytics-30.png"));
		lblTatistical.setOpaque(true);
		lblTatistical.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatistical.setFont(new Font("Lato", Font.BOLD, 15));
		lblTatistical.setBackground(new Color(214, 205, 188) );
		lblTatistical.setBounds(0, 446, 249, 30);
		navPanel.add(lblTatistical);
		
		JLabel lblTatistical_1 = new JLabel("Import Product");
		lblTatistical_1.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-filled-outline\\icons8-import-goods-32.png"));
		lblTatistical_1.setOpaque(true);
		lblTatistical_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatistical_1.setFont(new Font("Lato", Font.BOLD, 15));
		lblTatistical_1.setBackground(new Color(214, 205, 188) );
		lblTatistical_1.setBounds(0, 311, 249, 30);
		navPanel.add(lblTatistical_1);
		
		JLabel lblTatistical_1_1 = new JLabel("Export Product");
		lblTatistical_1_1.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-import-goods-flat\\icons8-import-goods-32.png"));
		lblTatistical_1_1.setOpaque(true);
		lblTatistical_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatistical_1_1.setFont(new Font("Lato", Font.BOLD, 15));
		lblTatistical_1_1.setBackground(new Color(214, 205, 188));
		lblTatistical_1_1.setBounds(0, 254, 249, 30);
		navPanel.add(lblTatistical_1_1);
		
		JLabel lblTatistical_1_2 = new JLabel("Import Coupon");
		lblTatistical_1_2.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\icons8-note-30.png"));
		lblTatistical_1_2.setOpaque(true);
		lblTatistical_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatistical_1_2.setFont(new Font("Lato", Font.BOLD, 15));
		lblTatistical_1_2.setBackground(new Color(214, 205, 188));
		lblTatistical_1_2.setBounds(0, 380, 249, 30);
		navPanel.add(lblTatistical_1_2);
		
		JLabel lblTatistical_1_2_1 = new JLabel("Export Coupon");
		lblTatistical_1_2_1.setOpaque(true);
		lblTatistical_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTatistical_1_2_1.setFont(new Font("Lato", Font.BOLD, 15));
		lblTatistical_1_2_1.setBackground(new Color(214, 205, 188));
		lblTatistical_1_2_1.setBounds(0, 495, 249, 30);
		navPanel.add(lblTatistical_1_2_1);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, 0, 1032, 783);
		contentPane.add(tabbedPane);
		
		ProductView productView = new ProductView();
		tabbedPane.addTab("Product Management", productView);
		
		AccountView accountView = new AccountView();
		tabbedPane.addTab("Account Mangement", accountView);
		
		
	}
}

