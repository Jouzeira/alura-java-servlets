<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/removeEmpresa" var="linkRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="linkMostraEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	</br>

	Lista de empresas:
	</br>
	<ul>
		<%
			List<Empresa> lista = (List) request.getAttribute("empresas");
		if(lista != null){
	        for (Empresa empresa : lista) { 
       	%>
       		<li><%= empresa.getNome() %></li>
       	<%
	        }
		}
		%>
	</ul>
	</br>
	</br>
	Lista de empresas2:
	</br>
	<ul>
		<c:forEach items="${empresas}" var="emp">
			<li>
				${emp.nome} - <fmt:formatDate value="${emp.dataAbertura}" pattern="dd/MM/yyyy"/> - 
				<a href="${linkMostraEmpresa}?id=${emp.id}">editar</a> - 
				<a href="${linkRemoveEmpresa}?id=${emp.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>