package com.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import com.rmi.interfacecall.RMIInterface;


public class ClientOperation {
	private static RMIInterface look_up;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
		String name = JOptionPane.showInputDialog("Please type your Name - ");

		String nameResp = look_up.userName(name);
		JOptionPane.showMessageDialog(null, nameResp);
		
		String dateResp = look_up.currentDate();
		JOptionPane.showMessageDialog(null, dateResp);
		
		String timeResp = look_up.currentTime();
		JOptionPane.showMessageDialog(null, timeResp);
		
		String company = JOptionPane.showInputDialog("Type (Yes) to know about your company : ");
		String compDesc = look_up.companyDesc(company);
		JOptionPane.showMessageDialog(null, compDesc);
		
	}
}
