package br.bancoeveris.app.service;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import br.bancoeveris.app.request.OperacaoRequest;
//import br.bancoeveris.app.response.BaseResponse;

//@SpringBootTest
public class OperacaoTest {

//	@Autowired
//	private OperacaoService service;
//	
//	
//	@Test
//	public void criarSaque() {
//		
//		OperacaoRequest request = new OperacaoRequest();
//		
//		
//		request.setHash("WUF3hiotHK");
//		request.setValor(100.00);
//		
//		BaseResponse response = service.criarSaque(request);
//		Assertions.assertEquals(200, response.getStatusCode());
//		Assertions.assertEquals("Operação Realizada", response.getMessage());
//		
//	}
//	
//	@Test
//	public void criarSaqueNomeNull() {
//		
//		OperacaoRequest request = new OperacaoRequest();
//		
//		
//		request.setHash(null);
//		request.setValor(100.00);
//		
//		BaseResponse response = service.criarSaque(request);
//		Assertions.assertEquals(404, response.getStatusCode());
//		Assertions.assertEquals("Conta não encontrada", response.getMessage());
//		
//	}
//	
//	@Test
//	public void criarSaqueValorNegativo() {
//		
//		OperacaoRequest request = new OperacaoRequest();
//		
//		
//		request.setHash("WUF3hiotHK");
//		request.setValor(-100.00);
//		
//		BaseResponse response = service.criarSaque(request);
//		Assertions.assertEquals(400, response.getStatusCode());
//		Assertions.assertEquals("Valor Inválido", response.getMessage());
//		
//	}
//	
//	@Test
//	public void criarSaqueValor0() {
//		
//		OperacaoRequest request = new OperacaoRequest();
//		
//		
//		request.setHash("WUF3hiotHK");
//		request.setValor(0.00);
//		
//		BaseResponse response = service.criarSaque(request);
//		Assertions.assertEquals(400, response.getStatusCode());
//		Assertions.assertEquals("Valor Inválido", response.getMessage());
//		
//	}
	
}
