package trabalho.rmi.remotebase;

import java.rmi.Remote;
import java.rmi.RemoteException;

import trabalho.rmi.cliente.Pessoa;

public interface IRemoteCalculadora extends Remote {

	public double verifica(Pessoa pessoa) throws RemoteException;
	public void depositar(double valor, Pessoa pessoa) throws RemoteException;
	public String sacar(double valor, Pessoa pessoa) throws RemoteException;

}
