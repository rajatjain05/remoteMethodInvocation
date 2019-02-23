package com.rmi.interfacecall;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

	public String userName(String name) throws RemoteException;

	public String currentDate() throws RemoteException;

	public String currentTime() throws RemoteException;

	public String companyDesc(String reply) throws RemoteException;
}