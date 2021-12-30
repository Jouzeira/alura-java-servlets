package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("data");
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
//		response.sendRedirect("listaEmpresa");
//		response.sendRedirect("entrada?acao=listaEmpresa");
		return "redirect:entrada?acao=listaEmpresa";
		
		
		
	}

}
