package ite.computer_management.view;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.DashboardController;
import ite.computer_management.controller.ProductController;

import java.awt.Color; 
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;


public class Dashboard extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel productNavLbl;
	public JLabel userNavLbl;
	public JTabbedPane tabbedPane;

	public Dashboard() {
		DashboardController dashboardController = new DashboardController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel navPanel = new JPanel();
		navPanel.setBounds(0, 0, 249, 763);
		contentPane.add(navPanel);
		navPanel.setBackground(Color.black);
		navPanel.setLayout(null);
		
		productNavLbl = new JLabel("Product");
		productNavLbl.setBounds(33, 140, 189, 27);
		productNavLbl.setBackground(Color.green);
		productNavLbl.setOpaque(true);
		productNavLbl.addMouseListener(dashboardController);
		navPanel.add(productNavLbl);
		
		userNavLbl = new JLabel("User");
		userNavLbl.setOpaque(true);
		userNavLbl.setBackground(Color.GREEN);
		userNavLbl.setBounds(33, 201, 189, 27);
		userNavLbl.addMouseListener(dashboardController);
		navPanel.add(userNavLbl);
		
		JLabel greetingLbl = new JLabel("Hello ......");
		greetingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLbl.setBounds(0, 0, 249, 110);
		greetingLbl.setBackground(Color.white);
		greetingLbl.setOpaque(true);
		greetingLbl.setForeground(Color.black);
		navPanel.add(greetingLbl);
		
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(254, 0, 1032, 783);
		contentPane.add(tabbedPane);
		
		ProductView productView = new ProductView();
		tabbedPane.addTab("Product Management", productView);
		
		AccountView accountView = new AccountView();
		tabbedPane.addTab("Account Mangement", accountView);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}

