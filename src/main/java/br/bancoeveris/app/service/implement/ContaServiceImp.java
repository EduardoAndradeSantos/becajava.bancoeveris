package br.bancoeveris.app.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.repository.ContaRepository;
import br.bancoeveris.app.request.ContaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.response.ContaResponse;
import br.bancoeveris.app.response.ListContaResponse;
import br.bancoeveris.app.service.ContaService;

@Service
public class ContaServiceImp implements ContaService{

	@Autowired
	private ContaRepository _repository;

	@Autowired
	private OperacaoServiceImp _operacaoService;

	// POST - CRIAR CONTA e CRIAR HASH AUTOMATICAMENTE
	public BaseResponse inserir(ContaRequest contaRequest) {
		Conta conta = new Conta();
		ContaResponse contaResponse = new ContaResponse();
		contaResponse.statusCode = 400;

		if (contaRequest.getNome() == null || contaRequest.getNome() == "") {
			contaResponse.message = "O Nome do cliente não foi preenchido.";
			return contaResponse;
		}

		UUID uuid = UUID.randomUUID();

		conta.setHash(uuid.toString());
		conta.setNome(contaRequest.getNome());

		_repository.save(conta);

		contaResponse.statusCode = 201;
		contaResponse.message = "Hash Gerado automaticamente na Conta criada!!";
		contaResponse.setHash(conta.getHash());
		contaResponse.setNome(conta.getNome());
		contaResponse.setId(conta.getId());

		return contaResponse;
	}

	// GET - OBTER CONTA POR UM POR ID
	public ContaResponse obter(Long id) {
		Optional<Conta> conta = _repository.findById(id);

		ContaResponse response = new ContaResponse();

		if (conta.isEmpty() || id <= 0) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setHash(conta.get().getHash());
		response.setNome(conta.get().getNome());
		response.setId(conta.get().getId());
		response.statusCode = 200;
		response.message = "Conta obtida com sucesso.";
		return response;
	}

	// GET - OBTER TODAS AS CONTAS
	public ListContaResponse listar() {

		List<Conta> lista = _repository.findAll();

		ListContaResponse response = new ListContaResponse();
		response.setContas(lista);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";

		return response;
	}

	// PUT - ATUALIZAR POR ID
	public BaseResponse atualizar(Long id, ContaRequest contaRequest) {

		Optional<Conta> contaJaExistente = _repository.findById(id);
		String hash = contaJaExistente.get().getHash();

		BaseResponse response = new BaseResponse();
		Conta conta = new Conta();
		response.statusCode = 400;

		if (contaRequest.getNome() == null || contaRequest.getNome() == "" ) {
			response.message = "Novo nome do cliente não foi preenchido.";
			return response;
		}

		conta.setId(id);
		conta.setNome(contaRequest.getNome());
		conta.setHash(hash);

		_repository.save(conta);

		response.statusCode = 200;
		response.message = "Conta Atualizada com sucesso.";
		return response;

	}

	// GET - EXIBE SALDO DE UMA CONTA HASH
	public ContaResponse saldo(String hash) {

		ContaResponse response = new ContaResponse();
		response.statusCode = 400;

		Conta conta = _repository.findByHash(hash);

		if (conta == null) {
			response.message = "Conta não encontrada!!";
			return response;
		}
		double saldo = _operacaoService.saldo(conta.getId());
		response.setSaldo(saldo);
		response.setNome(conta.getNome());
		response.setHash(conta.getHash());
		response.setId(conta.getId());
		
		response.message = "Saldo Calculado";
		response.statusCode = 200;
		return response;
	}
	
	// DELETE - DELETAR POR ID
//	public BaseResponse deletar(Long id) {
//		BaseResponse response = new BaseResponse();
//
//		if (id == null) {
//			response.statusCode = 400;
//			response.message = "Id de conta não existe";
//			return response;
//		}
//
//		_repository.deleteById(id);
//
//		response.statusCode = 200;
//		response.message = "Conta Excluida com sucesso!";
//		return response;
//	}
}