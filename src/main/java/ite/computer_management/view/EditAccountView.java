package ite.computer_management.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.EditAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EditAccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField fullNameTxt;
	public JTextField userNameTxt;
	public JTextField passwordTxt;
	public JTextField roleTxt;
	public JButton updateBtn;
	public JButton refreshBtn;
	public JButton cancelBtn;
	public AccountView accountView;
	public Dashboard dashboard;
	private JLabel titleLbl;

	public EditAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		this.dashboard  = dashboard;
		init();
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	public void init() {
		EditAccountController editAccountController = new EditAccountController(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLbl.setFont(new Font("Inter", Font.BOLD, 12));
		fullNameLbl.setBounds(57, 141, 131, 40);
		fullNameLbl.setBackground(new Color(54, 51, 46));
		fullNameLbl.setForeground(new Color(222, 173, 91));
		fullNameLbl.setOpaque(true);
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setFont(new Font("Inter", Font.BOLD, 12));
		userNameLbl.setBounds(57, 208, 131, 40);
		userNameLbl.setBackground(new Color(54, 51, 46));
		userNameLbl.setForeground(new Color(222, 173, 91));
		userNameLbl.setOpaque(true);
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setFont(new Font("Inter", Font.BOLD, 12));
		passwordLbl.setBounds(57, 273, 131, 40);
		passwordLbl.setBackground(new Color(54, 51, 46));
		passwordLbl.setForeground(new Color(222, 173, 91));
		passwordLbl.setOpaque(true);
		contentPane.add(passwordLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		roleLbl.setFont(new Font("Inter", Font.BOLD, 12));
		roleLbl.setBounds(57, 339, 131, 40);
		roleLbl.setBackground(new Color(54, 51, 46));
		roleLbl.setForeground(new Color(222, 173, 91));
		roleLbl.setOpaque(true);
		contentPane.add(roleLbl);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setFont(new Font("Poppins", Font.PLAIN, 13));
		fullNameTxt.setBounds(189, 142, 295, 40);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("Poppins", Font.PLAIN, 13));
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(189, 209, 295, 40);
		contentPane.add(userNameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setFont(new Font("Poppins", Font.PLAIN, 13));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(189, 274, 295, 40);
		contentPane.add(passwordTxt);
		
		roleTxt = new JTextField();
		roleTxt.setFont(new Font("Poppins", Font.PLAIN, 13));
		roleTxt.setColumns(10);
		roleTxt.setBounds(189, 340, 295, 40);
		contentPane.add(roleTxt);
		
		updateBtn = new JButton("UPDATE");
		updateBtn.setFont(new Font("Roboto", Font.BOLD, 10));
		updateBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\save 20.png"));
		updateBtn.setBounds(245, 421, 110, 30);
		updateBtn.addMouseListener(editAccountController);
		contentPane.add(updateBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setFont(new Font("Roboto", Font.BOLD, 10));
		cancelBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\cancel 20.png"));
		cancelBtn.setBounds(35, 421, 110, 30);
		cancelBtn.addMouseListener(editAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setFont(new Font("Roboto", Font.BOLD, 10));
		refreshBtn.setIcon(new ImageIcon("C:\\Users\\latru\\Desktop\\computer_management\\src\\main\\java\\ite\\computer_management\\img\\reload 20.png"));
		refreshBtn.setBounds(451, 421, 110, 30);
		refreshBtn.addMouseListener(editAccountController);
		contentPane.add(refreshBtn);
		
		titleLbl = new JLabel("EDIT ACCOUNT");
		titleLbl.setFont(new Font("Bakery", Font.PLAIN, 29));
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setBounds(0, 0, 630, 112);
		titleLbl.setBackground(new Color(54, 51, 46));
		titleLbl.setForeground(new Color(222, 173, 91));
		titleLbl.setOpaque(true);
		contentPane.add(titleLbl);
	}

	public void clickUpdateBtn() {
		String fullName =fullNameTxt.getText();
		String userName = userNameTxt.getText();
		String password = passwordTxt.getText();
		String role = roleTxt.getText();
		Account account = new Account(fullName, userName, password, role);
		
		int selectedRowIndex =  accountView.table.getSelectedRow();
		String userNameCondition = (String) accountView.model.getValueAt(selectedRowIndex, 1);
		//back-end
		int check = AccountDAO.getInstance().update(account, userNameCondition);
		
			//front-end
			accountView.model.setValueAt(fullName, selectedRowIndex, 0);
			accountView.model.setValueAt(userName, selectedRowIndex, 1);
			accountView.model.setValueAt(password, selectedRowIndex, 2);
			accountView.model.setValueAt(role, selectedRowIndex, 3);
		
		
	}

	public void clickCancelBtn() {
		this.dispose();
		dashboard.setVisible(true);
	}

	public void clickRefreshBtn() {
		fullNameTxt.setText(null);
		userNameTxt.setText(null);
		passwordTxt.setText(null);
		roleTxt.setText(null);
		
	}

}
