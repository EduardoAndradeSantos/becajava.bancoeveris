package br.bancoeveris.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.bancoeveris.app.request.OperacaoRequest;
import br.bancoeveris.app.request.TransferenciaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.service.ContaService;

@SpringBootTest
public class OperacaoTest {

	@Autowired
	private OperacaoService operacaoService;
	@Autowired
	private ContaService contaService;

	@Test
	public void criarSaque() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
		request.setValor(1.0);

		BaseResponse response = operacaoService.criarSaque(request);
		Assertions.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void criarSaqueNomeNull() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash(null);
		request.setValor(1.00);

		BaseResponse response = operacaoService.criarSaque(request);
		Assertions.assertEquals(404, response.getStatusCode());

	}

	@Test
	public void criarSaqueValorNegativo() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
		request.setValor(-1.00);

		BaseResponse response = operacaoService.criarSaque(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}

	@Test
	public void criarSaqueValor0() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
		request.setValor(0.00);

		BaseResponse response = operacaoService.criarSaque(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}

	@Test
	public void criarDeposito() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
		request.setValor(1.0);

		BaseResponse response = operacaoService.criarDeposito(request);
		Assertions.assertEquals(200, response.getStatusCode());
	}

	@Test
	public void criarDepositoNomeNull() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash(null);
		request.setValor(1.00);

		BaseResponse response = operacaoService.criarDeposito(request);
		Assertions.assertEquals(404, response.getStatusCode());

	}

	@Test
	public void criarDepositoValorNegativo() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
		request.setValor(-1.00);

		BaseResponse response = operacaoService.criarDeposito(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}

	@Test
	public void criarDepositoValor0() {

		OperacaoRequest request = new OperacaoRequest();

		request.setHash("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
		request.setValor(0.00);

		BaseResponse response = operacaoService.criarDeposito(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}
	
	

	@Test
	public void criarTransferencia() {
	TransferenciaRequest obj = new TransferenciaRequest();
	obj.setHashOrigem("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
	obj.setHashDestino("0da6f956-7805-4572-80f2-39be8e065d98");
	obj.setValor(1.0);
	
	BaseResponse response = operacaoService.transferencia(obj);
	Assertions.assertEquals(200, response.getStatusCode());
	}
	
	
	@Test
	public void criarTransferenciaHashOrigemNull() {
	TransferenciaRequest obj = new TransferenciaRequest();
	obj.setHashOrigem(null);
	obj.setHashDestino("0da6f956-7805-4572-80f2-39be8e065d98");
	obj.setValor(1.0);
	
	BaseResponse response = operacaoService.transferencia(obj);
	Assertions.assertEquals(404, response.getStatusCode());
	}
	
	
	//Testes Transferencia
	@Test
	public void criarTransferenciaHashDestinomNull() {
	TransferenciaRequest obj = new TransferenciaRequest();
	obj.setHashOrigem("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
	obj.setHashDestino(null);
	obj.setValor(1.0);
	
	BaseResponse response = operacaoService.transferencia(obj);
	Assertions.assertEquals(404, response.getStatusCode());
	}
	
	@Test
	public void criarTransferenciaValor0() {
	TransferenciaRequest obj = new TransferenciaRequest();
	obj.setHashOrigem("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
	obj.setHashDestino("0da6f956-7805-4572-80f2-39be8e065d98");
	obj.setValor(0.0);
	
	BaseResponse response = operacaoService.transferencia(obj);
	Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarTransferenciaValorNegativo() {
	TransferenciaRequest obj = new TransferenciaRequest();
	obj.setHashOrigem("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
	obj.setHashDestino("0da6f956-7805-4572-80f2-39be8e065d98");
	obj.setValor(-1.0);
	
	BaseResponse response = operacaoService.transferencia(obj);
	Assertions.assertEquals(400, response.getStatusCode());
	}
	
	// Teste Saldo
	
	@Test
	public void saldo() {
		
		Long id = (1L);
		double response = operacaoService.saldo(id);
		
		//Assertions.assertEquals(response < 0);
		assertThat(response > 0);
		
	}
	

}
