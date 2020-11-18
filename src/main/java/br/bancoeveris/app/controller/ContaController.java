package br.bancoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.bancoeveris.app.request.ContaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.response.ContaResponse;
import br.bancoeveris.app.response.ListContaResponse;
import br.bancoeveris.app.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController extends BaseController {

	// PROPRIEDADES
	@Autowired
	private  ContaService _service;

	// POST - CRIAR
	@PostMapping
	public ResponseEntity<BaseResponse> inserir(@RequestBody ContaRequest contaRequest) {
		try {
			BaseResponse response = _service.inserir(contaRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - OBTER POR ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {

			ContaResponse contaResponse = _service.obter(id);
			return ResponseEntity.status(contaResponse.statusCode).body(contaResponse);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - OBTER TUDO
	@GetMapping
	public ResponseEntity<BaseResponse> listar() {
		try {
			ListContaResponse contas = _service.listar();
			return ResponseEntity.status(contas.statusCode).body(contas);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// PUT - ATUALIZAR
	@PutMapping(path = "/{id}")
	public ResponseEntity<BaseResponse>atualizar(@RequestBody ContaRequest contaRequest, @PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, contaRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// DELETE - DELETAR
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> deletar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.deletar(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// GET - PEGAR SALDO
	@GetMapping(path = "/saldo/{hash}")
	public ResponseEntity<BaseResponse> Saldo(@PathVariable String hash) {
		try {
			BaseResponse response = _service.Saldo(hash);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
}