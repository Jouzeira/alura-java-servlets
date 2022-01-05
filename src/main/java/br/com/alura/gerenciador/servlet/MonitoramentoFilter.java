package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		System.out.println(antes);
		
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println(depois);
		
		System.out.println("Tempo de Execu��o da a��o "+request.getParameter("acao")+": " + (depois-antes));
		
	}

}
