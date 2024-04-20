package ite.computer_management.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ite.computer_management.view.Dashboard;

public class DashboardController implements MouseListener {
	Dashboard dashboard;
	public DashboardController(Dashboard db) {
		dashboard = db;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == dashboard.productNavLbl) {
			dashboard.tabbedPane.setSelectedIndex(0);  // SetSelectedIndex bat dau tu para 0;
		}else if(e.getSource() == dashboard.userNavLbl) {
			dashboard.tabbedPane.setSelectedIndex(1);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
