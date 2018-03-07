package trabalho.rmi.server;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import trabalho.rmi.cliente.Pessoa;
import trabalho.rmi.remotebase.IRemoteCalculadora;
import trabalho.rmi.server.Servidor;

public class Servidor implements IRemoteCalculadora {
	private int conexoes = 0;
	List<Pessoa> pessoas = new LinkedList<Pessoa>();
	
	private final static BigDecimal valorMaximoPraSaque = new BigDecimal(500);
	
	public static void main(String[] args) {
		try {
			System.out.println("Construindo Servidor de teste");

			Servidor servidor = new Servidor();

			// Porta do stub, se for 0, utiliza uma porta aleatoria.
			IRemoteCalculadora stub = (IRemoteCalculadora) UnicastRemoteObject.exportObject(servidor, 0);

			System.out.println("Registrando Servidor de teste de novo");

			// Liga o objeto remoto (stub) no registry
			Registry registry = LocateRegistry.getRegistry(9876);// porta do rmiregistry

			registry.bind("servidor_trabalho_5Sem", stub);

			System.out.println("Servidor iniciado de boa!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BigDecimal verifica(Pessoa pessoa) throws RemoteException {
		pessoa = temPessoa(pessoa);
		return pessoa.getSaldoTotal();
	}

	@Override
	public void depositar(BigDecimal valor, Pessoa pessoa) throws RemoteException {
		pessoa = temPessoa(pessoa);
		pessoa.setSaldoTotal(pessoa.getSaldoTotal().add(valor));
	}

	@Override
	public String sacar(BigDecimal valor, Pessoa pessoa) throws RemoteException {
		pessoa = temPessoa(pessoa);
		return controlaSaque(valor, pessoa);
	}
//teste
	private String controlaSaque(BigDecimal valor, Pessoa pessoa) {
		if (pessoa.getTempoSaque() != null) {
			if (pessoa.getControlaSaque().add(valor).compareTo(valorMaximoPraSaque) > 0) {
				long minutosOnline = Duration.between(pessoa.getTempoSaque(), Instant.now()).toMinutes();
				if (minutosOnline > 2) {
					pessoa.setControlaSaque(BigDecimal.ZERO);
					return validaValor(valor, pessoa);
				}else {
					return "Você atingiu o limite maximo de saque no prazo de dois minutos... Favor, aguarde!";
				}
			}else {
				return validaValor(valor, pessoa);
			}
		}else {
			return validaValor(valor, pessoa);
		}
	}

	private String validaValor(BigDecimal valor, Pessoa pessoa) {
		if (valor.compareTo(valorMaximoPraSaque) <= 0) {
			if (pessoa.getSaldoTotal().compareTo(valor) < 0) {
				return "Valor maior que saldo disponivel na conta.";
			}
			return saqueNormal(valor, pessoa);
		}else {
			return "Valor maximo permitido por saque é de: R$ "+ valorMaximoPraSaque;
		}
	}

	private String saqueNormal(BigDecimal valor, Pessoa pessoa) {
		pessoa.setSaldoTotal(pessoa.getSaldoTotal().subtract(valor));
		pessoa.setTempoSaque(Instant.now());
		pessoa.setControlaSaque(pessoa.getControlaSaque().add(valor));
		return "Saque efetuado com sucesso!";
	}

	private Pessoa temPessoa(Pessoa pessoa) {
			if (pessoas.contains(pessoa)) {
				return pessoas.get(pessoas.indexOf(pessoa));
			}else {
				pessoas.add(pessoa);
				return pessoa;
			}
	}

	
}

