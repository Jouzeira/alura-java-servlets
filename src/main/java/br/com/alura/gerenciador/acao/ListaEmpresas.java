package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("listando as Empresas");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
//		PrintWriter out = response.getWriter();
//
//        out.println("<html><body>");
//        out.println("<ul>");
//        for (Empresa empresa : lista) { 
//            out.println("<li>" + empresa.getNome() + "</li>");
//        }
//        out.println("</ul>");
//        out.println("</body></html>");
		
		request.setAttribute("empresas", lista);
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
//		rd.forward(request, response);
		
		return "forward:listaEmpresas.jsp";

	}			

}
