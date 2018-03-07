package trabalho.rmi.remotebase;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

import trabalho.rmi.cliente.Pessoa;

public interface IRemoteCalculadora extends Remote {

	public BigDecimal verifica(Pessoa pessoa) throws RemoteException;
	public void depositar(BigDecimal valor, Pessoa pessoa) throws RemoteException;
	public String sacar(BigDecimal valor, Pessoa pessoa) throws RemoteException;

}
