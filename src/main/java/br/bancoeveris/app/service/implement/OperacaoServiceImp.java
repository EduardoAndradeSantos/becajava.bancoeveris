package br.bancoeveris.app.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.model.Operacao;
import br.bancoeveris.app.repository.ContaRepository;
import br.bancoeveris.app.repository.OperacaoRepository;
import br.bancoeveris.app.request.OperacaoRequest;
import br.bancoeveris.app.request.TransferenciaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.service.OperacaoService;

@Service
public class OperacaoServiceImp implements OperacaoService {

	@Autowired
	private OperacaoRepository _repository;

	@Autowired
	private ContaRepository _contaRepository;

	// CALCULA O SALDO AO DAR GET CONTA
	public double saldo(Long contaId) {

		double saldo = 0;

		Conta contaOrigem = new Conta();
		contaOrigem.setId(contaId);

		Conta contaDestino = new Conta();
		contaDestino.setId(contaId);

		List<Operacao> lista = _repository.findOperacoesPorConta(contaId);

		for (Operacao o : lista) {
			switch (o.getTipo()) {
			case "D":
				saldo += o.getValor();
				break;
			case "S":
				saldo -= o.getValor();
				break;
			case "T":

				if (contaId == o.getContaOrigem().getId())
					saldo -= o.getValor();

				if (contaId == o.getContaDestino().getId())
					saldo += o.getValor();
				break;

			default:
				break;
			}
		}

		return saldo;
	}

	// OPERACAO SAQUE
	public BaseResponse criarSaque(OperacaoRequest operacaoRequest) {

		BaseResponse base = new BaseResponse();
		Operacao operacao = new Operacao();

		Conta conta = _contaRepository.findByHash(operacaoRequest.getHash());
		if (conta == null) {
			base.statusCode = 404;
			base.message = "Conta não encontrada";
			return base;
		}

		if (operacaoRequest.getValor() <= 0) {
			base.statusCode = 400;
			base.message = "Valor Inválido";
			return base;
		}

		operacao.setTipo("S");
		operacao.setValor(operacaoRequest.getValor());
		operacao.setContaOrigem(conta);

		_repository.save(operacao);
		base.message = "Operação Realizada";
		base.statusCode = 200;
		return base;
	}

	// OPERACAO DEPOSITO
	public BaseResponse criarDeposito(OperacaoRequest operacaoRequest) {

		BaseResponse base = new BaseResponse();
		Operacao operacao = new Operacao();

		Conta conta = _contaRepository.findByHash(operacaoRequest.getHash());
		if (conta == null) {
			base.statusCode = 404;
			base.message = "Conta não encontrada";
			return base;
		}
		
		if (operacaoRequest.getValor() <= 0) {
			base.statusCode = 400;
			base.message = "Valor não pode ser zero";
			return base;
		}

		operacao.setTipo("D");
		operacao.setValor(operacaoRequest.getValor());
		operacao.setContaDestino(conta);

		_repository.save(operacao);
		base.message = "Operação Realizada";
		base.statusCode = 200;
		return base;
	}

	// OPERACAO TRANSFERENCIA
	public BaseResponse transferencia(TransferenciaRequest transferenciaRequest) {

		BaseResponse base = new BaseResponse();
		Operacao operacao = new Operacao();

		Conta origem = _contaRepository.findByHash(transferenciaRequest.getHashOrigem());
		Conta destino = _contaRepository.findByHash(transferenciaRequest.getHashDestino());

		if (origem == null) {
			base.statusCode = 404;
			base.message = "Conta origem não encontrada";
			return base;
		}
		if (destino == null) {
			base.statusCode = 404;
			base.message = "Conta destino não encontrada";
			return base;
		}
		
		if (transferenciaRequest.getValor() <= 0) {
			base.statusCode = 400;
			base.message = "Valor não pode ser zero";
			return base;
		}
		

		operacao.setTipo("T");
		operacao.setContaOrigem(origem);
		operacao.setContaDestino(destino);
		operacao.setValor(transferenciaRequest.getValor());

		_repository.save(operacao);
		base.message = "Operação Realizada";
		base.statusCode = 200;
		return base;
	}
}