package br.bancoeveris.app.service;

import br.bancoeveris.app.request.OperacaoRequest;
import br.bancoeveris.app.request.TransferenciaRequest;
import br.bancoeveris.app.response.BaseResponse;

public interface OperacaoService {

	// CALCULA O SALDO AO DAR GET CONTA
	double saldo(Long contaId);

	// OPERACAO DE SAQUE
	BaseResponse criarSaque(OperacaoRequest operacaoRequest);

	// OPERACAO DE DEPOSITO
	BaseResponse criarDeposito(OperacaoRequest operacaoRequest);

	// OPERACAO DE TRANSFERENCIA
	BaseResponse transferencia(TransferenciaRequest transferenciaRequest);

}
