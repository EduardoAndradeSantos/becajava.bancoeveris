package br.bancoeveris.app.controller;

import br.bancoeveris.app.response.BaseResponse;

public class BaseController {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.statusCode = 500;
		errorBase.message = "Ocorreu um erro inesperado. Contate o administrador";
	}

}