package br.com.alura.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm {

	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "forward:formNovaEmpresa.jsp";
	}

}
