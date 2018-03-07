package trabalho.rmi.cliente;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import trabalho.rmi.remotebase.IRemoteCalculadora;

public class Cliente1 {

	public static void main(String[] args) {
		try {
			System.out.println("Registrando-se no servidor de teste...");
			Registry registry = LocateRegistry.getRegistry(9876);// null == localhost

			// Recupera o objeto
			IRemoteCalculadora stub = (IRemoteCalculadora) registry.lookup("servidor_trabalho_5Sem");

			Pessoa pessoa = new Pessoa(1, "Maria Ambrosini");
			stub.depositar(new BigDecimal(1000), pessoa);
			System.out.println(stub.sacar(new BigDecimal(150), pessoa));

			System.out.println(pessoa.getNome() +": "+ stub.verifica(pessoa) +"\n \n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//rmiregistry (numPorta)