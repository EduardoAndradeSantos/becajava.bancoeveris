package br.bancoeveris.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Operacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "ContaOrigemId")
	private Conta contaOrigem;

	@ManyToOne
	@JoinColumn(name = "ContaDestinoId")
	private Conta contaDestino;
	
	public Operacao() {}
	
	public Operacao(String tipo, Double valor, Conta contaOrigem, Conta contaDestino) {
		this.tipo = tipo;
		this.valor = valor;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

}
