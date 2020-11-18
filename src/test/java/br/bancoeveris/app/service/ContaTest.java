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
	ContaService service;

	@Test
	public void criarConta() {
		ContaRequest request = new ContaRequest();

		request.setNome("Igor");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Hash Gerado automaticamente na Conta criada!!", response.getMessage());
	}

	@Test
	public void criarContaNull() {
		ContaRequest request = new ContaRequest();

		request.setNome(null);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O Nome do cliente não foi preenchido.", response.getMessage());
	}

	@Test
	public void criarContaVazio() {
		ContaRequest request = new ContaRequest();

		request.setNome("");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O Nome do cliente não foi preenchido.", response.getMessage());
	}

	@Test
	public void saldo() {

		String hash = "A1";

		ContaResponse response = service.Saldo(hash);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Saldo Calculado", response.getMessage());
	}

	@Test
	public void saldoNull() {

		String hash = "123456";

		ContaResponse response = service.Saldo(hash);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Conta não encontrada!!", response.getMessage());
	}

	@Test
	public void obterPorId() {

		ContaResponse response = service.obter(1L);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Conta obtida com sucesso.", response.getMessage());

	}

	@Test
	public void obterPorId0() {

		ContaResponse response = service.obter(0L);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id não encontrado.", response.getMessage());

	}
	
	@Test
	public void obterPorIdNegativo() {

		ContaResponse response = service.obter(-1L);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Id não encontrado.", response.getMessage());

	}
	
	@Test
	public void listar() {
		
		ListContaResponse response = service.listar();
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Clientes obtidos com sucesso.", response.getMessage());
		assertThat(!response.getContas().isEmpty());
	}
	
	
	@Test
	public void atualizarPorId() {
		
		ContaRequest request = new ContaRequest();
		request.setNome("Danilo");
		
		BaseResponse response = service.atualizar(4L, request);
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Conta Atualizada com sucesso.", response.getMessage());
	}

	
	@Test
	public void atualizarPorIdVazio() {
		
		ContaRequest request = new ContaRequest();
		request.setNome("");
		
		BaseResponse response = service.atualizar(1L, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Novo nome do cliente não foi preenchido.", response.getMessage());
	}
	
	@Test
	public void atualizarPorIdNull() {
		
		ContaRequest request = new ContaRequest();
		request.setNome(null);
		
		BaseResponse response = service.atualizar(1L, request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("Novo nome do cliente não foi preenchido.", response.getMessage());
	}
	
	
	
}

