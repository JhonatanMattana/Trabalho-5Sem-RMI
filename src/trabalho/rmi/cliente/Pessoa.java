package trabalho.rmi.cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

public class Pessoa implements Serializable {
	private int id;
	private String nome;
	private BigDecimal saldoTotal;
	private Instant tempoSaque;
	private BigDecimal controlaSaque;

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

	public BigDecimal getSaldoTotal() {
		return saldoTotal;
	}

	public void setSaldoTotal(BigDecimal saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	public Instant getTempoSaque() {
		return tempoSaque;
	}

	public void setTempoSaque(Instant tempoSaque) {
		this.tempoSaque = tempoSaque;
	}

	public BigDecimal getControlaSaque() {
		return controlaSaque;
	}

	public void setControlaSaque(BigDecimal controlaSaque) {
		this.controlaSaque = controlaSaque;
	}

	@Override
	public boolean equals(Object obj) {
		Pessoa pessoa = (Pessoa) obj;
		return pessoa.getId() == id;
	}
}
