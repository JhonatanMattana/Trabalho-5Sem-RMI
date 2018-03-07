package trabalho.rmi.cliente;

public class Pessoa{
	private int id;
	private String nome;
	private int saldoTotal;
	private int tempoSaque;
	private int controlaSaque;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(int saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public int getTempoSaque() {
		return tempoSaque;
	}
	public void setTempoSaque(int tempoSaque) {
		this.tempoSaque = tempoSaque;
	}
	public int getControlaSaque() {
		return controlaSaque;
	}
	public void setControlaSaque(int controlaSaque) {
		this.controlaSaque = controlaSaque;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pessoa pessoa = (Pessoa) obj;
		return pessoa.getId() == id;
	}
}
