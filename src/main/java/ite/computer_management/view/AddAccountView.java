package ite.computer_management.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ite.computer_management.controller.AddAccountController;
import ite.computer_management.dao.AccountDAO;
import ite.computer_management.model.Account;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class AddAccountView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullNameTxt;
	private JTextField userNameTxt;
	private JTextField passwordTxt;
	private JTextField roleTxt;
	public JButton addBtn;
	public JButton cancelBtn;
	public JButton refreshBtn;
	public AccountView accountView;

	public AddAccountView(AccountView accountView, Dashboard dashboard) {
		this.accountView = accountView;
		init();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void init() {
		AddAccountController addAccountController = new AddAccountController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addBtn = new JButton("ADD");
		addBtn.setBounds(182, 568, 121, 37);
		addBtn.addMouseListener(addAccountController);
		contentPane.add(addBtn);
		
		cancelBtn = new JButton("CANCEL");
		cancelBtn.setBounds(406, 568, 121, 37);
		cancelBtn.addMouseListener(addAccountController);
		contentPane.add(cancelBtn);
		
		refreshBtn = new JButton("REFRESH");
		refreshBtn.setBounds(612, 568, 121, 37);
		refreshBtn.addMouseListener(addAccountController);
		contentPane.add(refreshBtn);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		fullNameLbl.setBounds(77, 52, 115, 29);
		contentPane.add(fullNameLbl);
		
		JLabel userNameLbl = new JLabel("User Name");
		userNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLbl.setBounds(274, 52, 115, 29);
		contentPane.add(userNameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLbl.setBounds(459, 52, 115, 29);
		contentPane.add(passwordLbl);
		
		JLabel roleLbl = new JLabel("Role");
		roleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		roleLbl.setBounds(684, 52, 115, 29);
		contentPane.add(roleLbl);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setBounds(55, 114, 179, 29);
		contentPane.add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(244, 114, 179, 29);
		contentPane.add(userNameTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(433, 114, 179, 29);
		contentPane.add(passwordTxt);
		
		roleTxt = new JTextField();
		roleTxt.setColumns(10);
		roleTxt.setBounds(648, 114, 179, 29);
		contentPane.add(roleTxt);
	}
	public void clickAddBtn() {
		String fullName = fullNameTxt.getText();
		String userName = userNameTxt.getText();
		String password = passwordTxt.getText();
		String role = roleTxt.getText();
		//back-end
		Account account = new Account(fullName, userName, password, role);
		int check = AccountDAO.getInstance().insert(account);
		if(check ==1) {
			//front-end
			String data[] = {fullName, userName, password, role};
			accountView.model.addRow(data);
		}
	}
	public void clickCancelBtn() {
		this.dispose();
	}
	public void clickRefreshBtn() {
		fullNameTxt.setText(null);
		userNameTxt.setText(null);
		passwordTxt.setText(null);
		roleTxt.setText(null);
	}
}
