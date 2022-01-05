package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getRequestURI());
		String paramAcao = request.getParameter("acao");
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login")||paramAcao.equals("LoginForm")); 
		
		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		String nomeClasse = "br.com.alura.gerenciador.acao." + paramAcao.substring(0, 1).toUpperCase() + paramAcao.substring(1);
		
		String nome = null;
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Acao acao = (Acao) obj;
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			new ServletException(e);
		}
		
//		String nome = null;
//		
//		if (paramAcao.equals("listaEmpresa")) {
//			
//			ListaEmpresas listaEmpresa = new ListaEmpresas();
//			nome = listaEmpresa.executa(request,response);
//			
//		}else if (paramAcao.equals("removeEmpresa")) {
//			
//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//			nome = removeEmpresa.executa(request, response);
//			
//		}else if (paramAcao.equals("mostraEmpresa")) {
//			
//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
//			nome = mostraEmpresa.executa(request, response);
//			
//		}else if (paramAcao.equals("alteraEmpresa")) {
//			
//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//			nome = alteraEmpresa.executa(request,response);
//			
//		}else if (paramAcao.equals("novaEmpresa")) {
//			
//			NovaEmpresa novaEmpresa = new NovaEmpresa();
//			nome = novaEmpresa.executa(request, response);
//			
//		}else if (paramAcao.equals("novaEmpresaForm")) {
//			
//			NovaEmpresaForm novaEmpresa = new NovaEmpresaForm();
//			nome = novaEmpresa.executa(request, response);
//		}
		
		String[] tipoEEndereco = nome.split(":");
		
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	
	}

}
