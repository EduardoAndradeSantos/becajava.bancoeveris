package br.bancoeveris.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.bancoeveris.app.request.ContaRequest;
import br.bancoeveris.app.response.BaseResponse;
import br.bancoeveris.app.response.ContaResponse;
import br.bancoeveris.app.response.ListContaResponse;
import br.bancoeveris.app.service.implement.ContaServiceImp;

@SpringBootTest
public class ContaTest {

	@Autowired
	ContaService contaService;

	@Test
	public void criarConta() {
		ContaRequest request = new ContaRequest();

		request.setNome("Igor");

		BaseResponse response = contaService.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Hash Gerado automaticamente na Conta criada!!", response.getMessage());
	}

	@Test
	public void criarContaNull() {
		ContaRequest request = new ContaRequest();

		request.setNome(null);

		BaseResponse response = contaService.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O Nome do cliente não foi preenchido.", response.getMessage());
	}

	@Test
	public void criarContaVazio() {
		ContaRequest request = new ContaRequest();

		request.setNome("");

		BaseResponse response = contaService.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O Nome do cliente não foi preenchido.", response.getMessage());
	}

	@Test
	public void saldoHash() {

		String hash = "53ec42ec-d5d2-40a8-8cd1-005299e0d513";

		ContaResponse response = contaService.saldo(hash);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Saldo Calculado", response.getMessage());
	}

	@Test
	public void saldoHashNull() {

		String hash = "00000";

		ContaResponse response = contaService.saldo(hash);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void obterPorId() {

		ContaResponse response = contaService.obter(1L);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Conta obtida com sucesso.", response.getMessage());

	}

	@Test
	public void obterPorId0() {

		ContaResponse response = contaService.obter(0L);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id não encontrado.", response.getMessage());

	}
	
	@Test
	public void obterPorIdNegativo() {

		ContaResponse response = contaService.obter(-1L);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id não encontrado.", response.getMessage());

	}
	
	@Test
	public void listar() {
		
		ListContaResponse response = contaService.listar();
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Clientes obtidos com sucesso.", response.getMessage());
		assertThat(!response.getContas().isEmpty());
	}
	
	
	@Test
	public void atualizarPorId() {
		
		ContaRequest request = new ContaRequest();
		request.setNome("Danilo");
		
		BaseResponse response = contaService.atualizar(4L, request);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Conta Atualizada com sucesso.", response.getMessage());
	}

	
	@Test
	public void atualizarPorIdVazio() {
		
		ContaRequest request = new ContaRequest();
		request.setNome("");
		
		BaseResponse response = contaService.atualizar(1L, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Novo nome do cliente não foi preenchido.", response.getMessage());
	}
	
	@Test
	public void atualizarPorIdNull() {
		
		ContaRequest request = new ContaRequest();
		request.setNome(null);
		
		BaseResponse response = contaService.atualizar(1L, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Novo nome do cliente não foi preenchido.", response.getMessage());
	}
	
	
//	@Test
//	public void calculaSaldo() {
//			
//		BaseResponse response = contaService.saldo("53ec42ec-d5d2-40a8-8cd1-005299e0d513");
//		Assertions.assertEquals(200, response.getStatusCode());
//	}
	
	
}

