package br.bancoeveris.app.service;

import br.bancoeveris.app.request.ContaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.response.ContaResponse;
import br.bancoeveris.app.response.ListContaResponse;

public interface ContaService {
	
	// POST - CRIAR e CRIAR HASH AUTOMATICAMENTE
	BaseResponse inserir(ContaRequest contaRequest);
	
	// GET - OBTER POR UM POR ID
	ContaResponse obter(Long id);
	
	// GET - OBTER TUDO
	ListContaResponse listar();
	
	// PUT - ATUALIZAR POR ID
	BaseResponse atualizar(Long id, ContaRequest contaRequest);
	
	// DELETE - DELETAR POR ID
//	BaseResponse deletar(Long id);
	
	// GET - EXIBE SALDO DE UMA CONTA HASH
	ContaResponse saldo(String hash);

}
