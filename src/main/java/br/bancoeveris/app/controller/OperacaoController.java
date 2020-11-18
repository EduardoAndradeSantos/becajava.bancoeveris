package br.bancoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bancoeveris.app.request.OperacaoRequest;
import br.bancoeveris.app.request.TransferenciaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.service.OperacaoService;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController extends BaseController {

	// PROPRIEDADES
	@Autowired
	private OperacaoService _service;

	// POST - FAZ SAQUE
	@PostMapping(path = "/saque")
	public ResponseEntity<BaseResponse> criarSaque(@RequestBody OperacaoRequest operacaoRequest) {
		try {
			BaseResponse response = _service.criarSaque(operacaoRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// POST - FAZ DEPOSITO
	@PostMapping(path = "/deposito")
	public ResponseEntity<BaseResponse> criarDeposito(@RequestBody OperacaoRequest operacaoRequest) {
		try {
			BaseResponse response = _service.criarDeposito(operacaoRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	// POST - FAZ TRANSFERENCIA
	@PostMapping(path = "/transferencia")
	public ResponseEntity<BaseResponse> transferencia(@RequestBody TransferenciaRequest transferenciaRequest) {
		try {
			BaseResponse response = _service.transferencia(transferenciaRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
}