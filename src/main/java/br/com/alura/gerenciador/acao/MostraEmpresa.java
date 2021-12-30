package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("mostrando as Empresas");

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		System.out.println(empresa.getNome());
		
		request.setAttribute("empresa", empresa);
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//		rd.forward(request, response);
		
		return "forward:formAlteraEmpresa.jsp";
		
	}

}
