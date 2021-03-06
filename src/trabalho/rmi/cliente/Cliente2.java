package trabalho.rmi.cliente;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import trabalho.rmi.remotebase.IRemoteCalculadora;

public class Cliente2 {

	public static void main(String[] args) {
		try {
			System.out.println("Registrando-se no servidor de teste...");
			Registry registry = LocateRegistry.getRegistry(8080);// null == localhost

			// Recupera o objeto
			IRemoteCalculadora stub = (IRemoteCalculadora) registry.lookup("servidor_trabalho");

			Pessoa pessoa = new Pessoa(2, "Jo�o Ambrosini");
			stub.depositar(new BigDecimal(1000), pessoa);
			System.out.println(stub.sacar(new BigDecimal(500), pessoa));

			System.out.println(pessoa.getNome() + ": " + stub.verifica(pessoa) + "\n \n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
