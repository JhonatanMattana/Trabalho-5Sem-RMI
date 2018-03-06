package trabalho.rmi.remotebase;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteCalculadora extends Remote {

	public double calcula(double num1, char operacao, double num2) throws RemoteException;

}
