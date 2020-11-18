package br.bancoeveris.app.request;

import br.bancoeveris.app.response.BaseResponse;

import java.util.List;

import br.bancoeveris.app.model.*;

public class ListContaRequest extends BaseResponse {

	// PROPRIEDADES
	private List<Conta> Contas;

	// CONSTRUTOR
	public List<Conta> getContas() {
		return Contas;
	}

	// METODO
	public void setContas(List<Conta> contas) {
		Contas = contas;
	}
}