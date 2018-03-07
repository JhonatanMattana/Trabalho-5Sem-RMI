package trabalho.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import trabalho.rmi.remotebase.IRemoteCalculadora;
import trabalho.rmi.server.Servidor;

public class Servidor implements IRemoteCalculadora {
	private int conexoes = 0;

	public static void main(String[] args) {
		try {
			System.out.println("Construindo Servidor...");

			Servidor servidor = new Servidor();

			// Porta do stub, se for 0, utiliza uma porta aleatoria.
			IRemoteCalculadora stub = (IRemoteCalculadora) UnicastRemoteObject.exportObject(servidor, 0);

			System.out.println("Registrando Servidor...");

			// Liga o objeto remoto (stub) no registry
			Registry registry = LocateRegistry.getRegistry(8080);// porta do rmiregistry

			registry.bind("servidor_aula", stub);

			System.out.println("Servidor iniciado!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public double calcula(double num1, char operacao, double num2) throws RemoteException {
		conexoes++;
		System.out.println("Requisitando método calcula do Servidor: " + conexoes);

		double resultado = 0.0;
		switch (operacao) {
		case '+':
			resultado = num1 + num2;
			break;
		case '-':
			resultado = num1 - num2;
			break;
		case '*':
			resultado = num1 * num2;
			break;
		case '/':
			resultado = num1 / num2;
			break;

		}
		return resultado;
	}

}

