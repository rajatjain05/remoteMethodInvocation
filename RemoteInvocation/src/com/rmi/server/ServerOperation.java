package com.rmi.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.rmi.interfacecall.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {
	private static final long serialVersionUID = 1L;

	protected ServerOperation() throws RemoteException {
		super();
	}
	
	@Override
	public String userName(String name) throws RemoteException {

		return "Hello Mr./Mrs. " + name + " , Nice to see you here!!";
	}
	
	@Override
	public String currentDate() throws RemoteException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		return " Current Date is - "+dtf.format(now);
	}
	
	@Override
	public String currentTime() throws RemoteException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return " Current Time is - "+dtf.format(now);
	}
	
	@Override
	public String companyDesc(String reply) throws RemoteException {

		String desc = "Description of your company";
		
		System.err.println("Description of company is - "+desc);

		return desc;
	}

	public static void main(String[] args) {
		try {
			Naming.rebind("//localhost/MyServer", new ServerOperation());
			System.err.println("Server ready");

		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
