package trabalho.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import trabalho.rmi.cliente.Pessoa;
import trabalho.rmi.remotebase.IRemoteCalculadora;
import trabalho.rmi.server.Servidor;

public class Servidor implements IRemoteCalculadora {
	private int conexoes = 0;

	public static void main(String[] args) {
		try {
			System.out.println("Construindo Servidor de teste");

			Servidor servidor = new Servidor();

			// Porta do stub, se for 0, utiliza uma porta aleatoria.
			IRemoteCalculadora stub = (IRemoteCalculadora) UnicastRemoteObject.exportObject(servidor, 0);

			System.out.println("Registrando Servidor de teste de novo");

			// Liga o objeto remoto (stub) no registry
			Registry registry = LocateRegistry.getRegistry(8080);// porta do rmiregistry

			registry.bind("servidor_trabalho_5Sem", stub);

			System.out.println("Servidor iniciado de boa!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public double verifica(Pessoa pessoa) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void depositar(double valor, Pessoa pessoa) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String sacar(double valor, Pessoa pessoa) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}

