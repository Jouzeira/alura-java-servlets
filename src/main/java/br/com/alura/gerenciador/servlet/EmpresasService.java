package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String header = request.getHeader("Accept");
		
		System.out.println(header);
		
		if (header.contains("xml")) {
//		if (header.endsWith("xml")) {
			
			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
			
		}else if (header.contains("json")) {
			
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			System.out.println("json: " +json);
//			List<Empresa> fromJson = (List<Empresa>) gson.fromJson(json, Empresa.class);
//			List<Empresa> fromJson = Arrays.asList(gson.fromJson(json, Empresa.class));
			Empresa[] fromJson = gson.fromJson(json, Empresa[].class);
			
			for(Empresa emp : fromJson) {
				System.out.println(emp);
			}
			System.out.println("Object: " +fromJson[0].getNome());
			
			
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		}else {
			
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
			
		}
		
		

	}

}
